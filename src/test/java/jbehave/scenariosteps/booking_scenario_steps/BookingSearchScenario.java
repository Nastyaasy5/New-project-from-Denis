package jbehave.scenariosteps.booking_scenario_steps;

import com.booking.util.DbUtil;
import org.apache.commons.lang3.StringUtils;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import net.thucydides.core.annotations.Steps;
import jbehave.steps.booking_steps.HotelSearchPageSteps;
import jbehave.steps.booking_steps.SearchResultPageSteps;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BookingSearchScenario {

    @Steps
    private HotelSearchPageSteps hotelSearchPageSteps;

    @Steps
    private SearchResultPageSteps searchResultPageSteps;

    private static final String DELIMITER = ",";

    @Given("user has opened 'Booking.com' site")
    public void userOpenedSite() {
        hotelSearchPageSteps.openPage();
    }

    @When("user selects 'Destination' by using following value: '$destination'")
    public void typeDestination(final String destination) {
        hotelSearchPageSteps.typeDestination(destination);
    }

    @When("user selects 'Destination' by using following values:$values")
    public void selectDestination(final ExamplesTable examplesTable) throws SQLException {
        final List<Map<String, String>> rows = examplesTable.getRows();
        for (int index = 0; index < rows.size(); index++) {
            final Map<String, String> row = rows.get(index);
            final String destinationValue = row.get("destination");
            final String checkinDate = row.get("checkInDate");
            typeDestination(destinationValue);
            typeCheckInDate(checkinDate);
        }
        DbUtil.connectToDb();
    }

    @When("user selects 'Check In' date by using following date: '$checkInDate'")
    public void typeCheckInDate(final String checkInDate) {
        final String[] dates = StringUtils.split(checkInDate, DELIMITER);
        hotelSearchPageSteps.selectCheckInCheckOutDate(dates, true);
    }

    @When("user selects 'Check Out' date by using following date: '$checkOutDate'")
    public void typeCheckOutDate(final String checkOutDate) {
        /*final String[] dates = StringUtils.split(checkOutDate, DELIMITER);
        hotelSearchPageSteps.selectCheckInCheckOutDate(dates, false);*/
    }

    @When("user cliks on 'Search' button")
    public void clickSearchButton() {
        hotelSearchPageSteps.search();
    }

    @Then("each item from 'Search Result' list contains '$searchedText'")
    public void isSearchResultListContainSearchedText(final String searchedText) {
        boolean res = searchResultPageSteps.isAllHotelsLocatedIn(searchedText);
        Assert.assertTrue(res);
    }
}
