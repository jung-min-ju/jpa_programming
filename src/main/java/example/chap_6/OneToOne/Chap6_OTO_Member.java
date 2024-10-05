package example.chap_6.OneToOne;

import jakarta.persistence.*;

@Entity
public class Chap6_OTO_Member { //주테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;

    private String username;

//    @OneToOne
//    @JoinColumn(name = "locker_id")
//    private Chap6_OTO_Locker locker; //단방향에서는 연관관계의 주인이었음

    //여기까진 단방향 설정
    // ----------------------------------
    //여기서부턴 양방향 설정

    @OneToOne(mappedBy = "member")
    private Chap6_OTO_Locker locker;
    //일대일 매핑에서 대상 태이불에 외래 키를 두고 싶으면 이렇게 양방향으로 매핑함
    //주 엔티티인 Member 엔티티 대신에 대상 엔티티인 Locker룰 연관관계의 주인으로 만듦

}
