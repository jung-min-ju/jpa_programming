package example.chap_7.InheritanceMapping.join;

import example.JpaApplication;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = JpaApplication.class)
@Transactional
public class Chap7_IM_JOIN_Test {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void testSave() {
        // 트랜잭션 시작 (Spring의 @Transactional 덕분에 트랜잭션이 자동으로 관리됨)
        try {
            // Album 객체 저장
            System.out.println(" Album 객체 저장");
            Chap7_IM_JOIN_Album album = new Chap7_IM_JOIN_Album();
            album.setName("Greatest Hits");
            album.setPrice(15000);
            album.setArtist("Artist Name");
            em.persist(album);

            em.flush();

            // Book 객체 저장
            System.out.println("book 객체 저장");
            Chap7_IM_JOIN_Book book = new Chap7_IM_JOIN_Book();
            book.setName("Book Title");
            book.setPrice(20000);
            book.setAuthor("Author Name");
            book.setIsbn("ISBN12345");
            em.persist(book);

            em.flush();

            // Movie 객체 저장
            Chap7_IM_JOIN_Movie movie = new Chap7_IM_JOIN_Movie();
            movie.setName("Movie Title");
            movie.setPrice(18000);
            movie.setDirector("Director Name");
            movie.setActor("Actor Name");
            em.persist(movie);

            em.flush();
            em.clear();

            // 조회 테스트
            System.out.println("조회 시작");
            Chap7_IM_JOIN_Item foundItem = em.find(Chap7_IM_JOIN_Item.class, album.getId());
            assertNotNull(foundItem);

            // 트랜잭션 커밋은 @Transactional에 의해 자동으로 처리됨
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);  // 예외 발생 시 트랜잭션 롤백
        }
    }
}
