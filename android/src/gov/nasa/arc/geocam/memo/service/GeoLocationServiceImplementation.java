package gov.nasa.arc.geocam.memo.service;

import roboguice.service.RoboService;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class GeoLocationServiceImplementation extends RoboService
       implements GeoLocationServiceInterface {

	@Inject GeoLocationListenerInterface listener;
	@Inject LocationManager locationManager;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		final Injector injector = getInjector();
		
		listener = injector.getInstance(GeoLocationListenerInterface.class);
		
		locationManager = injector.getInstance(LocationManager.class);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 1, listener);		
		
		injector.injectMembers(this);
		super.onCreate();
	}

	@Override
	public Location getLocation() {
		return listener.getLocation();
	}
}
