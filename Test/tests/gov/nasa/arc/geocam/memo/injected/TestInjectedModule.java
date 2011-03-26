package gov.nasa.arc.geocam.memo.injected;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import gov.nasa.arc.geocam.memo.activity.GeoCamMemoMessageArrayAdapter;
import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterImplementation;
import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterInterface;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;
import roboguice.config.AbstractAndroidModule;

public class TestInjectedModule extends AbstractAndroidModule {

	@Override
	protected void configure() {
		requestStaticInjection(GeoCamMemoMessageArrayAdapter.class);
		//bind(GeoCamMemoMessageArrayAdapter.class).toInstance(new GeoCamMemoMessageArrayAdapter());
		bind(DjangoMemoInterface.class).to(FakeDjangoMemoImplementation.class);
		bind(DjangoMemoJsonConverterInterface.class)
		    .to(DjangoMemoJsonConverterImplementation.class);
	}	
}
