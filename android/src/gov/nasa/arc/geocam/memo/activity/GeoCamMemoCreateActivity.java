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

public class GeoCamMemoCreateActivity extends RoboActivity {

	@InjectView(R.id.newMemoInput)
	EditText newMemoInput;
	@Inject
	GeoCamMemoRoboApplication appState;
	@Inject
	DjangoMemoInterface djangoMemoInterface;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_memo);
	}

	public void onHomeClick(View v) {
		UIUtils.goHome(this);
	}

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
