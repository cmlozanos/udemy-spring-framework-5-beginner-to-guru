package cmls.springframework.springWebApp.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ExceptionResponse {
	private final LocalDateTime timestamp;
	private final String message;
	private final String details;
}
