package gov.nasa.arc.geocam.memo;
import roboguice.application.RoboApplication;
import com.google.inject.Module;

import java.util.List;

public class GeoCamMemoRoboApplication extends RoboApplication{
    protected void addApplicationModules(List<Module> modules) {
        modules.add(new GeoCamMemoModule());
    }
}
