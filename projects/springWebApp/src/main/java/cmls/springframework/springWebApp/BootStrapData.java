package cmls.springframework.springWebApp;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cmls.springframework.springWebApp.entity.Author;
import cmls.springframework.springWebApp.entity.Book;
import cmls.springframework.springWebApp.entity.Publisher;
import cmls.springframework.springWebApp.repository.AuthorRepository;
import cmls.springframework.springWebApp.repository.BookRepository;
import cmls.springframework.springWebApp.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private PublisherRepository publisherRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		logger.info("starting with data");
		
		Publisher publisher = new Publisher(null, "carlos-publisher", "adressl1", "badajoz", "spain", "06009", new HashSet<Book>());
		publisherRepository.save(publisher);
		
		final Author author = new Author(null, "carlos", "lozano", new HashSet<Book>());
		final Book book = new Book(null, "spring-data-book", "123,1234", publisher, new HashSet<Author>());
		author.getBooks().add(book);
		book.getAuthors().add(author);
		
		authorRepository.save(author);
		bookRepository.save(book);
		
		logger.info("authors: " + authorRepository.count());
		logger.info("books: " + bookRepository.count());
		logger.info("publisher: " + publisherRepository.count());
		logger.info("ending with data");
	}

}
