package gov.nasa.arc.geocam.memo.service;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

public interface SiteAuthInterface {
    public void setRoot(String siteRoot);
    public void setAuth(String username, String password);
    public int post(String relativePath, Map<String, String> params) 
            throws AuthorizationFailedException, IOException, ClientProtocolException;
    public String get(String relativePath, Map<String, String> params) 
            throws AuthorizationFailedException, IOException, ClientProtocolException;
}

class AuthorizationFailedException extends Exception{}
