package org.luv2code.o3_quick_start;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class LocatorStrategiesTest extends BaseTest {

    @Test
    public void locatorStrategiesTest() {

        page.navigate("https://www.luv2test.com/#/registration-form");

        // locate by role-based
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name"));

        // locate by app test Ids
        page.getByTestId("password");

        // locate by label and placeholder
        page.getByLabel("address");
        //page.getByPlaceholder("placeholder");

        // locate by Text locator
        page.getByText("Email:");
        //page.getByAltText("King Image");

        // locate by Title locator
        page.getByTitle("Luv2Code Automation");

        // locate by css selector
        page.locator("input[type=text]");

        // locate by xpath
        page.locator("//input[@id='gender-female']");

        // locate by nth locator (index based)
        page.locator("input[type='radio']").nth(1);
    }
}
