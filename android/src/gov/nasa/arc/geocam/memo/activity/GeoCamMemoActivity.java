package gov.nasa.arc.geocam.memo.activity;

import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;

import java.util.ArrayList;
import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Context;
import android.content.res.Resources.Theme;
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
	@Inject GeoCamMemoMessageArrayAdapter adapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        List<GeoCamMemoMessage> memos = djangoMemo.getMemos();
        
        adapter.setMemos(memos);
        
        memoListView.setAdapter(adapter);
    }
}