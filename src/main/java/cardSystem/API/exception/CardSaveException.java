package cardSystem.API.exception;

public class CardSaveException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CardSaveException() {
		super();
	}

	public CardSaveException(String message) {
		super(message);
	}

	public CardSaveException(Throwable cause) {
		super(cause);
	}

	public CardSaveException(String message, Throwable cause) {
		super(message, cause);
	}

}
