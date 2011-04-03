package gov.nasa.arc.geocam.memo.service;


import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;

import java.util.List;

import roboguice.inject.InjectResource;
import android.content.Context;
import android.widget.Toast;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class DjangoMemoImplementation implements DjangoMemoInterface{
	// TODO: Review as to whether we should be binding a class or an instance of this class
	@Inject DjangoMemoJsonConverterInterface jsonConverter;
	@InjectResource(R.string.url_server_root) String serverRootUrl;
	@InjectResource(R.string.url_relative_app) String appPath;
	@InjectResource(R.string.url_message_list) String memoMessagesJson;
	@Inject protected static Provider<Context> contextProvider;
	@Inject SiteAuthInterface siteAuthImplementation;
	
	@Override
	public List<GeoCamMemoMessage> getMemos() {
		//String jsonString = 
		//	"[{\"authorUsername\": \"rhornsby\", \"longitude\": -122.057954, \"content\": \"Structural engineer not allowing access to building. Fire is too out of control. Fire squad alerted.\", \"contentTimestamp\": \"03/13/11 10:48:44\", \"latitude\": 37.411629, \"messageId\": 15, \"accuracy\":60.0}]";
		String jsonString = null;
		
		try {
			jsonString = siteAuthImplementation.get(memoMessagesJson, null);
		} catch (Exception e) {
			Toast.makeText(contextProvider.get(), "Cannot access Memo Web", Toast.LENGTH_SHORT).show();			
		}
        
		return jsonConverter.deserializeList(jsonString);
	}

	@Override
	public void setAuth(String username, String password) {
		siteAuthImplementation.setAuth(username, password);		
	}
}
