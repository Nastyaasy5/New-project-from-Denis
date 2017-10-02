package com.booking.structure.core.panels;

import com.booking.structure.core.webdriver.AbstractPage;
import com.booking.structure.core.webdriver.AbstractPanel;

import net.serenitybdd.core.pages.WebElementFacade;

public class DatePickerPanel extends AbstractPanel {

    private static final String MONTH_TABLE_PANEL = ".//table[.//th[contains(text(), '%s')]]";
    private static final String NEXT_MONTH_BUTTON = "(.//div[contains(@class, 'c2-button c2-button-further')]/span)[1]";

    public DatePickerPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public MonthPanel selectDate(final String monthAndYear) {
        final WebElementFacade monthPanel = findBy(String.format(MONTH_TABLE_PANEL, monthAndYear));
        while (!monthPanel.isDisplayed()) {
            findBy(NEXT_MONTH_BUTTON).then().click();
        }
        return new MonthPanel(monthPanel, getDriverDelegate());
    }
}
