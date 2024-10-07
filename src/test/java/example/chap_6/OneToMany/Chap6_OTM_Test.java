package example.chap_6.OneToMany;

import example.JpaApplication;
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

            System.out.println("member1, 2 생성");
            // Member 엔티티 생성
            Chap6_OTM_Member member1 = new Chap6_OTM_Member();
            member1.setUsername("member1");

            Chap6_OTM_Member member2 = new Chap6_OTM_Member();
            member2.setUsername("member2");

            System.out.println("team1 생성");
            // Team 엔티티 생성
            Chap6_OTM_Team team1 = new Chap6_OTM_Team();
            team1.setName("team1");

            System.out.println("Team 엔티티에 멤버 추가 (단방향)");
            // Team 엔티티에 멤버 추가 (단방향 체크)
            team1.getMembers().add(member1);
            team1.getMembers().add(member2);

            System.out.println("영속성 컨텍스트 저장");
            // 엔티티 저장 (team을 저장하기 전 상태)
            em.persist(member1); // INSERT member1
            em.persist(member2); // INSERT member2

            // flush로 변경 사항을 DB에 반영, clear로 영속성 컨텍스트 초기화
            em.flush();
            em.clear();

            // team을 저장하기 전에 DB에서 member의 TEAM_ID가 null인지 네이티브 쿼리로 확인
            String sql = "SELECT team_id FROM chap6_otm_member WHERE member_id = :memberId";
            Object result1 = em.createNativeQuery(sql)
                    .setParameter("memberId", member1.getId())
                    .getSingleResult();

            Object result2 = em.createNativeQuery(sql)
                    .setParameter("memberId", member2.getId())
                    .getSingleResult();

            // team 저장 전 member 엔티티의 Team_id가 null인지 확인
            System.out.println("team 저장 전 member1 엔티티의 Team_id == null ? " + (result1 == null)); // 예상: true
            System.out.println("team 저장 전 member2 엔티티의 Team_id == null ? " + (result2 == null)); // 예상: true

            // 이제 team을 저장
            em.persist(team1);   // INSERT team1, UPDATE member1.fk, UPDATE member2.fk

            // flush 및 clear 후 DB에서 외래키 값 확인
            em.flush();
            em.clear();

            Object updatedResult1 = em.createNativeQuery(sql)
                    .setParameter("memberId", member1.getId())
                    .getSingleResult();

            Object updatedResult2 = em.createNativeQuery(sql)
                    .setParameter("memberId", member2.getId())
                    .getSingleResult();

            System.out.println("team 저장 후 member1 엔티티의 Team_id == team1의 id ? " + updatedResult1); // 예상: team1의 ID
            System.out.println("team 저장 후 member2 엔티티의 Team_id == team1의 id ? " + updatedResult2); // 예상: team1의 ID

            // 트랜잭션 커밋은 @Transactional에 의해 자동으로 처리됨
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);  // 예외 발생 시 트랜잭션 롤백
        }
    }
}

//해당 방식의 문제점
// 본인 데이블에 외래 키가 있으면 엔티티의 저장과 연관관계 처리를 INSERT SQL 한 번으로 끝낼 수 있지만.
// 다른 테이불에 외래 키가 있으면 연관관계 처리를 위한 UPDATE SQL을 추가로 실행해야 한다! (성능상 참 별로다.)
