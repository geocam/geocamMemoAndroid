package gov.nasa.arc.geocam.memo;

import gov.nasa.arc.geocam.memo.activity.GeoCamMemoMessageArrayAdapter;
import gov.nasa.arc.geocam.memo.service.DjangoMemoImplementation;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;
import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterImplementation;
import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterInterface;
import gov.nasa.arc.geocam.memo.service.GeoLocationListenerImplementation;
import gov.nasa.arc.geocam.memo.service.GeoLocationListenerInterface;
import gov.nasa.arc.geocam.memo.service.GeoLocationServiceImplementation;
import gov.nasa.arc.geocam.memo.service.GeoLocationServiceInterface;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import roboguice.config.AbstractAndroidModule;

public class GeoCamMemoModule extends AbstractAndroidModule{

	@Override
	protected void configure() {
		requestStaticInjection(GeoCamMemoMessageArrayAdapter.class);
		bind(DjangoMemoInterface.class).to(DjangoMemoImplementation.class);
		bind(DjangoMemoJsonConverterInterface.class)
		    .to(DjangoMemoJsonConverterImplementation.class);
		bind(HttpClient.class).toInstance(new DefaultHttpClient());
		bind(GeoLocationListenerInterface.class).to(GeoLocationListenerImplementation.class);
		bind(GeoLocationServiceInterface.class).to(GeoLocationServiceImplementation.class);
	}
	
	
}
