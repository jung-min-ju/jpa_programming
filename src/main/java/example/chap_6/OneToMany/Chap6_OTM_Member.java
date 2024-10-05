package example.chap_6.OneToMany;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "chap6_otm_member")
@Data
public class Chap6_OTM_Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;

    //여기까진 단방향 설정
    // ----------------------------------
    //여기서부턴 양방향 설정

    @ManyToOne
    @JoinColumn(name="team_id")
    private Chap6_OTM_Team team; //"다대일" 관계이기에 외래키 관리를 "다"에서 한다.

//    public void setTeam(Chap6_OTM_Team team){
//        this.team = team;
//
//        //무한루프에 빠지지 않도록 체크
//        if(!team.getMembers().contains(this)) {
//            team.getMembers().add(this);
//        }
//    }

}
