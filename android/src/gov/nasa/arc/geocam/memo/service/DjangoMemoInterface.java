// __BEGIN_LICENSE__
// Copyright (C) 2008-2010 United States Government as represented by
// the Administrator of the National Aeronautics and Space Administration.
// All Rights Reserved.
// __END_LICENSE__

package gov.nasa.arc.geocam.memo.service;

import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.exception.AuthenticationFailedException;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

/**
 * The Interface DjangoMemoInterface.  This provides access to the
 * methods that manipulate the memos from the server.
 */
public interface DjangoMemoInterface {
	
	/**
	 * Gets available memos from the server.
	 *
	 * @return the memos
	 * @throws ClientProtocolException the client protocol exception
	 * @throws AuthenticationFailedException the authentication failed exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public List<GeoCamMemoMessage> getMemos()
	 throws ClientProtocolException, AuthenticationFailedException, IOException;
	
	/**
	 * Creates a memo on the django server.
	 *
	 * @param message the message
	 * @throws ClientProtocolException the client protocol exception
	 * @throws AuthenticationFailedException the authentication failed exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void createMemo(GeoCamMemoMessage message)
	 throws ClientProtocolException, AuthenticationFailedException, IOException;
	
	/**
	 * Sets the authorization credentials.
	 *
	 * @param username the username
	 * @param password the password
	 */
	public void setAuth(String username, String password);
}
