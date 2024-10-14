package example.chap_7.InheritanceMapping.join;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Chap7_InheritanceMapping_Album extends Chap7_InheritanceMapping_Item{

    private String artist;
    // 추가 필드 및 메서드

}
