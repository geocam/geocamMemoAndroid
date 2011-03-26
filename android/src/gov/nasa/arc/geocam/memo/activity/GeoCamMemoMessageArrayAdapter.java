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

public class GeoCamMemoMessageArrayAdapter extends ArrayAdapter<GeoCamMemoMessage> {
    
	@Inject protected static Provider<Context> contextProvider;
	@Inject LayoutInflater mInflater;
	
	public GeoCamMemoMessageArrayAdapter() {
		super(contextProvider.get(), R.layout.list_item);
	}
	
	public void setMemos(List<GeoCamMemoMessage> memos)
	{
		this.clear();
		for(GeoCamMemoMessage m:memos)
		{
			add(m);
		}
	}

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
		
		Date contentTimestamp = msg.getContentTimestamp();
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