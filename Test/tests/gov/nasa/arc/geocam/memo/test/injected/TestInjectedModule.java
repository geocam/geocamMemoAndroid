package gov.nasa.arc.geocam.memo.test.injected;

import org.w3c.dom.css.Counter;

import com.google.inject.Scopes;

import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;
import roboguice.config.AbstractAndroidModule;

public class TestInjectedModule extends AbstractAndroidModule{

	@Override
	protected void configure() {
		// TODO Auto-generated method stub
		bind(Counter.class).in(Scopes.SINGLETON);
		bind(DjangoMemoInterface.class).to(FakeDjangoMemoImplementation.class);
	}

	
}
