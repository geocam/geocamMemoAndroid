// __BEGIN_LICENSE__
// Copyright (C) 2008-2010 United States Government as represented by
// the Administrator of the National Aeronautics and Space Administration.
// All Rights Reserved.
// __END_LICENSE__

package gov.nasa.arc.geocam.memo.service.test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import gov.nasa.arc.geocam.memo.exception.AuthenticationFailedException;
import gov.nasa.arc.geocam.memo.service.SiteAuthCookieImplementation;
import gov.nasa.arc.geocam.memo.test.GeoCamTestCase;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.cookie.Cookie;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.junit.Test;

import com.xtremelabs.robolectric.Robolectric;

public class SiteAuthCookieImplementationTest extends GeoCamTestCase{

	private String username = "user";
	private String password = "pass";
	
	private void prepLoginResponse(boolean successful)
	{
		int statusCode = successful ? 302 : 200;
		StatusLine sl = new BasicStatusLine(
				new ProtocolVersion("HTTP", 1, 0),
				statusCode, "some reason");
		HttpResponse response = new BasicHttpResponse(sl);
		
		response.addHeader("Set-Cookie", " sessionid=value2; Expires=Sat, 01 Jan 2050 10:18:14 GMT");
		
		Robolectric.addPendingHttpResponse(response);
	}

	private void prepResponse(int statusCode, String content) throws Exception
	{
		StatusLine sl = new BasicStatusLine(
				new ProtocolVersion("HTTP", 1, 0),
				statusCode, "some reason");
		HttpResponse response = new BasicHttpResponse(sl);
		InputStream is = new ByteArrayInputStream(content.getBytes());	
		HttpEntity he = mock(HttpEntity.class);
		when(he.getContent()).thenReturn(is);
		response.setEntity(he);
		
		Robolectric.addPendingHttpResponse(response);		
	}
	
	private SiteAuthCookieImplementation prepSaciWithInjections(boolean loggedin) throws Exception
	{
		SiteAuthCookieImplementation saci = new SiteAuthCookieImplementation();
		setHiddenField(saci, "serverRootUrl", "");
		setHiddenField(saci, "appPath", "");
		
		Cookie cookie = mock(Cookie.class);
		when(cookie.isExpired(any(Date.class))).thenReturn(!loggedin);
		if(loggedin);
		saci.setAuth(username, password);
		
		setHiddenField(saci, "sessionIdCookie", cookie);
		return saci;
	}
	
	@Test
	public void testSuccessfulGet() throws Exception
	{
		// arrange
		SiteAuthCookieImplementation saci = prepSaciWithInjections(true);
		prepResponse(200, "TestResponse");
		
		// act
		String responseText = saci.get("test", null);
		
		// assert
		assertEquals("TestResponse", responseText);
	}
	
	@Test
	public void testSuccessfulPost() throws Exception
	{
		// arrange
		SiteAuthCookieImplementation saci = prepSaciWithInjections(true);
		prepResponse(200, "");
		
		// act
		int responseStatusCode = saci.post("test", null);
		
		// assert
		assertEquals(200, responseStatusCode);
	}

	@Test
	public void testLoginFailureGet() throws Exception
	{
		// arrange
		SiteAuthCookieImplementation saci = prepSaciWithInjections(false);
		prepResponse(200, "");
		
		// act & assert
		try{
			saci.get("test", null);
			fail(); // we should have thrown! FAIL FAIL FAIL
		} catch (AuthenticationFailedException e)
		{
			// we've successfully thrown auth failed exception
		}
	}

	
	
	@Test
	public void testLoginFailurePost() throws Exception
	{
		// arrange
		SiteAuthCookieImplementation saci = prepSaciWithInjections(false);
		prepResponse(200, "");
		
		// act & assert
		try{
			saci.post("test", null);
			fail(); // we should have thrown! FAIL FAIL FAIL
		} catch (AuthenticationFailedException e)
		{
			// we've successfully thrown auth failed exception
		}
	}
}
