package org.luv2code.o9_junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class ParameterizedExampleTest {


    // 1. Using @ValueSource (single parameter)
    @ParameterizedTest
    @ValueSource(strings = {"admin1", "user2", "admin3"})
    void loginWithValueSource(String pUserName) {
        System.out.println("1. Logging in with user: "+pUserName);
    }

    // 2. Using @CsvSource (multiple parameters)
    @ParameterizedTest
    @CsvSource( {
            "user1, pass1",
            "user2, pass2",
            "user3, pass3",
    })
    void loginWithCsvSource(String pUserName, String pPassword) {
        System.out.println("2. Logging in with user: "+ pUserName + " and password: "+pPassword);
    }

    // 3. Using @CsvFileSource (data from csv file)
    // CSV file: src/test/resources/loginData.csv
    // Contents:
    // admin,admin123
    // user2,pass2
    // user3,pass3

    @ParameterizedTest
    @CsvFileSource(resources = "/loginData.csv", numLinesToSkip = 0)
    void loginWithCsvFileSource(String pUserName, String pPassword) {
        System.out.println("3. Logging in with user: "+ pUserName + " and password: "+pPassword);
    }

    static Stream<Arguments> loginDataProvider() {
        return Stream.of(
                Arguments.of("user1", "password123"),
                Arguments.of("user2", "password12"),
                Arguments.of("user3", "password1")
        );
    }

    // using @MethodSource (dynamic data provider)
    @ParameterizedTest
    @MethodSource("loginDataProvider")
    void loginWithMethodSource(String pUserName, String pPassword) {
        System.out.println("4. Logging in with user: "+ pUserName + " and password: "+pPassword);
    }

    // using @EnumSource (if you have enum for users)
    enum User {
            ADMIN, USER, USER2
    }
    @ParameterizedTest
    @EnumSource(User.class)
    void loginWithEnumSource(User pUser) {
        System.out.println("5. Logging in with user: "+ pUser);
    }

}
