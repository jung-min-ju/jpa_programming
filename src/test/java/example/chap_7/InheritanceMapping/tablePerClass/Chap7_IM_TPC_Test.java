package example.chap_7.InheritanceMapping.tablePerClass;

import example.JpaApplication;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest(classes = JpaApplication.class)
@Transactional
class Chap7_IM_TPC_Test {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void testSave() {

    }


}