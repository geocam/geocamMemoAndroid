package gov.nasa.arc.geocam.memo.service.test;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.service.DjangoMemoImplementation;
import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterInterface;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

public class DjangoMemoImplementationTest extends TestCase {
	
	@Test
	public void ensureGetMemosReturnsMemos() throws Exception {
		DjangoMemoImplementation memoImpl = new DjangoMemoImplementation();
		
		
		
		//let's mock the json interface...
		DjangoMemoJsonConverterInterface jsonConv = 
			mock(DjangoMemoJsonConverterInterface.class); // TODO: Look into @Mock and init call
		// ...and make sure we're calling what we intend to.
		List<GeoCamMemoMessage> expectedList = new ArrayList<GeoCamMemoMessage>();
		when(jsonConv.deserializeList(anyString()))
				.thenReturn(expectedList);

		memoImpl.setJsonConverter(jsonConv);
		
		// act
		List<GeoCamMemoMessage> memos = memoImpl.getMemos();
		
		// assert
		assertEquals(expectedList, memos);
		verify(jsonConv).deserializeList(anyString());
	}
}
