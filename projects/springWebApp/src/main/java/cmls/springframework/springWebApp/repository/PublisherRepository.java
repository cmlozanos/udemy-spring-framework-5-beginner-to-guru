package cmls.springframework.springWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cmls.springframework.springWebApp.entity.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long>{
}
