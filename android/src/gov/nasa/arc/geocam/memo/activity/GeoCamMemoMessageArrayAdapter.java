package gov.nasa.arc.geocam.memo.activity;

import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
		
		TextView tv = (TextView) row.findViewById(android.R.id.text1);
		tv.setText(getItem(position).getContent());
		
		return row;
	}	
}