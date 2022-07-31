package cardSystem.API.exception;

public class CardNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public CardNotFoundException() {
		super();
	}

	public CardNotFoundException(String message) {
		super(message);
	}

	public CardNotFoundException(Throwable cause) {
		super(cause);
	}

	public CardNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
