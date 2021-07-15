package by.company.kaliaha.util.exception;

public class NullAirlineException extends Exception{
	private static final long serialVersionUID = 1L;

	public NullAirlineException () {
		super();
	}
	
	public NullAirlineException (String message) {
		super(message);
	}
	
	public NullAirlineException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public NullAirlineException (Throwable cause) {
		super(cause);
	}
}