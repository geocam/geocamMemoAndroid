package gov.nasa.arc.geocam.memo.activity;

import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.service.SiteAuthInterface;
import roboguice.activity.RoboPreferenceActivity;
import android.os.Bundle;

import com.google.inject.Inject;

/**
 * The Class GeoCamMemoSettings.
 */
public class GeoCamMemoSettings extends RoboPreferenceActivity {
    
    /** The site auth interface. */
    @Inject SiteAuthInterface siteAuthInterface;
	
	/* (non-Javadoc)
	 * @see roboguice.activity.RoboPreferenceActivity#onCreate(android.os.Bundle)
	 */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.layout.settings);
    }
    
}