package by.company.kaliaha.util.exception;

public class BodyTypeIsNotExistedException extends Exception{
	private static final long serialVersionUID = 1L;

	public BodyTypeIsNotExistedException () {
		super();
	}
	
	public BodyTypeIsNotExistedException (String message) {
		super(message);
	}
	
	public BodyTypeIsNotExistedException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public BodyTypeIsNotExistedException (Throwable cause) {
		super(cause);
	}
}