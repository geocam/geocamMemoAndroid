package gov.nasa.arc.geocam.memo.service;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.IBinder;

import com.google.inject.Inject;

public class GeoLocationServiceImplementation extends Service
       implements GeoLocationServiceInterface {

	@Inject GeoLocationListenerInterface listener;
	@Inject LocationManager locationManager;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 1, listener);
	}

	@Override
	public Location getLocation() {
		return listener.getLocation();
	}
}
