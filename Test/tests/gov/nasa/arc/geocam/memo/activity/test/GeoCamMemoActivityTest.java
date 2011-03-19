package gov.nasa.arc.geocam.memo.activity.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.activity.GeoCamMemoActivity;
import gov.nasa.arc.geocam.memo.injected.FakeDjangoMemoImplementation;
import gov.nasa.arc.geocam.memo.injected.InjectedTestRunner;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import android.widget.ListView;

import com.google.inject.Inject;

@RunWith(InjectedTestRunner.class)
public class GeoCamMemoActivityTest{	
	@Inject GeoCamMemoActivity activity;
	@Inject FakeDjangoMemoImplementation fakeDjangoMemo;
	
	@Test
    public void shouldHaveHappySmiles() throws Exception {
        String hello = new GeoCamMemoActivity().getResources().getString(R.string.hello);
        assertThat(hello, equalTo("Hello World, GeoCamMemo!"));                
    }
	
	@Test
	public void shouldDisplayMemos() throws Exception {
		//arrange
		activity.onCreate(null);
		List<String>fakeMemoList = fakeDjangoMemo.getMemos();
	    
        //act
        ListView geoCamListView = (ListView)activity.findViewById(R.id.MemoListView);
        
		//assert
        assertThat(geoCamListView.getChildCount(), equalTo(fakeMemoList.size()));
	}
}