package gov.nasa.arc.geocam.memo.service;


import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.exception.AuthenticationFailedException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import roboguice.inject.InjectResource;
import android.content.Context;

import com.google.inject.Inject;
import com.google.inject.Provider;

// TODO: Auto-generated Javadoc
/**
 * The Class DjangoMemoImplementation.
 */
public class DjangoMemoImplementation implements DjangoMemoInterface{

	/** The json converter. */
	@Inject DjangoMemoJsonConverterInterface jsonConverter;
	
	/** The server root url. */
	@InjectResource(R.string.url_server_root) String serverRootUrl;
	
	/** The path for the application server. */
	@InjectResource(R.string.url_relative_app) String appPath;
	
	/** The path for the Memo homepage. */
	@InjectResource(R.string.url_message_list) String memoMessagesJson;
	
	/** The path for the create memo page. */
	@InjectResource(R.string.url_create_message) String createMemoMessageJson;
	
	/** The context provider. */
	@Inject protected static Provider<Context> contextProvider;
	
	/** The site auth implementation. */
	@Inject SiteAuthInterface siteAuthImplementation;
	
	/* (non-Javadoc)
	 * @see gov.nasa.arc.geocam.memo.service.DjangoMemoInterface#getMemos()
	 */
	@Override
	public List<GeoCamMemoMessage> getMemos() throws ClientProtocolException, AuthenticationFailedException, IOException {
		//String jsonString = 
		//	"[{\"authorUsername\": \"rhornsby\", \"longitude\": -122.057954, \"content\": \"Structural engineer not allowing access to building. Fire is too out of control. Fire squad alerted.\", \"contentTimestamp\": \"03/13/11 10:48:44\", \"latitude\": 37.411629, \"messageId\": 15, \"accuracy\":60.0}]";
		String jsonString = null;
		
		jsonString = siteAuthImplementation.get(memoMessagesJson, null);
        
		return jsonConverter.deserializeList(jsonString);
	}

	/* (non-Javadoc)
	 * @see gov.nasa.arc.geocam.memo.service.DjangoMemoInterface#setAuth(java.lang.String, java.lang.String)
	 */
	@Override
	public void setAuth(String username, String password) {
		siteAuthImplementation.setAuth(username, password);		
	}

	/* (non-Javadoc)
	 * @see gov.nasa.arc.geocam.memo.service.DjangoMemoInterface#createMemo(gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage)
	 */
	@Override
	public void createMemo(GeoCamMemoMessage message) throws ClientProtocolException, AuthenticationFailedException, IOException {
		HashMap<String,String>map = new HashMap<String,String>();
		map.put("message", jsonConverter.serialize(message));
		int responseCode = siteAuthImplementation.post(createMemoMessageJson, map);
		if(responseCode != 200)
		{
			throw new ClientProtocolException("Message could not be created (HTTP error "+responseCode+")");
		}
	}
}
