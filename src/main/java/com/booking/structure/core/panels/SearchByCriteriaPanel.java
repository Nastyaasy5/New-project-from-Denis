package com.booking.structure.core.panels;

import com.booking.structure.core.webdriver.AbstractPage;
import com.booking.structure.core.webdriver.AbstractPanel;

import com.booking.util.WaitUtil;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchByCriteriaPanel extends AbstractPanel {

    private static final String DESTINATION_INPUT = ".//input[contains(@class, 'sb-destination__input')]";

    private static final String OPEN_CHECK_IN_INPUT_DATEPICKER = "(.//i[contains(@class, 'bicon-downchevron')])[1]";
    private static final String OPEN_CHECK_OUT_INPUT_DATEPICKER = "(.//i[contains(@class, 'bicon-downchevron')])[2]";

    private static final String CHECK_IN_DATEPICKER_PANEL = "(.//div[@class='c2-calendar'])[1]";
    private static final String CHECK_OUT_DATEPICKER_PANEL = "(.//div[@class='c2-calendar'])[2]";

    private static final String AUTOCOMPLETE_LIST = "//ul[contains(@aria-label, 'List of suggested destinations')]//li";
    private static final String SEARCH_BUTTON = "(.//button[contains(@class, 'sb-searchbox__button')]//span)[1]";

    public SearchByCriteriaPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void fillInDestination(final String destinationInfo) {
        findBy(DESTINATION_INPUT).then().type(destinationInfo);
        final WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 10);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(AUTOCOMPLETE_LIST)));
        selectFirstItemFromAutoSuggestionList();
    }

    public DatePickerPanel openCheckInDatePicker() {
        final WebElementFacade checkInDatePickerPanel = findBy(CHECK_IN_DATEPICKER_PANEL);
        if (!checkInDatePickerPanel.isCurrentlyVisible()) {
            findBy(OPEN_CHECK_IN_INPUT_DATEPICKER).then().click();
        }
        return new DatePickerPanel(findBy(CHECK_IN_DATEPICKER_PANEL), getDriverDelegate());
    }

    public DatePickerPanel openCheckOutDatePicker() {
        final WebElementFacade checkOutDatePickerPanel = findBy(CHECK_OUT_DATEPICKER_PANEL);
        if (!checkOutDatePickerPanel.isCurrentlyVisible()) {
            findBy(OPEN_CHECK_OUT_INPUT_DATEPICKER).then().click();
        }
        return new DatePickerPanel(findBy(CHECK_OUT_DATEPICKER_PANEL), getDriverDelegate());
    }

    public void clickSearchButton() {
        findBy(SEARCH_BUTTON).then().click();
    }

    private void selectFirstItemFromAutoSuggestionList() {
        findMultipleBy(AUTOCOMPLETE_LIST)
                .stream()
                .findFirst()
                .ifPresent(WebElementFacade::click);
    }
}
