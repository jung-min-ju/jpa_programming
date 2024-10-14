package example.chap_7.InheritanceMapping.singleTable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("B")
@Data
public class Chap7_IM_ST_Book extends Chap7_IM_ST_Item {

    private String author;  // 작가
    private String isbn;    // ISBN

}
