package gov.nasa.arc.geocam.memo.service.test;

import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.service.GsonJsonConverterImplementation;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;


public class GsonJsonConverterImplementationTest {
	
	@Test
	public void ensureProperParsingOfMessageListFeed() throws Exception
	{
		// arrange
		String jsonString = 
			"[{\"author\": \"Rufus Hornsby\", \"longitude\": null, \"content\": \"Crap, my geolocation service crashed and I am not providing geoloc with this message. This message should be the latest to make sure we gracefully fall back to the next available geolocated message.\", \"content_timestamp\": \"03/13 11:23:21\",\"latitude\": null, \"pk\": 19, \"accuracy\": null}, {\"author\": \"Rufus Hornsby\", \"longitude\": -122.057954, \"content\": \"Structural engineer not allowing access to building. Fire is too out of control. Fire squad alerted.\", \"content_timestamp\": \"03/13 10:48:44\", \"latitude\": 37.411629, \"pk\": 15, \"accuracy\":60.0}]";
		
		GeoCamMemoMessage message1 = new GeoCamMemoMessage();
		message1.setAuthorName("Rufus Hornsby");
		// don't set longitude
		message1.setContent("Crap, my geolocation service crashed and I am not providing geoloc with this message. This message should be the latest to make sure we gracefully fall back to the next available geolocated message.");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd hh:mm:ss");
		
		message1.setContentTimestamp(sdf.parse("03/13 11:23:21"));
		// don't set latitude
		message1.setMessageId(19);
		// don't set accuracy

		GeoCamMemoMessage message2 = new GeoCamMemoMessage();
		message2.setAuthorName("Rufus Hornsby");
		message2.setLongitude(-122.057954);
		message2.setContent("Structural engineer not allowing access to building. Fire is too out of control. Fire squad alerted.");
		message2.setContentTimestamp(sdf.parse("03/13 10:48:44"));
		message2.setLatitude(37.411629);
		message2.setMessageId(15);
		message2.setAccuracy(60);
		
		GsonJsonConverterImplementation<GeoCamMemoMessage> converter = new GsonJsonConverterImplementation<GeoCamMemoMessage>();
		
		// act
		List<GeoCamMemoMessage> resolvedList = converter.deserializeList(jsonString);
		
		// assert
		assertTrue(resolvedList.contains(message1));
	}
	
	
}
