package gov.nasa.arc.geocam.memo.activity;

import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.service.SiteAuthInterface;
import roboguice.activity.RoboPreferenceActivity;
import android.os.Bundle;

import com.google.inject.Inject;

public class GeoCamMemoSettings extends RoboPreferenceActivity {
    @Inject SiteAuthInterface siteAuthInterface;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.layout.settings);
    }
    
}