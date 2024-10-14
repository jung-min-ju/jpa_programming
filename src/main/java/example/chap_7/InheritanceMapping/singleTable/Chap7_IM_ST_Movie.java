package example.chap_7.InheritanceMapping.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;


@Entity
@DiscriminatorValue("M")
@Data
public class Chap7_IM_ST_Movie extends Chap7_IM_ST_Item {

    private String director;
    private String actor;
    // 추가 필드 및 메서드

}
