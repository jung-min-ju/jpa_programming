package example.chap_7.InheritanceMapping.singleTable;

import example.JpaApplication;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = JpaApplication.class)
@Transactional
class Chap7_IM_ST_Test {
    @PersistenceContext
    private EntityManager em;

    @Test
    public void testSave() {

    }

}