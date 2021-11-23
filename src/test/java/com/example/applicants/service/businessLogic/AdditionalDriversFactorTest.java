package com.example.applicants.service.businessLogic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdditionalDriversFactorTest {

    // Set up test variables
    String validAdditionalDriversLower, validAdditionalDriversUpper, invalidAdditionalDrivers;

    AdditionalDriversFactor additionalDriversFactor;


    @BeforeEach
    void setUp() throws NumberFormatException {
        validAdditionalDriversLower = "1";
        validAdditionalDriversUpper = "2";
        invalidAdditionalDrivers = "Invalid";

        // additional drivers factor object
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