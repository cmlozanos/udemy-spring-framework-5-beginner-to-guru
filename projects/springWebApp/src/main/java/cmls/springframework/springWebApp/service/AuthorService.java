package cmls.springframework.springWebApp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cmls.springframework.springWebApp.entity.Author;
import cmls.springframework.springWebApp.exception.AuthorNotFoundException;
import cmls.springframework.springWebApp.repository.AuthorRepository;

@RestController
public class AuthorService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AuthorRepository repository;

	public List<Author> findAll() {
		logger.info("find all");
		return repository.findAll();
	}

	public Author findById(Long id) {
		logger.info("find by id");
		Optional<Author> optional = repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}
		throw new AuthorNotFoundException(id);
	}
}
