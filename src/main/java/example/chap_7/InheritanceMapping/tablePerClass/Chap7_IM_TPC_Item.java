package example.chap_7.InheritanceMapping.tablePerClass;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "DTYPE")
@Data
public class Chap7_IM_TPC_Item {

    @Id
    @GeneratedValue
    @Column(name = "ITEM_ID") //부모의 기본키를 기본 키 + 외래 키로 사용
    private Long id;

    private String name;
    private int price;

}
