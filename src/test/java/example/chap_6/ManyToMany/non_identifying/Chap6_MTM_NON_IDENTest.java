package example.chap_6.ManyToMany.non_identifying;

import example.JpaApplication;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest(classes = JpaApplication.class)
@Transactional
class Chap6_MTM_NON_IDENTest {

    @PersistenceContext
    private EntityManager em;
    private Long savedOrderId;  // 저장된 Order의 ID를 담기 위한 필드

    @Test
    public void testSaveAndFind() {
        // 트랜잭션 시작
        try {
            save();
            em.flush();
            em.clear();
            find();
            em.flush();
            em.clear();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);  // 예외 발생 시 트랜잭션 롤백
        }
    }

    public void save() {
        // 회원1 생성 및 저장
        System.out.println("회원1 생성 및 저장");
        Chap6_MTM_Member_NON_IDEN member1 = new Chap6_MTM_Member_NON_IDEN();
        member1.setId("member1");
        member1.setUsername("회원1");
        em.persist(member1);

        // 상품A 생성 및 저장
        System.out.println("상품A 생성 및 저장");
        Chap6_MTM_PRODUCT_NON_IDEN productA = new Chap6_MTM_PRODUCT_NON_IDEN();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        // 회원상품 저장
        System.out.println("회원상품 저장");
        Chap6_MTM_Orders_NON_IDEN orders = new Chap6_MTM_Orders_NON_IDEN();
        orders.setMember(member1);
        orders.setProduct(productA);
        orders.setOrderAmount(2); //주문 수량 저장
        em.persist(orders);

        // persist 후 자동으로 생성된 ID 값 저장
        savedOrderId = orders.getId();  // 자동 생성된 ID를 저장
        System.out.println("저장된 주문의 ID: " + savedOrderId);
    }

    public void find() {
        Chap6_MTM_Orders_NON_IDEN order = em.find(Chap6_MTM_Orders_NON_IDEN.class, savedOrderId);

        Chap6_MTM_Member_NON_IDEN member = order.getMember();
        Chap6_MTM_PRODUCT_NON_IDEN product = order.getProduct();

        System.out.println("member = " + member.getUsername());
        System.out.println("product = " + product.getName());
        System.out.println("orderAmount = " + order.getOrderAmount());
    }

}