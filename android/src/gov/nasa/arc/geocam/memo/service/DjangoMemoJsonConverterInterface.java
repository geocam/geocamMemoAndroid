package gov.nasa.arc.geocam.memo.service;

import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;

import java.util.List;

/**
 * The Interface DjangoMemoJsonConverterInterface.  This class provides 
 * access to the methods that manipulate the Json string
 */
public interface DjangoMemoJsonConverterInterface {
	
	/**
	 * This method creates a Gson object that uses Gson
	 * standards to pull the data from the list 
	 *
	 * @param jsonString the json string
	 * @return the list
	 */
	List<GeoCamMemoMessage> deserializeList(String jsonString);
	
	/**
	 * This method creates a Gson object that uses Gson standards
	 * to pull the data from a Json string
	 *
	 * @param jsonString the json string
	 * @return the geo cam memo message
	 */
	GeoCamMemoMessage deserialize(String jsonString);
	
	/**
	 * This method serializes the passed in object and 
	 * converts it to a Json string.
	 *
	 * @param message the message
	 * @return the string
	 */
	String serialize(GeoCamMemoMessage message);
}
