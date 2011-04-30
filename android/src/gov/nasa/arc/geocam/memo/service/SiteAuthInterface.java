// __BEGIN_LICENSE__
// Copyright (C) 2008-2010 United States Government as represented by
// the Administrator of the National Aeronautics and Space Administration.
// All Rights Reserved.
// __END_LICENSE__

package gov.nasa.arc.geocam.memo.service;

import gov.nasa.arc.geocam.memo.exception.AuthenticationFailedException;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

/**
 * The Interface SiteAuthInterface.
 */
public interface SiteAuthInterface {
    
    /**
     * Sets the root path of the django server
     *
     * @param siteRoot the new root
     */
    public void setRoot(String siteRoot);
    
    /**
     * Sets the authentication credentials to login with.
     *
     * @param username the username
     * @param password the password
     */
    public void setAuth(String username, String password);
    
    /**
     * Submit an HTTP Post to the server
     *
     * @param relativePath the relative path of the post
     * @param params A string to string map of the itemized parameters to post
     * @return The server response code
     * @throws AuthenticationFailedException the authentication failed exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws ClientProtocolException the client protocol exception
     */
    public int post(String relativePath, Map<String, String> params) 
            throws AuthenticationFailedException, IOException, ClientProtocolException;
    
    /**
     * submits an HTTP get to the django server
     *
     * @param relativePath the relative path on the django server
     * @param params A string to string map of the itemized parameters to post
     * @return the contents returned by the get
     * @throws AuthenticationFailedException the authentication failed exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws ClientProtocolException the client protocol exception
     */
    public String get(String relativePath, Map<String, String> params) 
            throws AuthenticationFailedException, IOException, ClientProtocolException;
}
