package gov.nasa.arc.geocam.memo.test;

import java.lang.reflect.Field;

import gov.nasa.arc.geocam.memo.injected.InjectedTestRunner;
import junit.framework.TestCase;

import org.junit.runner.RunWith;

import roboguice.config.AbstractAndroidModule;

@RunWith(InjectedTestRunner.class)
public abstract class GeoCamTestCase extends TestCase {
	// containing class that forces use of injectedtestrunner
	// may be able to create other commonalities between test cases

	public static void setHiddenField(Object objectToSet, String fieldName, Object valueToSet) throws ClassNotFoundException, SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
	{
		Class c = Class.forName(objectToSet.getClass().getName());
		Field fieldToSet = c.getDeclaredField(fieldName);
		fieldToSet.setAccessible(true);
		fieldToSet.set(objectToSet, valueToSet);
	}

}
