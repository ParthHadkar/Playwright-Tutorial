package org.luv2code.o4_actions;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.luv2code.framework.base.BaseTest;

import java.text.MessageFormat;
import java.util.List;

public class TableHandlingTest extends BaseTest {

    @Test
    void tableHandlingTest() {

        // navigate to Dynamic Tables page
        page.navigate("https://www.luv2test.com/#/tables");

        // find an email in dynamic table
        Locator email1 = page.locator("//td[text()='jeeva@example.com']");
        highlightElement(email1);
        waitInSeconds(1);

        // find all emails and print them
        for (int i = 1; i <=10; i++) {
            String lEmailsLocator = MessageFormat.format("//td[1][text()=''{0}'']/../td[3]", i);
            Locator lEmailAddress = page.locator(lEmailsLocator);
            System.out.println("Emails Address: "+lEmailAddress.textContent());
        }
        // locate the table and get all rows/columns from table
        Locator lTable = page.locator("#dynamic-table");
        List<ElementHandle> lRows = lTable.locator("tbody tr").elementHandles();
        List<ElementHandle> lColumns = lTable.locator("thead tr th").elementHandles();

        System.out.println("Total Rows: "+lRows.size());
        System.out.println("Total Columns: "+lColumns.size());

        // print all table data
        for (int i = 1; i < lRows.size(); i++) {
            for (int j = 1; j < lColumns.size(); j++) {
                String lCellPath = "//tbody/tr["+i+"]/td["+j+"]";
                Locator lLocator = lTable.locator(lCellPath);
                System.out.print(lLocator.textContent()+ " | ");
            }
            System.out.println();
        }

        System.out.println("Success");
    }

}
