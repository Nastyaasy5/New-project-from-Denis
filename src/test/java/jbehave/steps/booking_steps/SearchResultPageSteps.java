package jbehave.steps.booking_steps;

import com.booking.structure.core.pages.booking_pages.SearchResultPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SearchResultPageSteps extends ScenarioSteps {

    private final SearchResultPage searchResultPage;

    public SearchResultPageSteps(final Pages pages) {
        super(pages);
        searchResultPage = getPages().getPage(SearchResultPage.class);
    }

    @Step
    public boolean isAllHotelsLocatedIn(final String location) {
        return searchResultPage.getResultsPanel()
                .getResultItems()
                .contains(location);
    }
}
