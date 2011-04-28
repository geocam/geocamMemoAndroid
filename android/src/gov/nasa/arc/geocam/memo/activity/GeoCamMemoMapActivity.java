package gov.nasa.arc.geocam.memo.activity;

import java.util.List;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.maps.*;

import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.UIUtils;
import gov.nasa.arc.geocam.memo.service.MemoMapOverlay;
import roboguice.activity.RoboMapActivity;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;;

/**
 * The Class GeoCamMemoMapActivity.
 */
public class GeoCamMemoMapActivity extends RoboMapActivity{

	/** The map view. */
	@InjectView(R.id.mapview)	MapView mapView;
	
	/** The text view. */
	@InjectView(R.id.textview)  TextView textView;
	
	/** The map marker. */
	@InjectResource(R.drawable.map_marker) Drawable mapMarker;
	
	/** The latitude str. */
	@InjectResource(R.string.latitude) String latitudeStr;
	
	/** The longitude str. */
	@InjectResource(R.string.longitude) String longitudeStr;
	
	/** The accuracy str. */
	@InjectResource(R.string.accuracy) String accuracyStr;

	/** The map controller. */
	MapController mapController;
	
	/** The map overlays. */
	List<Overlay> mapOverlays;
	
	/** The drawable. */
	Drawable drawable;
	
	/** The itemized overlay. */
	MemoMapOverlay itemizedOverlay;

	/* (non-Javadoc)
	 * @see roboguice.activity.RoboMapActivity#onCreate(android.os.Bundle)
	 */
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_view);
		
		//Get the latitude and longitude from the Intent
		Intent intent = getIntent();
		double latitude = intent.getDoubleExtra(latitudeStr, 0.00);
		double longitude = intent.getDoubleExtra(longitudeStr, 0.00);
		int accuracy = intent.getIntExtra(accuracyStr, 0);
		
		//Create the text to put in the textView
		StringBuilder sb = new StringBuilder();
		sb.append(latitudeStr + ":\t" + latitude + "\n");
		sb.append(longitudeStr + ":\t" + longitude + "\n");	
		sb.append(accuracyStr + ":\t" + accuracy);
		textView.setText(sb.toString());
				
		mapView.setBuiltInZoomControls(true);
		mapOverlays = mapView.getOverlays();
				
		itemizedOverlay = new MemoMapOverlay(mapMarker);
		
		//Create a GeoPoint to signify the geolocation an overlay containing the geopoint
		GeoPoint point = new GeoPoint((int)(latitude * 1E6), 
				                      (int)(longitude * 1E6));
		OverlayItem overlayitem = new OverlayItem(point, "", "");
		itemizedOverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedOverlay);
		
		//Get the map controller and animate to the GeoPoint
		mapController = mapView.getController();
		mapController.animateTo(point);
		mapController.setZoom(16);
	}
	
	/**
	 * On home click.
	 *
	 * @param v the view
	 */
	public void onHomeClick(View v) {
		UIUtils.goHome(this);
	}
	
	/* (non-Javadoc)
	 * @see com.google.android.maps.MapActivity#isRouteDisplayed()
	 */
	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
	
}
