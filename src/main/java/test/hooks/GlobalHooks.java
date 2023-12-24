package test.hooks;

import io.cucumber.java.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import test.context.ScenarioContext;
import test.logger.CustomLoggerConfigurationFactory;

import static java.lang.String.format;

public class GlobalHooks {

    private final static Logger LOGGER = LogManager.getLogger(GlobalHooks.class);

    @Before
    public void beforeTest(Scenario scenario) {
        LOGGER.info(format("==============[SCENARIO STARTED: %s]==============", scenario.getName()));
    }

    @Before(order = 1)
    public void setUpLoggingConfiguration(Scenario scenario) {
        String scenarioName = scenario.getName();
        CustomLoggerConfigurationFactory.updateLogConfig(scenarioName);
    }

    @After
    public void afterTest(Scenario scenario) {
        String scenarioName = scenario.getName();
        LOGGER.info(format("==============[SCENARIO ENDED: %s has %s]==============",
                scenarioName, scenario.getStatus().toString().toUpperCase()));
    }

    @After
    public void clearContext() {
        ScenarioContext.getInstance().clearContext();
    }

    @BeforeStep
    public void beforeStep() {
        LOGGER.info("==============[STEP STARTED]==============");
    }

    @AfterStep
    public void afterStep() {
        LOGGER.info("==============[STEP ENDED]==============");
    }
}
