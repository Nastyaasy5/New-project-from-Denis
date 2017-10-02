package com.booking.structure.core.panels;

import java.util.List;
import java.util.stream.Collectors;

import com.booking.structure.core.webdriver.AbstractPage;
import com.booking.structure.core.webdriver.AbstractPanel;

import net.serenitybdd.core.pages.WebElementFacade;

public class ResultsPanel extends AbstractPanel {

    private static final String SEARCH_RESULT_ITEMS = ".//a[@title and @rel]";

    public ResultsPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }


    public List<String> getResultItems() {
        return findMultipleBy(SEARCH_RESULT_ITEMS)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
}
