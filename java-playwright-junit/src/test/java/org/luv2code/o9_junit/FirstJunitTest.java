package org.luv2code.o9_junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
@ExtendWith(LoggingExtension.class)
public class FirstJunitTest {

    @Test
    //@Order(1)
    @DisplayName("A")
    void openApplication() {
        System.out.println("Step 1: Launch Application");
    }

    @Test
    //@Order(2)
    @DisplayName("B")
    void loginTest() {
        System.out.println("Step 2: Peform Login");
    }

    @Test
    //@Order(3)
    @DisplayName("C")
    void logoutTest() {
        System.out.println("Step 3: Peform Logout");
        //Assertions.fail("fail this test");
    }

}
