package gov.nasa.arc.geocam.memo;

import gov.nasa.arc.geocam.memo.service.DjangoMemoImplementation;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;
import roboguice.config.AbstractAndroidModule;

public class GeoCamMemoModule extends AbstractAndroidModule{

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(DjangoMemoInterface.class).to(DjangoMemoImplementation.class);
	}
}
