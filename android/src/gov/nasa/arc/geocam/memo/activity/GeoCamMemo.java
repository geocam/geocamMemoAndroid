package gov.nasa.arc.geocam.memo.activity;

import java.util.List;

import com.google.inject.Inject;

import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.R.layout;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;
import roboguice.activity.RoboActivity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class GeoCamMemo extends RoboActivity {
	
	@Inject DjangoMemoInterface djangoMemo;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);       
        setContentView(R.layout.main);
                      
        List<String>memoList = djangoMemo.getMemos();
        ListView memoListView = (ListView)findViewById(R.id.MemoListView);        
        memoListView.setAdapter(new ArrayAdapter(this, R.id.MemoListView, memoList.toArray()));                
    }
}