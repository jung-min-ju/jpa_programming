package example.chap_6.ManyToMany.non_identifying;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Chap6_MTM_PRODUCT_NON_IDEN {

    @Id
    @Column(name="product_id")
    private String id;

    private String name;
}
