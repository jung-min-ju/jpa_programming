package example.chap_6.ManyToMany.iden;

import example.JpaApplication;
import example.chap_6.ManyToMany.identifying.Chap6_MTM_MemberProductId_IDEN;
import example.chap_6.ManyToMany.identifying.Chap6_MTM_MemberProduct_IDEN;
import example.chap_6.ManyToMany.identifying.Chap6_MTM_Member_IDEN;
import example.chap_6.ManyToMany.identifying.Chap6_MTM_PRODUCT_IDEN;
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
        Chap6_MTM_Member_IDEN member1 = new Chap6_MTM_Member_IDEN();
        member1.setId("member1");
        member1.setUsername("회원1");
        em.persist(member1);

        // 상품A 생성 및 저장
        System.out.println("상품A 생성 및 저장");
        Chap6_MTM_PRODUCT_IDEN productA = new Chap6_MTM_PRODUCT_IDEN();
        productA.setId("productA");
        productA.setName("상품A");
        em.persist(productA);

        // 회원상품 저장
        System.out.println("회원상품 저장");
        Chap6_MTM_MemberProduct_IDEN memberProduct = new Chap6_MTM_MemberProduct_IDEN();
        memberProduct.setMember(member1);
        memberProduct.setProduct(productA);
        memberProduct.setOrderAmount(2); //주문 수량 저장
        em.persist(memberProduct);
    }

    public void find(){
        //기본 키 값 생성
        Chap6_MTM_MemberProductId_IDEN memberProductId = new Chap6_MTM_MemberProductId_IDEN();
        memberProductId.setMember("member1");
        memberProductId.setProduct("productA");

        Chap6_MTM_MemberProduct_IDEN memberProduct = em.find(Chap6_MTM_MemberProduct_IDEN.class, memberProductId);

        Chap6_MTM_Member_IDEN member = memberProduct.getMember();
        Chap6_MTM_PRODUCT_IDEN product = memberProduct.getProduct();

        System.out.println("member = " + member.getUsername());
        System.out.println("product = " + product.getName());
        System.out.println("orderAmount = "+memberProduct.getOrderAmount());

    }
}
