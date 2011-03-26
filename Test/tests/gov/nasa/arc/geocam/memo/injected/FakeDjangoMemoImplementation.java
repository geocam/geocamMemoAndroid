package gov.nasa.arc.geocam.memo.injected;

import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterInterface;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.google.inject.Inject;

public class FakeDjangoMemoImplementation implements DjangoMemoInterface{

	@Inject DjangoMemoJsonConverterInterface jsonConverter;
	
	@Override
	public List<GeoCamMemoMessage> getMemos() {
		// TODO Auto-generated method stub
		List<GeoCamMemoMessage>testList = new ArrayList<GeoCamMemoMessage>();
		
		testList.add(
				FakeGeoCamMemoMessageFactory.getMessage(
						"Hey Guys, I'm the first message!", 
						"Ted Johnson", 
						true)
		);
		testList.add(
				FakeGeoCamMemoMessageFactory.getMessage(
						"I'm message #2", 
						"Ted Johnson", 
						false)
		);		
		testList.add(
				FakeGeoCamMemoMessageFactory.getMessage(
						"And I'm 3rd in line!", 
						"Rufus Hornsby", 
						true)
		);		
		testList.add(
				FakeGeoCamMemoMessageFactory.getMessage(
						"I should be at the top of the list", 
						"Ted Johnson", 
						true)
		);		
		
		return testList;
	}
}
