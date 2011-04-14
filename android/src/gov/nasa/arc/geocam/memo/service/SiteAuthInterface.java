package gov.nasa.arc.geocam.memo.service;

import gov.nasa.arc.geocam.memo.exception.AuthenticationFailedException;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;

public interface SiteAuthInterface {
    public void setRoot(String siteRoot);
    public void setAuth(String username, String password);
    public int post(String relativePath, Map<String, String> params) 
            throws AuthenticationFailedException, IOException, ClientProtocolException;
    public String get(String relativePath, Map<String, String> params) 
            throws AuthenticationFailedException, IOException, ClientProtocolException;
}
