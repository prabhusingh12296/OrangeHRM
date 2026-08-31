package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtils;
import driver.DriverManager;

public class Hooks {

    @Before
    public void setUp() {

        DriverManager.initializeDriver();
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            byte[] screenshot =
                    ScreenshotUtils.captureScreenshot();

            scenario.attach(
                    screenshot,
                    "image/png",
                    scenario.getName());
        }

        DriverManager.quitDriver();
    }
}