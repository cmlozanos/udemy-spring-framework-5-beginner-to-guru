package cmls.springframework.springWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cmls.springframework.springWebApp.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
}
