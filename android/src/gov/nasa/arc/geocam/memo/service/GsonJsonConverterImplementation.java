package gov.nasa.arc.geocam.memo.service;

import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GsonJsonConverterImplementation<T> implements AwesomeJsonConverterInterface<T> {

	@Override
	public List<T> deserializeList(String jsonString) {
		throw new UnsupportedOperationException();
		
//		GsonBuilder builder = new GsonBuilder();
//		builder.setDateFormat("MM/dd/yy HH:mm:ss");
//		Gson gson = builder.create();
//		
//		Type listType = new TypeToken<List<T>>(){}.getType();
//		
//		return gson.fromJson(jsonString, listType);
	}

	@Override
	public List<GeoCamMemoMessage> deserializeGeoCamMemoMessageList(
			String jsonString) {
		GsonBuilder builder = new GsonBuilder();
		builder.setDateFormat("MM/dd/yy HH:mm:ss");
		Gson gson = builder.create();
		
		Type listType = new TypeToken<List<GeoCamMemoMessage>>(){}.getType();
		
		return gson.fromJson(jsonString, listType);
	}

	public T deserialize(String jsonString) {
		throw new UnsupportedOperationException();
//		GsonBuilder builder = new GsonBuilder();
//		builder.setDateFormat("MM/dd/yy HH:mm:ss");
//		
//		Gson gson = builder.create();
//		//createMyGeneric(T);
//		
//		//return gson.fromJson(jsonString, T); // GeoCamMemoMessage.class
//		
//		return new (T)Object();
	}
}
