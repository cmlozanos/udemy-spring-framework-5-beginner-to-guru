package cmls.springframework.springWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cmls.springframework.springWebApp.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
}
