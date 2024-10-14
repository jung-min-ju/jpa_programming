package example.chap_7.InheritanceMapping.join;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("M")
public class Chap7_InheritanceMapping_Movie extends Chap7_InheritanceMapping_Item {

    private String director;
    private String actor;
    // 추가 필드 및 메서드

}
