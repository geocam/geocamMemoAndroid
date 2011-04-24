package gov.nasa.arc.geocam.memo.exception;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthenticationFailedException.
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
