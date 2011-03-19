package gov.nasa.arc.geocam.memo.service;

import java.util.ArrayList;
import java.util.List;

public class GsonJsonConverterImplementation<T> implements AwesomeJsonConverterInterface<T> {

	@Override
	public List<T> deserializeList(String jsonString) {
		List<T> returnList = new ArrayList<T>(); 	
		
		// TODO: Implement this awesomeness.
		
		return returnList;
	}

}
