package gov.nasa.arc.geocam.memo.service;

import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;

import java.util.List;

public interface AwesomeJsonConverterInterface<T> {
	List<T> deserializeList(String jsonString);
	List<GeoCamMemoMessage> deserializeGeoCamMemoMessageList(String jsonString);
}
