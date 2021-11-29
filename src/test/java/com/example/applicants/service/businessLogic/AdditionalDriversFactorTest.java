package com.example.applicants.service.businessLogic;

// IMPORTS
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionalDriversFactorTest {

    // SET UP THE TEST VARIABLES
    String validAdditionalDriversLower, validAdditionalDriversUpper, invalidAdditionalDrivers;

    AdditionalDriversFactor additionalDriversFactor;


    @BeforeEach
    void setUp() throws NumberFormatException {
        validAdditionalDriversLower = "1";
        validAdditionalDriversUpper = "2";
        invalidAdditionalDrivers = "Invalid";

        // ADDITIONAL DRIVERS FACTOR OBJECT
        additionalDriversFactor = new AdditionalDriversFactor();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void additionalDriversFactorTestValidLower() {
        double expectedResult = 1.1;
        double actualResult = additionalDriversFactor.additionalDriversFactor(validAdditionalDriversLower);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void additionalDriversFactorTestValidUpper() {
        Double expectedResult = 1.2;
        double actualResult = additionalDriversFactor.additionalDriversFactor(validAdditionalDriversUpper);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void additionalDriversFactorTestInvalid() {
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {additionalDriversFactor.additionalDriversFactor(invalidAdditionalDrivers);});
    }
}