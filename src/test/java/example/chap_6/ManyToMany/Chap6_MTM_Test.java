package example.chap_6.ManyToMany;

import example.JpaApplication;
import example.chap_6.ManyToMany.identifying.Chap6_MTM_Member_IDEN;
import example.chap_6.ManyToMany.identifying.Chap6_MTM_PRODUCT_IDEN;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = JpaApplication.class)
@Transactional
class Chap6_MTM_Test {
    @PersistenceContext
    private EntityManager em;

    @Test
    public void testSave() {
        // 트랜잭션 시작
        try {
            // 상품A 생성 및 저장
            System.out.println("상품A 생성 및 저장");
            Chap6_MTM_PRODUCT_IDEN productA = new Chap6_MTM_PRODUCT_IDEN();
            productA.setId("productA");
            productA.setName("상품A");
            em.persist(productA);

            // 회원1 생성 및 저장
            System.out.println("회원1 생성 및 저장");
            Chap6_MTM_Member_IDEN member1 = new Chap6_MTM_Member_IDEN();
            member1.setId("member1");
            member1.setUsername("회원1");
//            member1.addProducts(productA); //양방향 편의 메서드 사용
            em.persist(member1);

            // 영속성 컨텍스트 초기화 후 탐색
            em.flush();

            System.out.println("회원1 재조회 (정방향 조회)");
            // 회원1을 다시 조회하고 연관된 상품 조회 (정방향)
            Chap6_MTM_Member_IDEN foundMember = em.find(Chap6_MTM_Member_IDEN.class, "member1");
           //List<Chap6_MTM_PRODUCT> products = foundMember.getProducts();

//            System.out.println("회원1과 연관된 상품 (정방향 조회)");
//            for (Chap6_MTM_PRODUCT product : products) {
//                System.out.println("product.name = " + product.getName());
//            }
//
//            System.out.println("\n상품A로 회원 조회 (역방향 조회)");
//            // 상품A에서 연관된 회원 조회 (역방향)
//            Chap6_MTM_PRODUCT foundProduct = em.find(Chap6_MTM_PRODUCT.class, "productA");
//            List<Chap6_MTM_Member> members = foundProduct.getMembers();
//
//            System.out.println("상품A와 연관된 회원 (역방향 조회)");
//            for (Chap6_MTM_Member member : members) {
//                System.out.println("member.username = " + member.getUsername());
//            }

//            // 정방향과 역방향 결과 비교
//            System.out.println("\n정방향과 역방향 조회 결과 비교");
//            if (products.contains(productA) && members.contains(member1)) {
//                System.out.println("정방향 조회와 역방향 조회 결과가 같습니다.");
//            } else {
//                System.out.println("정방향 조회와 역방향 조회 결과가 다릅니다.");
//            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);  // 예외 발생 시 트랜잭션 롤백
        }
    }
}
