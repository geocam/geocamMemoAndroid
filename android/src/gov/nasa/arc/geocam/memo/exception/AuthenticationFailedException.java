// __BEGIN_LICENSE__
// Copyright (C) 2008-2010 United States Government as represented by
// the Administrator of the National Aeronautics and Space Administration.
// All Rights Reserved.
// __END_LICENSE__

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
