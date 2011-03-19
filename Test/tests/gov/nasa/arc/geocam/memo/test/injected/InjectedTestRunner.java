package gov.nasa.arc.geocam.memo.test.injected;

import gov.nasa.arc.geocam.memo.GeoCamMemoRoboApplication;

import org.junit.runners.model.InitializationError;

import roboguice.inject.ContextScope;

import android.app.Application;

import com.google.inject.Injector;
import com.xtremelabs.robolectric.Robolectric;
import com.xtremelabs.robolectric.RobolectricTestRunner;

public class InjectedTestRunner extends RobolectricTestRunner{

	public InjectedTestRunner(Class<?> testClass) throws InitializationError {
		super(testClass);
		// TODO Auto-generated constructor stub
	}

    @Override protected Application createApplication() {
        GeoCamMemoRoboApplication application = (GeoCamMemoRoboApplication)super.createApplication();
        application.setModule(new TestInjectedModule());
        return application;
    }
	
	@Override public void prepareTest(Object test){
		 GeoCamMemoRoboApplication application = 
			 						(GeoCamMemoRoboApplication)Robolectric.application;
	     Injector injector = application.getInjector();
	     ContextScope scope = injector.getInstance(ContextScope.class);
	     scope.enter(application);
	     injector.injectMembers(test);
	}
	
}