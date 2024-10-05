package chap_6.OneToMany;

import example.JpaApplication;
import example.chap_6.OneToMany.Chap6_OTM_Member;
import example.chap_6.OneToMany.Chap6_OTM_Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = JpaApplication.class)
@Transactional
class Chap6_OTM_Test {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void testSave() {
        // 트랜잭션 시작 (Spring의 @Transactional 덕분에 트랜잭션이 자동으로 관리됨)
        try {
            // Member 엔티티 생성
            Chap6_OTM_Member member1 = new Chap6_OTM_Member();
            member1.setUsername("member1");

            Chap6_OTM_Member member2 = new Chap6_OTM_Member();
            member2.setUsername("member2");

            // Team 엔티티 생성
            Chap6_OTM_Team team1 = new Chap6_OTM_Team();
            team1.setName("team1");

            // Team 엔티티에 멤버 추가 (양방향 관계 설정)
            team1.getMembers().add(member1);
            team1.getMembers().add(member2);

            // 엔티티 저장 (양방향 매핑이므로 외래 키가 업데이트됨)
            em.persist(member1); // INSERT member1
            em.persist(member2); // INSERT member2
            em.persist(team1);   // INSERT team1, UPDATE member1.fk, UPDATE member2.fk

            // 트랜잭션 커밋은 @Transactional에 의해 자동으로 처리됨
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);  // 예외 발생 시 트랜잭션 롤백
        }
    }
}
