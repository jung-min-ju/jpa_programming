package example.chap_6.OneToMany;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Chap6_OTM_Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name="TEAM_ID")
    //JoinColumn(name="TEAM_ID", insertable = false, updatable = false) //MEMBER의 테이블의 TEAM_ID (FK) ->
    private List<Chap6_OTM_Member> members = new ArrayList<>();
    //"일대다"의 단방향 : 팀 -> 회원들 참조 0 / 회원 -> 팀을 참조
    //여기까진 단방향 설정
    // ----------------------------------
    //여기서부턴 양방향 설정

//    public void addMembers(Chap6_OTM_Member member){
//        this.members.add(member);
//        if(member.getTeam() != this) { //편의 메소드를 양쪽에 다 작성했을 시, 무한 루프에 빠지지 않도록 체크
//            member.setTeam(this);      //예제 코드에선 양쪽에 다 작성했는데, 실제에선 그냥 둘 중 하나에만 만들어두면 됨.
//        }
//    }
}
