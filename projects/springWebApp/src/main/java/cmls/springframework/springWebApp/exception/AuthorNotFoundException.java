package cmls.springframework.springWebApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthorNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AuthorNotFoundException(Long id) {
		super("id-"+id);
	}
	public AuthorNotFoundException(String message) {
		super(message);
	}
}
