package cmls.springframework.springWebApp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AuthorNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(AuthorNotFoundException ex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), "Validation Failed", ex.getBindingResult().getAllErrors().toString());
		return new ResponseEntity<Object>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
}
