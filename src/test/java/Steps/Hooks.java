package Steps;

import Core.DriverConfig;
import cucumber.api.java.*;

public class Hooks {
    @Before
    public void beforeScenario(){
        DriverConfig.initialize();
    }

    @After
    public void afterScenario(){
        DriverConfig.quit();
    }
}
