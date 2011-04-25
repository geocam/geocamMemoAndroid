package gov.nasa.arc.geocam.memo.exception;

/**
 * The Class AuthenticationFailedException which is thrown when we can't log 
 * into the server because of a bad username and password combination.
 */
public class AuthenticationFailedException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7343849936559985645L;

	/**
	 * Instantiates a new authentication failed exception.
	 *
	 * @param error the error
	 */
	public AuthenticationFailedException(String error)
	{
		super(error);
	}
}
