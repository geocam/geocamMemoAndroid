// __BEGIN_LICENSE__
// Copyright (C) 2008-2010 United States Government as represented by
// the Administrator of the National Aeronautics and Space Administration.
// All Rights Reserved.
// __END_LICENSE__

package gov.nasa.arc.geocam.memo;

import gov.nasa.arc.geocam.memo.activity.GeoCamMemoMessageArrayAdapter;
import gov.nasa.arc.geocam.memo.service.DjangoMemoImplementation;
import gov.nasa.arc.geocam.memo.service.DjangoMemoInterface;
import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterImplementation;
import gov.nasa.arc.geocam.memo.service.DjangoMemoJsonConverterInterface;
import gov.nasa.arc.geocam.memo.service.SiteAuthCookieImplementation;
import gov.nasa.arc.geocam.memo.service.SiteAuthInterface;
import roboguice.config.AbstractAndroidModule;


/**
 * The Class GeoCamMemoModule.
 */
public class GeoCamMemoModule extends AbstractAndroidModule{

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		requestStaticInjection(GeoCamMemoMessageArrayAdapter.class);
		requestStaticInjection(DjangoMemoImplementation.class);
		bind(DjangoMemoInterface.class).to(DjangoMemoImplementation.class);
		bind(DjangoMemoJsonConverterInterface.class)
		    .to(DjangoMemoJsonConverterImplementation.class);
		bind(SiteAuthInterface.class).toInstance(new SiteAuthCookieImplementation());		
	}
	
	
}
