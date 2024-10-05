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


    //중간엔티티 미사용 -> 주석해제
    // ----------------------------------
    //중간엔티티 사용 -> 주석처리
//
//    @ManyToMany(mappedBy = "products" ) //역방향 추가
//    private List<Chap6_MTM_Member> members = new ArrayList<>();


}
