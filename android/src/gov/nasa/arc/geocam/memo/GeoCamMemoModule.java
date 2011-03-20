package gov.nasa.arc.geocam.memo;

import gov.nasa.arc.geocam.memo.service.DjangoGeoCamMemoJsonConverterImplementation;
import gov.nasa.arc.geocam.memo.service.DjangoGeoCamMemoJsonConverterInterface;
import gov.nasa.arc.geocam.memo.service.DjangoMemoImplementation;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;
import roboguice.config.AbstractAndroidModule;

public class GeoCamMemoModule extends AbstractAndroidModule{

	@Override
	protected void configure() {
		bind(DjangoMemoInterface.class).to(DjangoMemoImplementation.class);
		bind(DjangoGeoCamMemoJsonConverterInterface.class)
		    .to(DjangoGeoCamMemoJsonConverterImplementation.class);
	}
}
