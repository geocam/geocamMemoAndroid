package gov.nasa.arc.geocam.memo.service;

import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

// TODO: Auto-generated Javadoc
/**
 * The Class DjangoMemoJsonConverterImplementation.  This class 
 * provides the methods that manipulate the data into and from
 * the Json string
 */
public class DjangoMemoJsonConverterImplementation
    implements DjangoMemoJsonConverterInterface {

	/* (non-Javadoc)
	 * @see gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterInterface#deserializeList(java.lang.String)
	 */
	@Override
	public List<GeoCamMemoMessage> deserializeList(String jsonString) {
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("MM/dd/yy HH:mm:ss");
		Gson gson = builder.create();
		
		Type listType = new TypeToken<List<GeoCamMemoMessage>>(){}.getType();
		
		return gson.fromJson(jsonString, listType);
	}

	/* (non-Javadoc)
	 * @see gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterInterface#deserialize(java.lang.String)
	 */
	public GeoCamMemoMessage deserialize(String jsonString) {
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("MM/dd/yy HH:mm:ss");
		
		Gson gson = builder.create();
		return gson.fromJson(jsonString, GeoCamMemoMessage.class);
	}

	/* (non-Javadoc)
	 * @see gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterInterface#serialize(gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage)
	 */
	@Override
	public String serialize(GeoCamMemoMessage message) {
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("MM/dd/yy HH:mm:ss");
		
		Gson gson = builder.create();
		String ret= gson.toJson(message);
		return ret;
	}
}
