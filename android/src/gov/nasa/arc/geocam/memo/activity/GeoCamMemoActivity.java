package gov.nasa.arc.geocam.memo.activity;

import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;

import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.inject.Inject;

public class GeoCamMemoActivity extends RoboActivity {
	
	@Inject DjangoMemoInterface djangoMemo;
	@InjectView(R.id.MemoListView) ListView memoListView;
	
	private LayoutInflater mInflater;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
                      
        List<String>memoList = djangoMemo.getMemos();
        
        mInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        memoListView.setAdapter(new ArrayAdapter<String>(this, R.layout.list_item, memoList) {
        	@Override
        	public View getView(int position, View convertView, ViewGroup parent) {
        		View row;
        		        		
        		if (null == convertView) {
        			row = mInflater.inflate(R.layout.list_item, null);
        		} else {
        			row = convertView;
        		}
        		
        		TextView tv = (TextView) row.findViewById(android.R.id.text1);
        		tv.setText(getItem(position));
        		
        		return row;
        	}
        });
    }
}