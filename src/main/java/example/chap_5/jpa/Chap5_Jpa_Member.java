package example.chap_5.jpa;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Chap5_Jpa_Member {

    @Id
    @Column(name="MEMBER_ID")
    private String id;

    @Column(name = "MEMBER_USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name="team_id")
    private Chap5_Jpa_Team team;
}
