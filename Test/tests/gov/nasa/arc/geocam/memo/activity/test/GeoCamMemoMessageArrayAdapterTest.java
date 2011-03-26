package gov.nasa.arc.geocam.memo.activity.test;

import gov.nasa.arc.geocam.memo.R;
import gov.nasa.arc.geocam.memo.activity.GeoCamMemoMessageArrayAdapter;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.injected.FakeGeoCamMemoMessageFactory;
import gov.nasa.arc.geocam.memo.test.GeoCamTestCase;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.xtremelabs.robolectric.Robolectric;

public class GeoCamMemoMessageArrayAdapterTest extends GeoCamTestCase{
	
	@Test
	public void shouldProperlyDisplayGeolocaionStatus() throws Exception {
		//arrange
		List<GeoCamMemoMessage> msgs = new ArrayList<GeoCamMemoMessage>();
		
		msgs.add(FakeGeoCamMemoMessageFactory.getMessage("testing", "Patrick", true));
		msgs.add(FakeGeoCamMemoMessageFactory.getMessage("testing2", "Not Patrick", false));

		GeoCamMemoMessageArrayAdapter adapter = new GeoCamMemoMessageArrayAdapter(); 
		adapter.setMemos(msgs);
		
		View temp1 = View.inflate(Robolectric.application.getApplicationContext(), R.layout.list_item, null);		
		View temp2 = View.inflate(Robolectric.application.getApplicationContext(), R.layout.list_item, null);		
		
        //act
		LinearLayout geoLocatedMsgView = (LinearLayout) adapter.getView(0, temp1, null);
		LinearLayout nonGeoLocatedMsgView = (LinearLayout) adapter.getView(1, temp2, null);
        
		//assert
		assertTrue(((ImageView) geoLocatedMsgView.findViewById(R.id.hasGeoLocation)).getVisibility() == View.VISIBLE);
		assertTrue(((ImageView) nonGeoLocatedMsgView.findViewById(R.id.hasGeoLocation)).getVisibility() == View.INVISIBLE);
	}

}
