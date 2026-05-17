package org.luv2code.o9_junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AllAssertionsTest {

    @Test
    void allAssertionsTest() {

        // 1. assertEquals - compare values
        String lExpected = "Luv2Test";
        String lActual = "Luv2Test";
        Assertions.assertEquals(lExpected, lActual);

        // 2. assertNotEquals - value must differ
        int a = 5, b = 10;
        Assertions.assertNotEquals(a, b);

        // 3. assertTrue - condition must be true
        Assertions.assertTrue(5 < 10, "Condition should be true!");

        // 4. assertFalse - condition must be false
        Assertions.assertFalse(5 > 10, "Condition should be false!");

        // 5. assertNull - object must be null
        String lStrNull = null;
        Assertions.assertNull(lStrNull, "Object should be null");

        // 6. assertNotNull - object must not be null
        String lStrNotNull = "Luv2Test";
        Assertions.assertNotNull(lStrNotNull, "Object should not be null");

        // 7. assertSame - must be same reference
        String lStr1 = "Luv2Code";
        String lStr2 = lStr1;
        Assertions.assertSame(lStr1, lStr2, "Object are not same reference");

        // 8. assertNotSame - must be different objects
        String lStr3 = new String("Luv2Code");
        String lStr4 = new String("Luv2Code");
        Assertions.assertNotSame(lStr3, lStr4);

        // 9. Soft assertions (JUnit 5) - using assertAll for multiple validations
        Assertions.assertAll("Soft assertions example",
                () -> Assertions.assertEquals("Title", "Title", "Title Mismatch"),
                () -> Assertions.assertTrue(5 < 10, "Condition Failed"),
                () -> Assertions.assertNotNull("Hello", "Object should not be null")
        );

        // 10. fail() - forcefully fail test
        //Assertions.fail("Forcefully failing this test!");

    }

}
