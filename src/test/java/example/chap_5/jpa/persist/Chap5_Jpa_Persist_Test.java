package example.chap_5.jpa.persist;

import example.JpaApplication;
import example.chap_5.jpa.Chap5_Jpa_Member;
import example.chap_5.jpa.Chap5_Jpa_Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = JpaApplication.class)
@Transactional
class Chap5_Jpa_Persist_Test {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void testSave() {

        //팀1 저장
        System.out.println("팀1 저장");
        Chap5_Jpa_Team team1 = new Chap5_Jpa_Team();
        team1.setId("team1");
        team1.setName("팀1");
        em.persist(team1);

        //회원1 저장
        System.out.println("회원1 저장");
        Chap5_Jpa_Member member1 = new Chap5_Jpa_Member();
        member1.setId("member1");
        member1.setUsername("멤버1");
        member1.setTeam(team1);
        em.persist(member1);

        //회원2 저장
        System.out.println("회원2 저장");
        Chap5_Jpa_Member member2 = new Chap5_Jpa_Member();
        member2.setId("member2");
        member2.setUsername("멤버2");
        member2.setTeam(team1);
        em.persist(member2);

        //jpa에서 엔티티를 저장할 때 모든 엔티티는 영속 상태여야 한다!

    }


}