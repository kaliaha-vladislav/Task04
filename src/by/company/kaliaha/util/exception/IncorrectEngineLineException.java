package by.company.kaliaha.util.exception;

public class IncorrectEngineLineException extends Exception{
	private static final long serialVersionUID = 1L;

	public IncorrectEngineLineException () {
		super();
	}
	
	public IncorrectEngineLineException (String message) {
		super(message);
	}
	
	public IncorrectEngineLineException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public IncorrectEngineLineException (Throwable cause) {
		super(cause);
	}
}