package com.booking.structure.core.pages.s6pm_pages;

import com.booking.structure.core.panels.SearchByCriteriaPanel;
import com.booking.structure.core.webdriver.AbstractPage;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@DefaultUrl("http://www.6pm.com/")
public class S6pmHomePage extends AbstractPage {

    public S6pmHomePage(final WebDriver driver) {
        super(driver);
    }
}
