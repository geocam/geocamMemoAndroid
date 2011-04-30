// __BEGIN_LICENSE__
// Copyright (C) 2008-2010 United States Government as represented by
// the Administrator of the National Aeronautics and Space Administration.
// All Rights Reserved.
// __END_LICENSE__

package gov.nasa.arc.geocam.memo.activity;

import gov.nasa.arc.geocam.memo.GeoCamMemoRoboApplication;
import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.UIUtils;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.exception.AuthenticationFailedException;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;

import java.util.Date;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.inject.Inject;

/**
 * The Class GeoCamMemoCreateActivity.  This activity gives the 
 * user the opportunity to add a new memo
 */
public class GeoCamMemoCreateActivity extends RoboActivity {

	/** The new memo input. */
	@InjectView(R.id.newMemoInput)
	EditText newMemoInput;
	
	/** The app state. */
	@Inject
	GeoCamMemoRoboApplication appState;
	
	/** The django memo interface. */
	@Inject
	DjangoMemoInterface djangoMemoInterface;

	/**
	 * Called when the activity is first created.
	 *
	 * @param savedInstanceState the saved instance state
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_memo);
	}

	/**
	 * On home click, restart the {@link GeoCamMemoHomeActivity}.
	 *
	 * @param v the view
	 */
	public void onHomeClick(View v) {
		UIUtils.goHome(this);
	}

	/**
	 * On send click, create a new {@link GeoCamMemoMessage} using the 
	 * text and time stamp from the {@link GeoCamMemoCreateActivity}.  Populate
	 * the location if available.  
	 *
	 * @param v the view
	 */
	public void onSendClick(View v) {
		CharSequence text = newMemoInput.getText();

		Location location = appState.getLocation();

		GeoCamMemoMessage message = new GeoCamMemoMessage();
		message.setContent(text.toString());
		message.setContentTimestamp(new Date());

		if (location != null) {
			message.setLatitude(location.getLatitude());
			message.setLongitude(location.getLongitude());
			if (location.hasAccuracy()) {
				message.setAccuracy((int) location.getAccuracy());
			}
		}

		try {
			djangoMemoInterface.createMemo(message);
			UIUtils.goHome(this);
		} catch (AuthenticationFailedException e) {
			UIUtils.displayException(this, e, "Could not authenticate with the server");
		} catch (Exception e) {
			UIUtils.displayException(this, e, "Communication with the server failed");
		}

	}
}
