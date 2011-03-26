package gov.nasa.arc.geocam.memo.injected;

import java.util.Calendar;
import java.util.GregorianCalendar;

import gov.nasa.arc.geocam.memo.bean.GeoCamMemoMessage;

public class FakeGeoCamMemoMessageFactory {

	public static int messageId = 0;
	public static GregorianCalendar cal = new GregorianCalendar();
	
	final static double CMUSVLAT = 37.41029;
	final static double CMUSVLON = -122.05944;
	final static double MAXDIST = 1;
	
	
	public static GeoCamMemoMessage getMessage(String contents, String fullname, boolean hasGeolocation)
	{
		GeoCamMemoMessage msg = new GeoCamMemoMessage();
		msg.setAuthorFullname(fullname);
		msg.setAuthorUsername(fullname.replaceAll(" ", "").toLowerCase());
		msg.setContent(contents);
		msg.setMessageId(messageId++);
		msg.setHasGeolocation(hasGeolocation);
		if(hasGeolocation)
		{
			msg.setLatitude(Math.random()*MAXDIST + CMUSVLAT);			
			msg.setLongitude(Math.random()*MAXDIST + CMUSVLON);
			msg.setAccuracy((int)(Math.random() * 600));
		}
		cal.add(Calendar.SECOND, (int)(Math.random() * 60));
		msg.setContentTimestamp(cal.getTime());
		
		return msg;
	}
}
