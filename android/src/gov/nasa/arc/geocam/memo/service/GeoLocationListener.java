package gov.nasa.arc.geocam.memo.service;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving geoLocation events.
 * The class that is interested in processing a geoLocation
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addGeoLocationListener<code> method. When
 * the geoLocation event occurs, that object's appropriate
 * method is invoked.
 *
 * @see GeoLocationEvent
 */
public class GeoLocationListener implements LocationListener {

	/** The cur location. */
	private Location curLocation;
	
	/* (non-Javadoc)
	 * @see android.location.LocationListener#onLocationChanged(android.location.Location)
	 */
	@Override
	public void onLocationChanged(Location location) {
		curLocation = location;
		Log.d("location", "location listened");
	}

	/* (non-Javadoc)
	 * @see android.location.LocationListener#onProviderDisabled(java.lang.String)
	 */
	@Override
	public void onProviderDisabled(String provider) { }

	/* (non-Javadoc)
	 * @see android.location.LocationListener#onProviderEnabled(java.lang.String)
	 */
	@Override
	public void onProviderEnabled(String provider) { }

	/* (non-Javadoc)
	 * @see android.location.LocationListener#onStatusChanged(java.lang.String, int, android.os.Bundle)
	 */
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) { }

	/**
	 * Gets the location.
	 *
	 * @return the location
	 */
	public Location getLocation() {
		return curLocation;
	}

}
