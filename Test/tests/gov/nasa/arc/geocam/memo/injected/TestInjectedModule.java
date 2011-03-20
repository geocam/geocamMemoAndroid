package gov.nasa.arc.geocam.memo.injected;

import gov.nasa.arc.geocam.memo.service.DjangoGeoCamMemoJsonConverterImplementation;
import gov.nasa.arc.geocam.memo.service.DjangoGeoCamMemoJsonConverterInterface;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;
import roboguice.config.AbstractAndroidModule;

public class TestInjectedModule extends AbstractAndroidModule {

	@Override
	protected void configure() {
		bind(DjangoMemoInterface.class).to(FakeDjangoMemoImplementation.class);
		bind(DjangoGeoCamMemoJsonConverterInterface.class)
		    .to(DjangoGeoCamMemoJsonConverterImplementation.class);
	}	
}
