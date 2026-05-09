package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.BoundingBox;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class RetrievingElementInfoAndStatesTest extends BaseTest {

    @Test
    void retrievingElementInfoAndStatesTest() {

        // Retrieving element information
        Locator lHeading = page.locator("h1");
        System.out.println("Text: "+lHeading.innerText());
        System.out.println("Tag Name: "+lHeading.evaluate("el => el.tagName.toLowerCase()"));
        System.out.println("Attributes (class): "+lHeading.getAttribute("class"));
        System.out.println("Css value (color): "+lHeading.evaluate("el => getComputedStyle(el).color"));

        BoundingBox lBoundingBox = lHeading.boundingBox();
        System.out.println("Location: (x: "+lBoundingBox.x+ ", y: "+lBoundingBox.y+" )");
        System.out.println("Size: (width: "+lBoundingBox.width+ ", height: "+lBoundingBox.height+" )");
        System.out.println("\n");

        // Navigate to "Tab Window & Checkboxes"
        page.navigate("https://www.luv2test.com/#/tabs-windows");

        //  Checking Elements states
        Locator lCheckbox1 = page.locator("#checkbox1");
        System.out.println("Visible: "+lCheckbox1.isVisible());
        System.out.println("Enabled: "+lCheckbox1.isEnabled());
        System.out.println("Checked: "+lCheckbox1.isChecked());

        Locator lCheckbox4 = page.locator("#checkbox4");
        System.out.println("Visible: "+lCheckbox4.isVisible());
        System.out.println("Enabled: "+lCheckbox4.isEnabled());
        System.out.println("Checked: "+lCheckbox4.isChecked());

        System.out.println("Editable: "+lCheckbox4.isEditable());
        System.out.println("Disabled: "+lCheckbox4.isDisabled());
        System.out.println("Hidden: "+lCheckbox4.isHidden());
    }
}
