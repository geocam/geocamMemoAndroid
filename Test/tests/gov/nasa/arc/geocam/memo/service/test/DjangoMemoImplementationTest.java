package gov.nasa.arc.geocam.memo.service.test;

import static org.junit.Assert.assertNotNull;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.injected.InjectedTestRunner;
import gov.nasa.arc.geocam.memo.service.DjangoMemoImplementation;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(InjectedTestRunner.class)
public class DjangoMemoImplementationTest {

	@Inject DjangoMemoImplementation memoImpl;
	
	@Test
	public void ensureGetMemosReturnsMemos() {
		// act
		List<GeoCamMemoMessage> memos = memoImpl.getMemos();
		
		// assert
		assertNotNull(memos);
	}
}
