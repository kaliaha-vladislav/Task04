package by.company.kaliaha.util.exception;

public class IncorrectBodyLineException extends Exception{
	private static final long serialVersionUID = 1L;

	public IncorrectBodyLineException () {
		super();
	}
	
	public IncorrectBodyLineException (String message) {
		super(message);
	}
	
	public IncorrectBodyLineException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public IncorrectBodyLineException (Throwable cause) {
		super(cause);
	}
}