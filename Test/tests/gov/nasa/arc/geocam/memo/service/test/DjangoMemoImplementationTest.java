package gov.nasa.arc.geocam.memo.service.test;

import static org.mockito.Matchers.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.service.DjangoMemoImplementation;
import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterInterface;
import gov.nasa.arc.geocam.memo.service.SiteAuthInterface;
import gov.nasa.arc.geocam.memo.test.GeoCamTestCase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class DjangoMemoImplementationTest extends GeoCamTestCase {

	@Test
	public void shouldEnsureGetMemosReturnsMemos() throws Exception {
		DjangoMemoImplementation memoImpl = new DjangoMemoImplementation();
		
		DjangoMemoJsonConverterInterface jsonConv = 
			mock(DjangoMemoJsonConverterInterface.class);
		
		SiteAuthInterface siteauth =
			mock(SiteAuthInterface.class);
		when(siteauth.get(anyString(), anyMap())).thenReturn("");
		setHiddenField(memoImpl, "siteAuthImplementation", siteauth);
		
		List<GeoCamMemoMessage> expectedList = new ArrayList<GeoCamMemoMessage>();
		when(jsonConv.deserializeList(anyString())).thenReturn(expectedList);
		setHiddenField(memoImpl, "jsonConverter", jsonConv);
		
		// act
		List<GeoCamMemoMessage> memos = memoImpl.getMemos();
		
		// assert
		assertEquals(expectedList, memos);
		verify(jsonConv).deserializeList(anyString());
	}
	
	@Test
	public void shouldEnsureCreateMemoPostsMemo() throws Exception
	{
		DjangoMemoImplementation memoImpl = new DjangoMemoImplementation();
		
		DjangoMemoJsonConverterInterface jsonConv = 
			mock(DjangoMemoJsonConverterInterface.class);
		
		SiteAuthInterface siteauth =
			mock(SiteAuthInterface.class);
		when(siteauth.post(anyString(), anyMap())).thenReturn(302);
		setHiddenField(memoImpl, "siteAuthImplementation", siteauth);
				
		when(jsonConv.serialize((GeoCamMemoMessage)anyObject())).thenReturn("");
		setHiddenField(memoImpl, "jsonConverter", jsonConv);
		
		// act
		memoImpl.createMemo(new GeoCamMemoMessage());
		
		// assert
		verify(siteauth).post(anyString(), anyMap());
	}
}
