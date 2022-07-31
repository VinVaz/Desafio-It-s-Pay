package cardSystem.API.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CardExceptionHandler {

	@ExceptionHandler(value = CardNotFoundException.class)
	public ResponseEntity<CardError> cardNotFound(CardNotFoundException ex) {

		CardError err = new CardError(404, ex.getMessage(), new Date());
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = CardNotExistsException.class)
	public ResponseEntity<CardError> cardNotExists(CardNotExistsException ex) {

		CardError err = new CardError(404, ex.getMessage(), new Date());
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = CardSaveException.class)
	public ResponseEntity<CardError> cardNotSaved(CardSaveException ex) {

		CardError err = new CardError(400, ex.getMessage(), new Date());
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(value = CardAlreadyExistsException.class)
	public ResponseEntity<CardError> cardAlreadySaved(CardAlreadyExistsException ex) {

		CardError err = new CardError(409, ex.getMessage(), new Date());
		return new ResponseEntity<>(err, HttpStatus.CONFLICT);

	}

}
