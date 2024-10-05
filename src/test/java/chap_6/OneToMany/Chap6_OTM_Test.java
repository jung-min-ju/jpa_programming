package chap_6.OneToMany;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Chap6_OTM_Test {
    @Test
    public void testSave() {
        // EntityManager와 트랜잭션 초기화
        EntityManager em = Persistence.createEntityManagerFactory("chap6").createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin(); // 트랜잭션 시작

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

            transaction.commit(); // 트랜잭션 커밋
        } catch (Exception e) {
            transaction.rollback(); // 오류 발생 시 롤백
            e.printStackTrace();
        } finally {
            em.close(); // EntityManager 종료
        }
    }
}