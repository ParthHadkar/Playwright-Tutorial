package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class KeyboardActionsTest extends BaseTest {

    @Test
    void keyboardActionsTest() {

        // navigate to key-presses page
        page.navigate("https://www.luv2test.com/#/key-press");

        // perform keyboard events
        page.keyboard().press("A");
        page.keyboard().press("Enter");
        page.keyboard().press("Tab");
        page.keyboard().press("Escape");
        page.keyboard().press("Backspace");
        page.keyboard().press("Z");
        waitInSeconds(1);

        // navigate to authentication page
        page.navigate("https://www.luv2test.com/#/auth");

        // locate username and password fields
        Locator lUsername = page.locator("#username");
        Locator lPassword = page.locator("#password");

        // type 'admin' in username field
        lUsername.fill("admin");

        // select all text in username field (CMD + A)
        lUsername.click();
        page.keyboard().down("Control"); // for command mac Meta / User ctrl for windows
        page.keyboard().press("A");
        page.keyboard().up("Control");
        waitInSeconds(1);

        // copy selected text (CMD +C)
        page.keyboard().down("Control"); // for command mac Meta / User ctrl for windows
        page.keyboard().press("C");
        page.keyboard().up("Control");
        waitInSeconds(1);

        // click on password field
        lPassword.click();

        // paste copied text into password field (CMD + V)
        page.keyboard().down("Control"); // for command mac Meta / User ctrl for windows
        page.keyboard().press("V");
        page.keyboard().up("Control");
        waitInSeconds(1);

        // submit the form
        lPassword.press("Enter");
        waitInSeconds(3);
    }

}
