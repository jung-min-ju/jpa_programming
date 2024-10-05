package example.chap_6.ManyToMany;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Chap6_MTM_PRODUCT {

    @Id
    @Column(name="product_id")
    private String id;

    private String name;

    @ManyToMany(mappedBy = "products" ) //역방향 추가
    private List<Chap6_MTM_Member> members = new ArrayList<>();


}
