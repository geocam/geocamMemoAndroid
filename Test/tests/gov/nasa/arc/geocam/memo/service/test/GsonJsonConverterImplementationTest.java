package gov.nasa.arc.geocam.memo.service.test;

import static org.junit.Assert.assertTrue;
import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;
import gov.nasa.arc.geocam.memo.service.GsonJsonConverterImplementation;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;


public class GsonJsonConverterImplementationTest {
	
	@Test
	public void ensureProperParsingOfMessageListFeed() throws Exception
	{
		// arrange
		String jsonString = 
			"[{\"authorUsername\": \"rhornsby\", \"longitude\": null, \"content\": \"Crap, my geolocation service crashed and I am not providing geoloc with this message. This message should be the latest to make sure we gracefully fall back to the next available geolocated message.\", \"contentTimestamp\": \"03/13/11 11:23:21\",\"latitude\": null, \"messageId\": 19, \"accuracy\": null}, {\"authorUsername\": \"rhornsby\", \"longitude\": -122.057954, \"content\": \"Structural engineer not allowing access to building. Fire is too out of control. Fire squad alerted.\", \"contentTimestamp\": \"03/13/11 10:48:44\", \"latitude\": 37.411629, \"messageId\": 15, \"accuracy\":60.0}]";
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
		GsonJsonConverterImplementation<GeoCamMemoMessage> converter =
			new GsonJsonConverterImplementation<GeoCamMemoMessage>();
		
		GeoCamMemoMessage message1 = new GeoCamMemoMessage();
		message1.setAuthorUsername("rhornsby");
		// don't set longitude
		message1.setContent("Crap, my geolocation service crashed and I am not providing geoloc with this message. This message should be the latest to make sure we gracefully fall back to the next available geolocated message.");
		message1.setContentTimestamp(sdf.parse("03/13/11 11:23:21"));
		// don't set latitude
		message1.setMessageId(19);
		// don't set accuracy

		GeoCamMemoMessage message2 = new GeoCamMemoMessage();
		message2.setAuthorUsername("rhornsby");
		message2.setLongitude(-122.057954);
		message2.setContent("Structural engineer not allowing access to building. Fire is too out of control. Fire squad alerted.");
		message2.setContentTimestamp(sdf.parse("03/13/11 10:48:44"));
		message2.setLatitude(37.411629);
		message2.setMessageId(15);
		message2.setAccuracy(60);
		
		// act
		List<GeoCamMemoMessage> resolvedList =
			converter.deserializeGeoCamMemoMessageList(jsonString);
		
		// assert
		assertTrue(resolvedList.contains(message1));
		assertTrue(resolvedList.contains(message2));
	}
	
//	@Test
//	public void funTimes() throws Exception {
//		// arrange
//		GsonJsonConverterImplementation<GeoCamMemoMessage> converter =
//			new GsonJsonConverterImplementation<GeoCamMemoMessage>();
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
//		
//		String jsonString = 
//			"{\"authorUsername\": \"rhornsby\", \"longitude\": -122.057954, \"content\": \"Structural engineer not allowing access to building. Fire is too out of control. Fire squad alerted.\", \"contentTimestamp\": \"03/13/11 10:48:44\", \"latitude\": 37.411629, \"messageId\": 15, \"accuracy\":60.0}";
//		
//		GeoCamMemoMessage message = new GeoCamMemoMessage();
//		message.setAuthorUsername("rhornsby");
//		message.setLongitude(-122.057954);
//		message.setContent("Structural engineer not allowing access to building. Fire is too out of control. Fire squad alerted.");
//		message.setContentTimestamp(sdf.parse("03/13/11 10:48:44"));
//		message.setLatitude(37.411629);
//		message.setMessageId(15);
//		message.setAccuracy(60);
//		
//		// act
//		GeoCamMemoMessage convertedMessage = converter.deserializeGeoCamMemoMessageList(jsonString);
//		
//		// arrange
//		assertEquals(message, convertedMessage);
//	}
}
