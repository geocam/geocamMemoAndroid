package gov.nasa.arc.geocam.memo.activity;

import com.google.inject.Inject;

import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.R.layout;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;
import roboguice.activity.RoboActivity;
import android.app.Activity;
import android.os.Bundle;

public class GeoCamMemo extends RoboActivity {
	
	@Inject protected DjangoMemoInterface djangoMemo;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);       
        setContentView(R.layout.main);
              
        djangoMemo.getMemos();
    }
}