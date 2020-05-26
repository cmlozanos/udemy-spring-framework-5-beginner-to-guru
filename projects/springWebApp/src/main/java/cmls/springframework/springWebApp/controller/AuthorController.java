package cmls.springframework.springWebApp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cmls.springframework.springWebApp.service.AuthorService;

@Controller
public class AuthorController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AuthorService service;

	@RequestMapping("/html/authors")
	public String findAll(Model model){
		logger.info("find all");
	    model.addAttribute("authors", service.findAll());
	    return "authors/list";
	}
}
