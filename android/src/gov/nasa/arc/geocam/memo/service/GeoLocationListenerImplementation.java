package gov.nasa.arc.geocam.memo.service;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

public class GeoLocationListenerImplementation
             implements LocationListener, GeoLocationListenerInterface {

	private Location curLocation;
	
	@Override
	public void onLocationChanged(Location location) {
		curLocation = location;
	}

	@Override
	public void onProviderDisabled(String provider) { }

	@Override
	public void onProviderEnabled(String provider) { }

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) { }

	@Override
	public Location getLocation() {
		return curLocation;
	}

}
