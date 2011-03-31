package gov.nasa.arc.geocam.memo.activity.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.activity.GeoCamMemoHomeActivity;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.injected.FakeDjangoMemoImplementation;
import gov.nasa.arc.geocam.memo.test.GeoCamTestCase;

import java.util.List;

import org.junit.Test;

import android.widget.ListView;

import com.google.inject.Inject;


public class GeoCamMemoHomeActivityTest extends GeoCamTestCase {	
	@Inject GeoCamMemoHomeActivity activity;
	@Inject FakeDjangoMemoImplementation fakeDjangoMemo;
	
	
	
	@Test
    public void shouldHaveHappySmiles() throws Exception {
        String hello = new GeoCamMemoHomeActivity().getResources().getString(R.string.hello);
        assertThat(hello, equalTo("Hello World, GeoCamMemo!"));                
    }
	
	@Test
	public void shouldDisplayMemos() throws Exception {
		//arrange
		activity.onCreate(null);
		List<GeoCamMemoMessage>fakeMemoList = fakeDjangoMemo.getMemos();
	    
        //act
        ListView geoCamListView = (ListView)activity.findViewById(R.id.MemoListView);
        
		//assert
        assertThat(geoCamListView.getChildCount(), equalTo(fakeMemoList.size()));
	}
}