package gov.nasa.arc.geocam.memo.service;


import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

import roboguice.inject.InjectResource;
import android.content.Context;
import android.widget.Toast;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class DjangoMemoImplementation implements DjangoMemoInterface{

	@Inject DjangoMemoJsonConverterInterface jsonConverter;
	@InjectResource(R.string.memo_url) String memoUrl;
	@InjectResource(R.string.memo_messages) String memoMessagesJson;
	@Inject protected static Provider<Context> contextProvider;
	@Inject HttpClient httpClient;
	
	@Override
	public List<GeoCamMemoMessage> getMemos() {
		//String jsonString = 
		//	"[{\"authorUsername\": \"rhornsby\", \"longitude\": -122.057954, \"content\": \"Structural engineer not allowing access to building. Fire is too out of control. Fire squad alerted.\", \"contentTimestamp\": \"03/13/11 10:48:44\", \"latitude\": 37.411629, \"messageId\": 15, \"accuracy\":60.0}]";
		String jsonString = null;
		
		try {
			HttpGet httpGet = new HttpGet(memoUrl + memoMessagesJson);
			HttpResponse response = httpClient.execute(httpGet);
			
			ByteArrayOutputStream ostream = new ByteArrayOutputStream();
			response.getEntity().writeTo(ostream);
	        jsonString = ostream.toString();
		} catch (Exception e) {
			Toast.makeText(contextProvider.get(), "Cannot access Memo Web", Toast.LENGTH_SHORT).show();			
		}
        
		return jsonConverter.deserializeList(jsonString);
	}
}
