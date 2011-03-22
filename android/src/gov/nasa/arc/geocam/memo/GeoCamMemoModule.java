package gov.nasa.arc.geocam.memo;

import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterImplementation;
import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterInterface;
import gov.nasa.arc.geocam.memo.service.DjangoMemoImplementation;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;
import roboguice.config.AbstractAndroidModule;

public class GeoCamMemoModule extends AbstractAndroidModule{

	@Override
	protected void configure() {
		bind(DjangoMemoInterface.class).to(DjangoMemoImplementation.class);
		bind(DjangoMemoJsonConverterInterface.class)
		    .to(DjangoMemoJsonConverterImplementation.class);
	}
}
