package by.company.kaliaha.util.exception;

public class NullBodyException extends Exception{
	private static final long serialVersionUID = 1L;

	public NullBodyException () {
		super();
	}
	
	public NullBodyException (String message) {
		super(message);
	}
	
	public NullBodyException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public NullBodyException (Throwable cause) {
		super(cause);
	}
}