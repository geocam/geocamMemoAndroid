package gov.nasa.arc.geocam.memo.test.injected;

import gov.nasa.arc.geocam.memo.GeoCamMemoRoboApplication;

import org.junit.runners.model.InitializationError;

import com.google.inject.Injector;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;

public class InjectedTestRunner extends RobolectricTestRunner{

	public InjectedTestRunner(Class<?> testClass) throws InitializationError {
		super(testClass);
		// TODO Auto-generated constructor stub
	}

	@Override public void prepareTest(Object test){
		 GeoCamMemoRoboApplication sampleApplication = 
			 						(GeoCamMemoRoboApplication)Robolectric.application;
	     Injector injector = sampleApplication.getInjector();
	     injector.injectMembers(test);
	}
	
}
