package example.chap_7.InheritanceMapping.tablePerClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@DiscriminatorValue("B")
@Data
public class Chap7_IM_TPC_Book extends Chap7_IM_TPC_Item {

    private String author;  // 작가
    private String isbn;    // ISBN

}
