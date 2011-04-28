package gov.nasa.arc.geocam.memo;
import gov.nasa.arc.geocam.memo.service.GeoLocationListener;

import java.util.List;

import roboguice.application.RoboApplication;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.location.LocationManager;
import android.preference.PreferenceManager;

import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * The Class GeoCamMemoRoboApplication.
 */
public class GeoCamMemoRoboApplication extends RoboApplication {
	
	/** The listener. */
	private GeoLocationListener listener;
	
	/** The module. */
	private Module module = new GeoCamMemoModule();
    
	/* (non-Javadoc)
	 * @see android.app.Application#onCreate()
	 */
	@Override
	public void onCreate() {
		listener = new GeoLocationListener();
		
		final Injector injector = getInjector();
		LocationManager locationManager = injector.getInstance(LocationManager.class);
		locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000, 1, listener);		
		
		injector.injectMembers(this);
		setDefaultSettings();
        super.onCreate();
	}
	
	/* (non-Javadoc)
	 * @see roboguice.application.RoboApplication#addApplicationModules(java.util.List)
	 */
	protected void addApplicationModules(List<Module> modules) {
        modules.add(this.module);
    }
    
    /**
     * Sets the module.
     *
     * @param module the new module
     */
    public void setModule(Module module) {
        this.module = module;
        
    }
    
    /**
     * Gets the location.
     *
     * @return the location
     */
    public Location getLocation() {
    	return listener.getLocation();
    }
    
    
    /**
     * Sets the default settings.
     */
    private void setDefaultSettings() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        Editor editor = prefs.edit();
        
        if(null == prefs.getString("webapp_username", null))
            editor.putString("webapp_username", getString(R.string.default_username));
        if(null == prefs.getString("webapp_password", null))
        	editor.putString("webapp_password", getString(R.string.default_password));
        editor.commit();
    }
}
