package hibernat.hibernate;

import hibernat.hibernate.domain.Book;
import hibernat.hibernate.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class SpringBootTestSlice {
    
    
    @Autowired
    BookRepository bookRepository;
    
    @Test
    void testJpaTestSplice(){
        long countBefore = bookRepository.count ();
        
        bookRepository.save (new Book ("My book","5315","Self"));
        long countAfter = bookRepository.count();
        
        assertThat(countBefore).isLessThan (countAfter);
        
    }
}