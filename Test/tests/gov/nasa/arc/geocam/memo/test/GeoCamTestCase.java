package gov.nasa.arc.geocam.memo.test;

import gov.nasa.arc.geocam.memo.injected.InjectedTestRunner;
import junit.framework.TestCase;

import org.junit.runner.RunWith;

import roboguice.config.AbstractAndroidModule;

@RunWith(InjectedTestRunner.class)
public abstract class GeoCamTestCase extends TestCase {
	// containing class that forces use of injectedtestrunner
	// may be able to create other commonalities between test cases
}
