package gov.nasa.arc.geocam.memo.service;

import java.util.List;

public interface AwesomeJsonConverterInterface<T> {
	List<T> deserializeList(String jsonString);
}
