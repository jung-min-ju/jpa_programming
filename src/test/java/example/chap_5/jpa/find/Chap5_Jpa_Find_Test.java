package example.chap_5.jpa.find;

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
class Chap5_Jpa_Find_Test {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void jpql_test() {
        //팀1 저장
        System.out.println("팀1 저장");
        Chap5_Jpa_Team team1 = new Chap5_Jpa_Team();
        team1.setId("team1");
        team1.setName("팀1");
        em.persist(team1);
        em.flush();

        //회원1 저장
        System.out.println("회원1 저장");
        Chap5_Jpa_Member member1 = new Chap5_Jpa_Member();
        member1.setId("member1");
        member1.setUsername("멤버1");
        member1.setTeam(team1);
        em.persist(member1);

        em.flush();
        em.clear();

        System.out.println("조회");
        // MEMBER 객체를 ID로 조회
        Chap5_Jpa_Member member = em.find(Chap5_Jpa_Member.class, "member1");
        em.flush();

        System.out.println("팀 정보 가져오기 : 프록시 객체가 어디서 실제 객체로 바뀌려나?");

        // 연관된 팀 정보 탐색
        Chap5_Jpa_Team team = member.getTeam(); //여기서 프록시 객체->실제 객체로 변환
        em.flush();
        if (team != null) {
            System.out.println("팀 이름: " + team.getName());
            em.flush(); // 팀 이름 출력
        } else {
            System.out.println("팀 정보가 없습니다.");
        }
    }

}