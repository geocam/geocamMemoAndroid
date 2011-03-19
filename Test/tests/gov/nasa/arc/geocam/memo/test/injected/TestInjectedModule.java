package gov.nasa.arc.geocam.memo.test.injected;

import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;
import roboguice.config.AbstractAndroidModule;
import sun.management.counter.Counter;

import com.google.inject.Scopes;

public class TestInjectedModule extends AbstractAndroidModule {

	@Override
	protected void configure() {
		bind(DjangoMemoInterface.class).to(FakeDjangoMemoImplementation.class);
	}	
}
