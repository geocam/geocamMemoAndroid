package gov.nasa.arc.geocam.memo.service;

import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class DjangoMemoJsonConverterImplementation
    implements DjangoMemoJsonConverterInterface {

	@Override
	public List<GeoCamMemoMessage> deserializeList(String jsonString) {
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("MM/dd/yy HH:mm:ss");
		Gson gson = builder.create();
		
		Type listType = new TypeToken<List<GeoCamMemoMessage>>(){}.getType();
		
		return gson.fromJson(jsonString, listType);
	}

	public GeoCamMemoMessage deserialize(String jsonString) {
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("MM/dd/yy HH:mm:ss");
		
		Gson gson = builder.create();
		return gson.fromJson(jsonString, GeoCamMemoMessage.class);
	}
}
