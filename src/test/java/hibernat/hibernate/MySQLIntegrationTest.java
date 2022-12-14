package hibernat.hibernate;


import hibernat.hibernate.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@ActiveProfiles()
@DataJpaTest
@ComponentScan(basePackages ="hibernat.hibernate.bootstrap")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTest {
    
    
    @Autowired
    BookRepository bookRepository;
    
    @Test
    void testJpaTestSpliceTransaction() {

        long countBefore = bookRepository.count ();
        assertThat (countBefore).isEqualTo (2);

    }
}