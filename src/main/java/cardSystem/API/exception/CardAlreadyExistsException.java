package cardSystem.API.exception;

public class CardAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public CardAlreadyExistsException() {
		super();
	}

	public CardAlreadyExistsException(String message) {
		super(message);
	}

	public CardAlreadyExistsException(Throwable cause) {
		super(cause);
	}

	public CardAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
