package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class InteractingWithWebElementsTest extends BaseTest {

    @Test
    void interactingWithWebElementsTest() {

        // click on registration form link
        page.locator("[data-test='nav-registration-form']").click();

        // verify the page heading
        page.locator("//h1[text()='User Registration Form']").isVisible();

        waitInSeconds(1);

        // send full name to "Full Name" text field
        page.locator("#fullName").fill("Val pinto");

        // send full name to "Password" field
        Locator lPasswordField = page.locator("[name='password']");
        lPasswordField.fill("Ben");

        waitInSeconds(1);

        // submit the registration form
        lPasswordField.press("Enter");

        waitInSeconds(2);

        // clear the "Password" field
        lPasswordField.clear();

        // send valid password to "Password" field
        lPasswordField.type("BhaJha");

        // submit the registration form
        lPasswordField.press("Enter");

        waitInSeconds(2);

        System.out.println("Success");

    }
}
