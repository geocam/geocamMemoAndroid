package gov.nasa.arc.geocam.memo.activity;

import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.UIUtils;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.exception.AuthenticationFailedException;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;

import java.util.ArrayList;
import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.inject.Inject;

public class GeoCamMemoHomeActivity extends RoboActivity {

	@Inject	DjangoMemoInterface djangoMemo;
	@InjectView(R.id.MemoListView)ListView memoListView;
	@Inject	GeoCamMemoMessageArrayAdapter adapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		
		String username = prefs.getString("webapp_username", null);
		String password = prefs.getString("webapp_password", null);
		
		djangoMemo.setAuth(username, password);
		
		List<GeoCamMemoMessage> memos = new ArrayList<GeoCamMemoMessage>();
		try {
		
			memos = djangoMemo.getMemos();

		} catch (AuthenticationFailedException e) {
			UIUtils.displayException(this, e, "Could not authenticate with the server.");
		} catch (Exception e) {
			UIUtils.displayException(this, e, "Communication with the server failed.");
		}
 
		adapter.setMemos(memos);
		memoListView.setAdapter(adapter);
		
		memoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parentView, View childView,
					                                     int position, long id) {
				GeoCamMemoMessage msg = adapter.getItem(position);
				if (msg.hasGeolocation()) {
					UIUtils.showMapView(parentView.getContext(), msg);
				}
			}
		});

	}
	
	public void onCreateMemoClick(View v){
		UIUtils.createMemo(this);
	}
}