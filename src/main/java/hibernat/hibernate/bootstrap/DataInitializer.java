package hibernat.hibernate.bootstrap;

import hibernat.hibernate.domain.AuthorUuid;
import hibernat.hibernate.domain.Book;
import hibernat.hibernate.repository.AuthorUuidRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import hibernat.hibernate.repository.BookRepository;
@Profile({"local","default"})
@Component
public class DataInitializer implements CommandLineRunner {
    
    private final BookRepository bookRepository;
    private final AuthorUuidRepository authorUuidRepositorya;
    
    public DataInitializer(BookRepository bookRepository, AuthorUuidRepository authorUuidRepository) {
        this.bookRepository = bookRepository;
        this.authorUuidRepositorya = authorUuidRepository;
    }
    
    
    @Override
    public void run(String... args) throws Exception {
        
        bookRepository.deleteAll ();
        authorUuidRepositorya.deleteAll ();
        Book bookDDD = new Book("Domain Driven Design", "123", "RandomHouse",null);
    
        System.out.println("Id: " + bookDDD.getId() );
    
        Book savedDDD = bookRepository.save(bookDDD);
    
        System.out.println("Id: " + savedDDD.getId() );
    
        Book bookSIA = new Book("Spring In Action", "234234", "Oriely",null);
        Book savedSIA = bookRepository.save(bookSIA);
        
        
        AuthorUuid authorUuid = new AuthorUuid ();
        authorUuid.setFirstName ("Joe");
        authorUuid.setLastName("Buck");
        AuthorUuid savedAuthor = authorUuidRepositorya.save (authorUuid);
    
    
        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
        });
    
 
    }
}