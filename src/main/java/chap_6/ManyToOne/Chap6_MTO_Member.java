package chap_6.ManyToOne;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Getter
public class Chap6_MTO_Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Chap6_MTO_Team team; //"다대일" 관계이기에 외래키 관리를 "다"에서 한다.

    //여기까진 단방향 설정
    // ----------------------------------
    //여기서부턴 양방향 설정
    public void setTeam(Chap6_MTO_Team team){
        this.team = team;

        //무한루프에 빠지지 않도록 체크
        if(!team.getMembers().contains(this)) {
            team.getMembers().add(this);
        }
    }

}
