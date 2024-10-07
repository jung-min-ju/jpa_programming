package example.chap_6.ManyToMany.non_identifying;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Chap6_MTM_Member_NON_IDEN {

    @Id
    @Column(name="member_id")
    private String id;

    private String username;

    //역방향
    @OneToMany(mappedBy = "member")
    private List<Chap6_MTM_Orders_NON_IDEN> orders = new ArrayList<>();

}
