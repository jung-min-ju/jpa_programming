package example.chap_7.InheritanceMapping.singleTable;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DTYPE")
@Data
public class Chap7_IM_ST_Item {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID") //부모의 기본키를 기본 키 + 외래 키로 사용
    private Long id;

    private String name;
    private int price;

}
