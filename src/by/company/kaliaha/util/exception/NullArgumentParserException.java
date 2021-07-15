package by.company.kaliaha.util.exception;

public class NullArgumentParserException extends Exception{
	private static final long serialVersionUID = 1L;

	public NullArgumentParserException () {
		super();
	}
	
	public NullArgumentParserException (String message) {
		super(message);
	}
	
	public NullArgumentParserException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public NullArgumentParserException (Throwable cause) {
		super(cause);
	}
}