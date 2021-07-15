package by.company.kaliaha.util.exception;

public class FileIsNotExited extends Exception{
	private static final long serialVersionUID = 1L;

	public FileIsNotExited () {
		super();
	}
	
	public FileIsNotExited (String message) {
		super(message);
	}
	
	public FileIsNotExited (String message, Throwable cause) {
		super(message, cause);
	}
	
	public FileIsNotExited (Throwable cause) {
		super(cause);
	}
}