package gov.nasa.arc.geocam.memo.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.activity.GeoCamMemo;
import gov.nasa.arc.geocam.memo.service.DjangoMemoImplementation;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;
import gov.nasa.arc.geocam.memo.test.injected.FakeDjangoMemoImplementation;
import gov.nasa.arc.geocam.memo.test.injected.InjectedTestRunner;
import roboguice.activity.RoboActivity;
import roboguice.config.AbstractAndroidModule;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.widget.ListView;

import com.google.inject.Inject;
import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(InjectedTestRunner.class)
public class ActivityTest{	
	@Inject GeoCamMemo activity;
	@Inject FakeDjangoMemoImplementation fakeDjangoMemo;
	
	@Test
    public void shouldHaveHappySmiles() throws Exception {
        String hello = new GeoCamMemo().getResources().getString(R.string.hello);
        assertThat(hello, equalTo("Hello World, GeoCamMemo!"));                
    }
	
	@Test
	public void shouldDisplayMemos() throws Exception {
		//arrange
		activity.onCreate(null);
		//FakeDjangoMemoImplementation fakeDjangoMemo = new FakeDjangoMemoImplementation();
        List<String>fakeMemoList = fakeDjangoMemo.getMemos();
        activity.setContentView(R.layout.main);
	    
        //act
        ListView geoCamListView = (ListView)new GeoCamMemo().findViewById(R.id.MemoListView);       
        
		//assert
        assertThat(geoCamListView.getChildCount(), equalTo(fakeMemoList.size()));
	}
}