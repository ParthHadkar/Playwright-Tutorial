package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

public class DropDownHandlingTest extends BaseTest {

    @Test
    void dropDownHandlingTest() {

        // navigate to dropdown page
        page.navigate("https://www.luv2test.com/#/dropdowns");

        // normal dropdown
        Locator lNormalDropdown = page.locator("#normal-dropdown");
        lNormalDropdown.selectOption(new SelectOption().setLabel("Apple"));
        //lNormalLocator.selectOption(new SelectOption().setValue("apple"));
        //lNormalLocator.selectOption(new SelectOption().setIndex(1));

        // multi select dropdown
        Locator lMultiDropdown = page.locator("#multi-dropdown");
        // select by value
        //lMultiDropdown.selectOption(new String[] {"apple", "banana", "grapes"});
        // select by visible text
        lMultiDropdown.selectOption( new SelectOption[] {
                new SelectOption().setLabel("Apple"),
                new SelectOption().setLabel("Grapes"),
                new SelectOption().setLabel("Orange")
        });

        // searchable dropdown
        page.locator("#search-input").fill("Python");
        page.locator("#searchable-dropdown").selectOption(new SelectOption().setLabel("Python"));

        // add option + select
        page.locator("#add-option-input").fill("C++");
        page.locator("#add-option-button").click();
        page.locator("#addable-dropdown").selectOption(new SelectOption().setLabel("C++"));

        // hover dropdown
        Locator lHoverMenu = page.locator("//div[text()='Hover over this box to choose a language']");
        lHoverMenu.hover();

        page.locator("//li[text()='Go']").click();

        // hover away
        page.locator("body").hover(); // html

        System.out.println("Success");
    }
}
