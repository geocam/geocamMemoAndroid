package gov.nasa.arc.geocam.memo.service;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

/**
 * The Class MemoMapOverlay.
 */
public class MemoMapOverlay extends ItemizedOverlay<OverlayItem> {

	/**
	 * Instantiates a new memo map overlay.
	 *
	 * @param defaultMarker the default marker
	 */
	public MemoMapOverlay(Drawable defaultMarker) {
		super(boundCenterBottom(defaultMarker));
	}

	/** The m overlays. */
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	
	/**
	 * Adds the overlay.
	 *
	 * @param overlay the overlay
	 */
	public void addOverlay(OverlayItem overlay) {
	    mOverlays.add(overlay);
	    populate();
	}
	
	/* (non-Javadoc)
	 * @see com.google.android.maps.ItemizedOverlay#createItem(int)
	 */
	@Override
	protected OverlayItem createItem(int i) {
		return mOverlays.get(i);
	}

	/* (non-Javadoc)
	 * @see com.google.android.maps.ItemizedOverlay#size()
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return mOverlays.size();
	}

}
