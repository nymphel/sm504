package tr.metu.edu.sm.cookbook.exception;

public class CookBookException extends Exception {

	private static final long serialVersionUID = 3911541148478183019L;

	private CookBookErrorCodes errorCode = null;

	public CookBookException(CookBookErrorCodes errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return (this.errorCode != null ? this.errorCode.getMessage() : "Unhandled exception has occured!");
	}

}
