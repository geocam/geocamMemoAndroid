package gov.nasa.arc.geocam.memo.service;

import gov.nasa.arc.geocam.memo.exception.AuthenticationFailedException;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiteAuthInterface.
 */
public interface SiteAuthInterface {
    
    /**
     * Sets the root.
     *
     * @param siteRoot the new root
     */
    public void setRoot(String siteRoot);
    
    /**
     * Sets the auth.
     *
     * @param username the username
     * @param password the password
     */
    public void setAuth(String username, String password);
    
    /**
     * Post.
     *
     * @param relativePath the relative path
     * @param params the params
     * @return the int
     * @throws AuthenticationFailedException the authentication failed exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws ClientProtocolException the client protocol exception
     */
    public int post(String relativePath, Map<String, String> params) 
            throws AuthenticationFailedException, IOException, ClientProtocolException;
    
    /**
     * Gets the.
     *
     * @param relativePath the relative path
     * @param params the params
     * @return the string
     * @throws AuthenticationFailedException the authentication failed exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws ClientProtocolException the client protocol exception
     */
    public String get(String relativePath, Map<String, String> params) 
            throws AuthenticationFailedException, IOException, ClientProtocolException;
}
