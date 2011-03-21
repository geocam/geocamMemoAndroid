package gov.nasa.arc.geocam.memo.test;

import gov.nasa.arc.geocam.memo.injected.InjectedTestRunner;
import junit.framework.TestCase;

import org.junit.runner.RunWith;

import roboguice.config.AbstractAndroidModule;

@RunWith(InjectedTestRunner.class)
public abstract class GeoCamTestCase extends TestCase {
	public AbstractAndroidModule testCaseModule = null;
	
	
}
