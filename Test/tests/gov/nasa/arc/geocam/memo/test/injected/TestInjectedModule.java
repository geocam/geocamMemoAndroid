package gov.nasa.arc.geocam.memo.test.injected;

import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;
import roboguice.config.AbstractAndroidModule;

public class TestInjectedModule extends AbstractAndroidModule {

	@Override
	protected void configure() {
		bind(DjangoMemoInterface.class).to(FakeDjangoMemoImplementation.class);
	}	
}
