package gov.nasa.arc.geocam.memo.injected;

import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterInterface;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

public class FakeDjangoMemoImplementation implements DjangoMemoInterface{

	@Inject DjangoMemoJsonConverterInterface jsonConverter;
	
	@Override
	public List<GeoCamMemoMessage> getMemos() {
		// TODO Auto-generated method stub
		List<GeoCamMemoMessage>testList = new ArrayList<GeoCamMemoMessage>();
		return testList;
	}
}
