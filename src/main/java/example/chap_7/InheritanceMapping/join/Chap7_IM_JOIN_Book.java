package example.chap_7.InheritanceMapping.join;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("B")
@Data
public class Chap7_IM_JOIN_Book extends Chap7_IM_JOIN_Item {

    private String author;  // 작가
    private String isbn;    // ISBN

}
