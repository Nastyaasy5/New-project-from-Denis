package jbehave.scenariosteps.s6pm_scenario_steps;

import jbehave.steps.booking_steps.SearchResultPageSteps;
import jbehave.steps.s6pm_steps.S6pmHomePageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;

public class S6pmAddInCartScenario {

    @Steps
    private S6pmHomePageSteps S6pmHomePageSteps;

    @Given("user has opened '6pm.com' site")
    public void userOpenedSite() {
        S6pmHomePageSteps.openPage();
    }
}
