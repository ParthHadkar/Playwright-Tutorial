package org.luv2code.framework.page;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    public HomePage(Page pPage) {
        super(pPage);
    }

    // locators
    private final String registrationLink = "text=Registration Form";

    // actions
    public void clickRegistrationLink() {
        click(registrationLink);
        //page.locator(registrationLink).click();
    }

}
