package cardSystem.API.exception;

public class CardNotExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CardNotExistsException() {
		super();
	}

	public CardNotExistsException(String message) {
		super(message);
	}

	public CardNotExistsException(Throwable cause) {
		super(cause);
	}

	public CardNotExistsException(String message, Throwable cause) {
		super(message, cause);
	}

}
