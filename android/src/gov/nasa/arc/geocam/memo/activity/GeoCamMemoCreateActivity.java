package gov.nasa.arc.geocam.memo.activity;

import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.UIUtils;
import android.os.Bundle;
import android.view.View;
import roboguice.activity.RoboActivity;

public class GeoCamMemoCreateActivity extends RoboActivity{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_memo);
	}

	public void onHomeClick(View v) {
		UIUtils.goHome(this);
	}
}
