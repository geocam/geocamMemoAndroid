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

// TODO: Auto-generated Javadoc
/**
 * The Class GeoCamMemoCreateActivity.
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
	 * On home click.
	 *
	 * @param v the v
	 */
	public void onHomeClick(View v) {
		UIUtils.goHome(this);
	}

	/**
	 * On send click.
	 *
	 * @param v the v
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
