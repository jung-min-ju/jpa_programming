package chap_6.ManyToOne;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Chap6_MTO_Team {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    //단방향 일 때는 team 엔티티에 member 참조하는 필드 없음

    //여기까진 단방향 설정
    // ----------------------------------
    //여기서부턴 양방향 설정

    @OneToMany(mappedBy = "team")
    private List<Chap6_MTO_Member> members = new ArrayList<>();
    //주인이 아닌 Team.members는 조회를 위한 jpql이나 객체 그래프를 탐색할 때 사용

    public void addMembers(Chap6_MTO_Member member){
        this.members.add(member);
        if(member.getTeam() != this) { //편의 메소드를 양쪽에 다 작성했을 시, 무한 루프에 빠지지 않도록 체크
            member.setTeam(this);      //예제 코드에선 양쪽에 다 작성했는데, 실제에선 그냥 둘 중 하나에만 만들어두면 됨.
        }
    }
}
