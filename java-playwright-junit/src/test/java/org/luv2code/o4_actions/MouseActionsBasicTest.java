package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.MouseButton;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class MouseActionsBasicTest extends BaseTest {

    @Test
    void mouseActionsBasicTest(){

        // navigate to ab-testing page
        page.navigate("https://www.luv2test.com/#/ab-testing");

        //move to element -> Toggle theme
        Locator lToggleThemeButton = page.locator("//button[@aria-label='Toggle theme']");
        lToggleThemeButton.hover();

        // basic click()
        lToggleThemeButton.click();
        waitInSeconds(2);

        // click on specific element
        page.locator("#variant-button-a").click();
        waitInSeconds(2);

        // perform double click
        Locator lVariantB = page.locator("#variant-button-b");
        lVariantB.dblclick();
        waitInSeconds(2);

        // click and hold, then release
        lVariantB.hover();
        page.mouse().down(); // click and hold
        page.mouse().up();; // release
        waitInSeconds(2);

        // navigate to context menu page
        page.navigate("https://www.luv2test.com/#/context-menu");

        // move to "Practice Image Upload" element
        Locator lImageUploadOption = page.locator("//li[text()='Practice Image Upload']");
        lImageUploadOption.hover();

        // right click / context click
        lImageUploadOption.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));

        // click on "context menu edit" button
        page.locator("//button[@data-test='context-menu-edit']").click();
        waitInSeconds(2);

    }

}
