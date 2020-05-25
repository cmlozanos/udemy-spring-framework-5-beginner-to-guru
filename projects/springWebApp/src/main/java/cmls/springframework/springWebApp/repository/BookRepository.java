package cmls.springframework.springWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cmls.springframework.springWebApp.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
}
