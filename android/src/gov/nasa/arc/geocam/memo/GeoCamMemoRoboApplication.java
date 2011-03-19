package gov.nasa.arc.geocam.memo;
import roboguice.application.RoboApplication;
import com.google.inject.Module;

import java.util.List;

public class GeoCamMemoRoboApplication extends RoboApplication{
    private Module module = new GeoCamMemoModule();

	protected void addApplicationModules(List<Module> modules) {
        modules.add(this.module);
    }
    
    public void setModule(Module module) {
        this.module = module;
        
    }
}
