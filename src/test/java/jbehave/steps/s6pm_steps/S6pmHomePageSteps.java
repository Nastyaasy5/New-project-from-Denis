package jbehave.steps.s6pm_steps;

import com.booking.structure.core.pages.booking_pages.HotelsSearchPage;
import com.booking.structure.core.pages.s6pm_pages.S6pmHomePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;


public class S6pmHomePageSteps extends ScenarioSteps {

    private S6pmHomePage s6pmHomePage;

    public S6pmHomePageSteps(final Pages pages) {
        super(pages);
        s6pmHomePage = getPages().getPage(S6pmHomePage.class);
    }

    @Step
    public void openPage() {
        s6pmHomePage.open();
    }
}
