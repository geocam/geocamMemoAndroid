package gov.nasa.arc.geocam.memo.service;

import android.location.Location;
import android.location.LocationListener;

public interface GeoLocationListenerInterface extends LocationListener {
    public Location getLocation();
}
