package gov.nasa.arc.geocam.memo.service.test;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.service.DjangoMemoImplementation;
import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterInterface;
import gov.nasa.arc.geocam.memo.test.GeoCamTestCase;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.junit.Test;

import android.net.http.AndroidHttpClient;


public class DjangoMemoImplementationTest extends GeoCamTestCase {

	@Test
	public void shouldEnsureGetMemosReturnsMemos() throws Exception {
		DjangoMemoImplementation memoImpl = new DjangoMemoImplementation();
		
		DjangoMemoJsonConverterInterface jsonConv = 
			mock(DjangoMemoJsonConverterInterface.class);
		
		HttpClient httpClient = mock(AndroidHttpClient.class);
		HttpResponse response = mock(HttpResponse.class);
		HttpEntity entity = mock(HttpEntity.class);
		when(response.getEntity()).thenReturn(entity);
		when(httpClient.execute(any(HttpUriRequest.class))).thenReturn(response);
		setHiddenField(memoImpl, "httpClient", httpClient);
		
		List<GeoCamMemoMessage> expectedList = new ArrayList<GeoCamMemoMessage>();
		when(jsonConv.deserializeList(anyString())).thenReturn(expectedList);
		setHiddenField(memoImpl, "jsonConverter", jsonConv);
		
		setHiddenField(memoImpl, "memoUrl", "http://xyz.com/");
		setHiddenField(memoImpl, "memoMessagesJson", "dude.json");
		
		// act
		List<GeoCamMemoMessage> memos = memoImpl.getMemos();
		
		// assert
		assertEquals(expectedList, memos);
		verify(jsonConv).deserializeList(anyString());
	}
}
