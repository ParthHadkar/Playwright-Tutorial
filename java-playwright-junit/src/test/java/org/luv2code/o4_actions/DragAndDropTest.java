package org.luv2code.o4_actions;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.luv2code.framework.base.BaseTest;
import org.luv2code.framework.extensions.LoggingExtension;

@ExtendWith({LoggingExtension.class})
public class DragAndDropTest extends BaseTest {

    @Test
    void dragAndDropTest() {

        // navigate to "drag and drop" page
        page.navigate("https://www.luv2test.com/#/drag-drop");

        // locate source and target elements
        Locator lApple = page.locator("#sortable-item-Apple");
        Locator lDropArea = page.locator("#dropped-area");

        // drag and drop built-in in playwright
        lApple.dragTo(lDropArea);
        waitInSeconds(1);

        Locator lPineapple = page.locator("#sortable-item-Pineapple");
        lPineapple.dragTo(lDropArea);
        waitInSeconds(1);

        Locator lBanana = page.locator("#sortable-item-Banana");
        lBanana.dragTo(lDropArea);

        waitInSeconds(2);

        // advanced actions: clickAndHold -> moveByOffset -> release

        Locator lOrange = page.locator("#sortable-item-Orange");
        lOrange.hover();

        page.mouse().move(
                lOrange.boundingBox().x + lOrange.boundingBox().width / 2,
                lOrange.boundingBox().y + lOrange.boundingBox().height / 2
        );

        page.mouse().down();
        waitInSeconds(2);

        page.mouse().move(
                lOrange.boundingBox().x + 200,
                lOrange.boundingBox().y + 300
        );
        waitInSeconds(2);

        //release
        page.mouse().up();
        waitInSeconds(3);

    }

}
