package com.example.applicants.service.businessLogic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutsideStateUseFactorTest {

    // Setup Variables
    String validYes, validNo, invalid;

    // Declaring the class object
    OutsideStateUseFactor outsideStateUseFactor;


    @BeforeEach
    void setUp() throws IllegalArgumentException{

        // setup test data
        validYes = "Yes";
        validNo = "No";
        invalid = "Invalid";

        outsideStateUseFactor = new OutsideStateUseFactor();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void outsideStateUseFactorValidYes() {
        double expectedResult = 1.1;
        double actualResult = outsideStateUseFactor.outsideStateUseFactor(validYes);

        assertEquals(expectedResult,actualResult, 0.1);

    }

    @Test
    void outsideStateUseFactorValidNo() {
        double expectedResult = 1.0;
        double actualResult = outsideStateUseFactor.outsideStateUseFactor(validNo);

        assertEquals(expectedResult,actualResult, 0.1);

    }


    @Test
    void outsideStateUseFactorInvalid() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {outsideStateUseFactor.outsideStateUseFactor(invalid);});
    }
}