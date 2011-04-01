package gov.nasa.arc.geocam.memo;
import gov.nasa.arc.geocam.memo.service.GeoLocationServiceImplementation;

import java.util.List;

import roboguice.application.RoboApplication;
import android.content.Context;
import android.content.Intent;

import com.google.inject.Injector;
import com.google.inject.Module;

public class GeoCamMemoRoboApplication extends RoboApplication{
	protected Context scope;
	
	private Module module = new GeoCamMemoModule();
    
	@Override
	public void onCreate() {
		final Injector injector = getInjector();
        scope = injector.getInstance(Context.class);
                
        startService(new Intent(scope, GeoLocationServiceImplementation.class));
        
        injector.injectMembers(this);
        super.onCreate();
	}
	
	
    protected void addApplicationModules(List<Module> modules) {
        modules.add(this.module);
    }
    
    public void setModule(Module module) {
        this.module = module;
        
    }
}
