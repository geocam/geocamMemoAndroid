package gov.nasa.arc.geocam.memo.service;


import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;

import java.util.List;

import com.google.inject.Inject;

public class DjangoMemoImplementation implements DjangoMemoInterface{

	@Inject DjangoMemoJsonConverterInterface jsonConverter;
	
	@Override
	public List<GeoCamMemoMessage> getMemos() {
		String jsonString = 
			"[{\"authorUsername\": \"rhornsby\", \"longitude\": -122.057954, \"content\": \"Structural engineer not allowing access to building. Fire is too out of control. Fire squad alerted.\", \"contentTimestamp\": \"03/13/11 10:48:44\", \"latitude\": 37.411629, \"messageId\": 15, \"accuracy\":60.0}]";
		
		return jsonConverter.deserializeList(jsonString);
	}
}
