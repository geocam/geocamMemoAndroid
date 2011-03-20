package gov.nasa.arc.geocam.memo.service;

import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;

import java.util.List;

public interface DjangoMemoInterface {
	public List<GeoCamMemoMessage> getMemos();
}
