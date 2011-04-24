package gov.nasa.arc.geocam.memo.service;

import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface DjangoMemoJsonConverterInterface.
 */
public interface DjangoMemoJsonConverterInterface {
	
	/**
	 * Deserialize list.
	 *
	 * @param jsonString the json string
	 * @return the list
	 */
	List<GeoCamMemoMessage> deserializeList(String jsonString);
	
	/**
	 * Deserialize.
	 *
	 * @param jsonString the json string
	 * @return the geo cam memo message
	 */
	GeoCamMemoMessage deserialize(String jsonString);
	
	/**
	 * Serialize.
	 *
	 * @param message the message
	 * @return the string
	 */
	String serialize(GeoCamMemoMessage message);
}
