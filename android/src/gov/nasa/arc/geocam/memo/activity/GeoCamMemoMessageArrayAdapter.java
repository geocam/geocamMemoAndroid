package gov.nasa.arc.geocam.memo.activity;

import java.text.SimpleDateFormat;
import java.util.Date;

import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import android.content.Context;
import android.opengl.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GeoCamMemoMessageArrayAdapter extends ArrayAdapter<GeoCamMemoMessage> {
    
	public GeoCamMemoMessageArrayAdapter(Context context,
			int textViewResourceId, GeoCamMemoMessage[] objects) {
		super(context, textViewResourceId, objects);
		mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	private LayoutInflater mInflater;
	
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