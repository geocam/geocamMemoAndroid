package gov.nasa.arc.geocam.memo.exception;

public class AuthenticationFailedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7343849936559985645L;

	public AuthenticationFailedException(String error)
	{
		super(error);
	}
}
