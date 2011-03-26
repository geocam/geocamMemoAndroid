package gov.nasa.arc.geocam.memo.test;

public class GeocamMemoModuleTest{};

/*	TODO: Figure this out!

package gov.nasa.arc.geocam.memo.test;

import gov.nasa.arc.geocam.memo.GeoCamMemoModule;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;
import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterInterface;

import org.junit.Test;

import android.net.http.AndroidHttpClient;

import com.google.inject.Guice;
import com.google.inject.Injector;

import roboguice.*;
import roboguice.inject.InjectorProvider;

public class GeocamMemoModuleTest extends GeoCamTestCase{
    @Test
    public void shouldBindDjangoMemoInterface() throws Exception
	{
		//arrange
		GeoCamMemoModule module = new GeoCamMemoModule();
		
		Injector injector = Guice.createInjector(new GeoCamMemoModule());

		// act & assert (by non-exception)
        injector.getProvider(DjangoMemoInterface.class);
	}
	
	@Test
	public void shouldBindAwesomeJsonConverterInterface() throws Exception
	{
		//arrange
		Injector injector = Guice.createInjector(new GeoCamMemoModule());

		// act & assert (by non-exception)
		injector.getProvider(DjangoMemoJsonConverterInterface.class);
	}
	
	@Test
	public void shouldBindAndroidHttpClient() throws Exception
	{
		//arrange
		Injector injector = Guice.createInjector(new GeoCamMemoModule());

		// act & assert (by non-exception)
		injector.getProvider(AndroidHttpClient.class);
	}
}*/
