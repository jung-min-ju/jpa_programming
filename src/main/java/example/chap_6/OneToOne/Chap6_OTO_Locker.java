    package example.chap_6.OneToOne;

    import jakarta.persistence.*;

    @Entity
    public class Chap6_OTO_Locker { //대상 테이블

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="LOCKER_ID")
        private Long id;

        private String name;

//        @OneToOne(mappedBy = "locker")
//        private Chap6_OTO_Member member;
        // 일대일 관계 중 대상 테이블에 외래키가 있는 단방향 관계는 JPA에서 지원하지 않는다.
        // 방법1 : 단방향 관계를 현재(member->locker)에서 (locekr->member)로 수정
        // 방법2 : 양방향 관계로 만들고 Locker를 연관관계의 주인으로 설정해야 함.

        //여기까진 단방향 설정
        // ----------------------------------
        //여기서부턴 양방향 설정

        @OneToOne
        @JoinColumn(name = "member_id") // 외래 키를 가지고 있는 쪽이 연관관계의 주인
        private Chap6_OTO_Member member;


    }
