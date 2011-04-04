package gov.nasa.arc.geocam.memo.service;

import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.exception.AuthenticationFailedException;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

public interface DjangoMemoInterface {
	public List<GeoCamMemoMessage> getMemos()
	 throws ClientProtocolException, AuthenticationFailedException, IOException;
	public void createMemo(GeoCamMemoMessage message)
	 throws ClientProtocolException, AuthenticationFailedException, IOException;
	public void setAuth(String username, String password);
}
