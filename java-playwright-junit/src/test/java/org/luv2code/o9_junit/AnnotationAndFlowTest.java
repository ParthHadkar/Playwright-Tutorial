package org.luv2code.o9_junit;

import org.junit.jupiter.api.*;

public class AnnotationAndFlowTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll - Initialize DB / Config");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll - Disconnect DB / Config");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("@BeforeEach - Login before test");
    }

    @AfterEach
    void afterEach() {
        System.out.println("@AfterEach - logout after test");
    }

    @Test
    @Tag("smoke") //to run test in group -- -Dgroups=smoke
    void testCase1() {
        System.out.println("@Test - execute testCase1 (smoke)");
    }
}
