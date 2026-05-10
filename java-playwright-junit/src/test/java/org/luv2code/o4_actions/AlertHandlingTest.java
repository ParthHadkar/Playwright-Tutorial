package org.luv2code.o4_actions;

import com.microsoft.playwright.Dialog;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

import java.util.function.Consumer;

public class AlertHandlingTest extends BaseTest {

    @Test
    void alertHandlingTest() {

        // navigate to alert page
        page.navigate("https://www.luv2test.com/#/alerts");

        // check presence of "Alerts" heading
        highlightElement(page.locator("//h1[text()='JavaScript Alerts']"));

        // simple alert dialog
        Consumer<Dialog> alertHandler = dialog -> {
            System.out.println("simple alert text: "+dialog.message());
            //the single-listener approach
            /*System.out.println("Dialog Type: " + dialog.type());
            System.out.println("Dialog Text: " + dialog.message());

            if (dialog.type().equals("confirm")) {
                dialog.dismiss();
            } else {
                dialog.accept();
            }*/
            dialog.accept();
        };

        page.onDialog(alertHandler);
        page.locator("//button[@data-test='alert-button']").click(); // alert are handle atomatically by playwright
        page.offDialog(alertHandler);

        // confirmation alert dialog
        Consumer<Dialog> confirmationAlertHandler = dialog -> {
            System.out.println("Confirmation alert text: "+dialog.message());
            dialog.dismiss();
        };
        page.onDialog(confirmationAlertHandler);
        page.locator("//button[@data-test='confirm-button']").click();
        page.offDialog(confirmationAlertHandler);

        // Prompt alert dialog
        page.onDialog(dialog -> {
            System.out.println("Prompt alert text: "+dialog.message());
            dialog.accept("Hello from Playwright!");
        });
        page.locator("//button[@data-test='prompt-button']").click();

        System.out.println("Success");
    }
}
