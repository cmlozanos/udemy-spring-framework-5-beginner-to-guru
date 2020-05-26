package cmls.springframework.springWebApp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cmls.springframework.springWebApp.entity.Author;
import cmls.springframework.springWebApp.service.AuthorService;

@RestController
public class AuthorRestController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AuthorService service;
	
	@GetMapping("/authors")
	public List<Author> findAll() {
		logger.info("find all");
		return service.findAll();
	}

	@GetMapping("/authors/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		logger.info("find by id author");
		return ResponseEntity.ok(service.findById(id));
	}
	
	@GetMapping("/authors/{id}/books")
	public ResponseEntity<Object> findAllBooks(@PathVariable Long id) {
		logger.info("find by id author and return books");
		return ResponseEntity.ok(service.findById(id).getBooks());
	}
}
