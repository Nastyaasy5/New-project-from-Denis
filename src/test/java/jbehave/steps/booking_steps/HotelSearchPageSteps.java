package jbehave.steps.booking_steps;

import com.booking.structure.core.pages.booking_pages.HotelsSearchPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;


public class HotelSearchPageSteps extends ScenarioSteps {

    private HotelsSearchPage hotelsSearchPage;

    public HotelSearchPageSteps(final Pages pages) {
        super(pages);
        hotelsSearchPage = getPages().getPage(HotelsSearchPage.class);
    }

    @Step
    public void openPage() {
        hotelsSearchPage.open();
    }

    @Step
    public void typeDestination(final String destination) {
        hotelsSearchPage.getSearchByCriteriaPanel()
                .fillInDestination(destination);
    }

    @Step
    public void selectCheckInCheckOutDate(final String[] dates, final boolean isCheckInDate) {
        if (isCheckInDate) {
            typeCheckInDate(dates);
        } else {
            typeCheckOutDate(dates);
        }
    }

    private void typeCheckInDate(final String[] checkInDate) {
        hotelsSearchPage.getSearchByCriteriaPanel()
                .openCheckInDatePicker()
                .selectDate(checkInDate[0])
        .selectDateByValue(checkInDate[1]);
    }

    private void typeCheckOutDate(final String[] checkInDate) {
        hotelsSearchPage.getSearchByCriteriaPanel()
                .openCheckOutDatePicker()
                .selectDate(checkInDate[0])
                .selectDateByValue(checkInDate[1]);
    }

    @Step
    public void typeCheckOutDate(final String checkOutDate) {
    }

    @Step
    public void search() {
        hotelsSearchPage.getSearchByCriteriaPanel()
                .clickSearchButton();
    }
}
