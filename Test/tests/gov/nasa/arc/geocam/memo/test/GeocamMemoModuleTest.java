package gov.nasa.arc.geocam.memo.test;

import static org.junit.Assert.assertNotNull;
import gov.nasa.arc.geocam.memo.GeoCamMemoModule;
import gov.nasa.arc.geocam.memo.service.AwesomeJsonConverterInterface;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;

import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GeocamMemoModuleTest {

	
	
	@Test
    public void shouldBindDjangoMemoInterface() throws Exception
	{
		//arrange
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
		injector.getProvider(AwesomeJsonConverterInterface.class);
	}
	
}
