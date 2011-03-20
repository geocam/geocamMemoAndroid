package gov.nasa.arc.geocam.memo.injected;

import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;

import java.util.ArrayList;
import java.util.List;

public class FakeDjangoMemoImplementation implements DjangoMemoInterface{

	@Override
	public List<GeoCamMemoMessage> getMemos() {
		// TODO Auto-generated method stub
		List<GeoCamMemoMessage>testList = new ArrayList<GeoCamMemoMessage>();
		return testList;
	}
}
