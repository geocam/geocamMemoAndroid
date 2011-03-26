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
		
		GeoCamMemoMessage msg1 = new GeoCamMemoMessage(); 
		GeoCamMemoMessage msg2 = new GeoCamMemoMessage(); 
		GeoCamMemoMessage msg3 = new GeoCamMemoMessage(); 
		GeoCamMemoMessage msg4 = new GeoCamMemoMessage(); 
		
		msg1.setMessageId(1);
		msg2.setMessageId(2);
		msg3.setMessageId(3);
		msg4.setMessageId(4);
		
		msg1.setContent("Hey Guys, I'm the first message!");
		msg2.setContent("I'm message #2");
		msg3.setContent("And I'm 3rd in line!");
		msg4.setContent("I should be at the top of the list");
		
		testList.add(msg1);
		testList.add(msg2);
		testList.add(msg3);
		testList.add(msg4);
		
		return testList;
	}
}
