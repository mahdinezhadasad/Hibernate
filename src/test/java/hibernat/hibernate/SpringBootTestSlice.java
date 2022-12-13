package hibernat.hibernate;

import hibernat.hibernate.domain.Book;
import hibernat.hibernate.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ComponentScan(basePackages ="hibernat.hibernate.bootstrap")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class SpringBootTestSlice {
    
    @Autowired
    BookRepository bookRepository;
    @Commit
    @Order(2)
    @Test
    void testJpaTestSplice(){
        long countBefore = bookRepository.count ();
        
        bookRepository.save (new Book ("My book","5315","Self",null));
        long countAfter = bookRepository.count();
        
        assertThat(countBefore).isLessThan (countAfter);
        
    }
    @Order(2)
    @Test
    void testJpaTestSpliceTransaction() {
        
        long countBefore = bookRepository.count();
        assertThat (countBefore).isEqualTo (3);
        
    }
}