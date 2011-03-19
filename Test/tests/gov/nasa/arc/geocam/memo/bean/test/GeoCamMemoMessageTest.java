package gov.nasa.arc.geocam.memo.bean.test;

import java.text.SimpleDateFormat;

import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;

import org.junit.Test;
import static org.junit.Assert.*;


public class GeoCamMemoMessageTest {
	@Test
	public void testEqualsMethodTrue() throws Exception
	{
		
		// arrange
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd hh:mm:ss");
				
		GeoCamMemoMessage message1 = new GeoCamMemoMessage();
		message1.setAuthorName("Rufus Hornsby");
		message1.setLongitude(-122.057954);
		message1.setContent("Structural engineer not allowing access to building. Fire is too out of control. Fire squad alerted.");
		message1.setContentTimestamp(sdf.parse("03/13 10:48:44"));
		message1.setLatitude(37.411629);
		message1.setMessageId(15);
		message1.setAccuracy(60);

		GeoCamMemoMessage message2 = new GeoCamMemoMessage();
		message2.setAuthorName("Rufus Hornsby");
		message2.setLongitude(-122.057954);
		message2.setContent("Structural engineer not allowing access to building. Fire is too out of control. Fire squad alerted.");
		message2.setContentTimestamp(sdf.parse("03/13 10:48:44"));
		message2.setLatitude(37.411629);
		message2.setMessageId(15);
		message2.setAccuracy(60);
				
		// assert
		assertTrue(message1.equals(message2));
	}
	@Test
	public void testEqualsMethodFalse() throws Exception
	{ 
		// arrange
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd hh:mm:ss");
				
		GeoCamMemoMessage message1 = new GeoCamMemoMessage();
		message1.setAuthorName("Rufus Hornsby");
		message1.setLongitude(-122.057954);
		message1.setContent("Structural engineer not allowing access to building. Fire is too out of control. Fire squad alerted.");
		message1.setContentTimestamp(sdf.parse("03/13 10:48:44"));
		message1.setLatitude(37.411629);
		message1.setMessageId(15);
		message1.setAccuracy(60);

		GeoCamMemoMessage message2 = new GeoCamMemoMessage();
		message2.setAuthorName("Rufus Hornsby");
		message2.setLongitude(-122.057954);
		message2.setContent("Structural guy not allowing access to building. Fire is too out of control. Fire squad alerted."); // change here!
		message2.setContentTimestamp(sdf.parse("03/13 10:48:44"));
		message2.setLatitude(37.411629);
		message2.setMessageId(15);
		message2.setAccuracy(60);
				
		// assert
		assertFalse(message1.equals(message2));
	}
}
