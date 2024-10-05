package example.chap_6.ManyToMany;

import example.JpaApplication;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = JpaApplication.class)
@Transactional
class Chap6_MTM_MemberProductTest {
    @PersistenceContext
    private EntityManager em;

    @Test
    public void testSaveAndFind() {
        // 트랜잭션 시작
        try {
            save();
            find();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);  // 예외 발생 시 트랜잭션 롤백
        }
    }

    public void save() {
        // 회원1 생성 및 저장
        System.out.println("회원1 생성 및 저장");
        Chap6_MTM_Member member1 = new Chap6_MTM_Member();
        member1.setId("member1");
        member1.setUsername("회원1");
        em.persist(member1);

        // 상품A 생성 및 저장
        System.out.println("상품A 생성 및 저장");
        Chap6_MTM_PRODUCT productA = new Chap6_MTM_PRODUCT();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        // 회원상품 저장
        System.out.println("회원상품 저장");
        Chap6_MTM_MemberProduct memberProduct = new Chap6_MTM_MemberProduct();
        memberProduct.setMember(member1);
        memberProduct.setProduct(productA);
        memberProduct.setOrderAmount(2); //주문 수량 저장
        em.persist(memberProduct);
    }

    public void find(){
        //기본 키 값 생성
        Chap6_MTM_MemberProductId memberProductId = new Chap6_MTM_MemberProductId();
        memberProductId.setMember("member1");
        memberProductId.setProduct("productA");

        Chap6_MTM_MemberProduct memberProduct = em.find(Chap6_MTM_MemberProduct.class, memberProductId);

        Chap6_MTM_Member member = memberProduct.getMember();
        Chap6_MTM_PRODUCT product = memberProduct.getProduct();

        System.out.println("member = " + member.getUsername());
        System.out.println("product = " + product.getName());
        System.out.println("orderAmount = "+memberProduct.getOrderAmount());

    }
}
