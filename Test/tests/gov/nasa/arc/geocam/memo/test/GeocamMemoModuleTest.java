package gov.nasa.arc.geocam.memo.test;

import org.junit.Test;

import gov.nasa.arc.geocam.memo.GeoCamMemoModule;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;
import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterInterface;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GeocamMemoModuleTest extends GeoCamTestCase{
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
		injector.getProvider(DjangoMemoJsonConverterInterface.class);
	}
	
}
