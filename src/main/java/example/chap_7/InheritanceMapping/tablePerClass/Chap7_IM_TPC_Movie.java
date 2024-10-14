package example.chap_7.InheritanceMapping.tablePerClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;


@Entity
@DiscriminatorValue("M")
@Data
public class Chap7_IM_TPC_Movie extends Chap7_IM_TPC_Item {

    private String director;
    private String actor;
    // 추가 필드 및 메서드

}
