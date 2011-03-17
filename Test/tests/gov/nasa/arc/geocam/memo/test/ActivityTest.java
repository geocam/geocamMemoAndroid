package gov.nasa.arc.geocam.memo.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import gov.nasa.arc.geocam.memo.GeoCamMemo;
import gov.nasa.arc.geocam.memo.R;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.xtremelabs.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class ActivityTest {
	@Test
    public void shouldHaveHappySmiles() throws Exception {
        String hello = new GeoCamMemo().getResources().getString(R.string.hello);
        assertThat(hello, equalTo("Hello World, GeoCamMemo!"));
    }
}