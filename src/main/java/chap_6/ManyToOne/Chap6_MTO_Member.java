package chap_6.ManyToOne;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Chap6_MTO_Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Chap6_MTO_Team team;


}
