// __BEGIN_LICENSE__
// Copyright (C) 2008-2010 United States Government as represented by
// the Administrator of the National Aeronautics and Space Administration.
// All Rights Reserved.
// __END_LICENSE__

package gov.nasa.arc.geocam.memo.activity;

import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.inject.Inject;
import com.google.inject.Provider;


/**
 * The Class GeoCamMemoMessageArrayAdapter.
 */
public class GeoCamMemoMessageArrayAdapter extends ArrayAdapter<GeoCamMemoMessage> {
    
	/** The context provider. */
	@Inject protected static Provider<Context> contextProvider;
	
	/** The m inflater. */
	@Inject LayoutInflater mInflater;
	
	/**
	 * Instantiates a new geo cam memo message array adapter.
	 */
	public GeoCamMemoMessageArrayAdapter() {
		super(contextProvider.get(), R.layout.list_item);
	}
	
	/**
	 * Sets the memos.
	 *
	 * @param memos the new memos
	 */
	public void setMemos(List<GeoCamMemoMessage> memos)
	{
		this.clear();
		for(GeoCamMemoMessage m:memos)
		{
			add(m);
		}
	}

	/* (non-Javadoc)
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row;
		        		
		if (null == convertView) {
			row = mInflater.inflate(R.layout.list_item, null);
		} else {
			row = convertView;
		}
		
		TextView contentTextView = 
			(TextView) row.findViewById(R.id.content);
		TextView fullnameTextView = 
			(TextView) row.findViewById(R.id.fullname);
		TextView contentTimestampTextView = 
			(TextView) row.findViewById(R.id.content_timestamp);
		ImageView geolocationImageView = 
			(ImageView) row.findViewById(R.id.hasGeoLocation);
		
		GeoCamMemoMessage msg = getItem(position);
		
		contentTextView.setText(msg.getContent());
		fullnameTextView.setText(msg.getAuthorFullname());
		
		Date contentTimestamp = msg.getContentTimestampDate();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
		contentTimestampTextView.setText(sdf.format(contentTimestamp));
		
		if(msg.hasGeolocation())
		{
			geolocationImageView.setVisibility(View.VISIBLE);
		}
		else
		{
			geolocationImageView.setVisibility(View.INVISIBLE);
		}
		
		return row;
	}	
}