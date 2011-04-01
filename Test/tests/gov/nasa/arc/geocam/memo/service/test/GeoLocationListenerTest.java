package gov.nasa.arc.geocam.memo.service.test;

import gov.nasa.arc.geocam.memo.service.GeoLocationListener;
import gov.nasa.arc.geocam.memo.test.GeoCamTestCase;

import org.junit.Test;

import android.location.Location;


public class GeoLocationListenerTest extends GeoCamTestCase {
	
	@Test public void shouldUpdateLocationOnLocationChanged() throws Exception {
		// arrange
		GeoLocationListener listener = new GeoLocationListener();
		Location location = new Location("JupiterTest");
		
		// act
		listener.onLocationChanged(location);
		
		// assert
		assertEquals(listener.getLocation(), location);
	}

}
