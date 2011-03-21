package gov.nasa.arc.geocam.memo.injected;

import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterImplementation;
import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterInterface;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;
import roboguice.config.AbstractAndroidModule;

public class TestInjectedModule extends AbstractAndroidModule {

	@Override
	protected void configure() {
		bind(DjangoMemoInterface.class).to(FakeDjangoMemoImplementation.class);
		bind(DjangoMemoJsonConverterInterface.class)
		    .to(DjangoMemoJsonConverterImplementation.class);
	}	
}
