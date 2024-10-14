package example.chap_7.InheritanceMapping.tablePerClass;

import example.chap_7.InheritanceMapping.join.Chap7_IM_JOIN_Item;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("A")
@Data
public class Chap7_IM_TPC_Album extends Chap7_IM_TPC_Item {

    private String artist;
    // 추가 필드 및 메서드

}
