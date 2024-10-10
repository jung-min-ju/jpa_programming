package example.chap_5.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Chap5_Jpa_Team {
    @Id
    @Column(name = "TEAM_ID")
    private String id;

    @Column(name="TEAM_NAME")
    private String name;
}
