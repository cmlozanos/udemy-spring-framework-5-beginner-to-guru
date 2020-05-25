package cmls.springframework.springWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cmls.springframework.springWebApp.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
}
