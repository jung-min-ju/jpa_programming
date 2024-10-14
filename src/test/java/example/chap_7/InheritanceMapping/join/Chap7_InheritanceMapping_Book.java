package example.chap_7.InheritanceMapping.join;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("B")
public class Chap7_InheritanceMapping_Book extends Chap7_InheritanceMapping_Item{

    private String author;  // 작가
    private String isbn;    // ISBN

}
