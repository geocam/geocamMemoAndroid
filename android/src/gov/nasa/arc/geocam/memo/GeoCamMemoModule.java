package gov.nasa.arc.geocam.memo;

import gov.nasa.arc.geocam.memo.service.*;
import roboguice.config.AbstractAndroidModule;

public class GeoCamMemoModule extends AbstractAndroidModule{

	@Override
	protected void configure() {
		bind(DjangoMemoInterface.class).to(DjangoMemoImplementation.class);
		bind(AwesomeJsonConverterInterface.class).to(GsonJsonConverterImplementation.class);
	}
}
