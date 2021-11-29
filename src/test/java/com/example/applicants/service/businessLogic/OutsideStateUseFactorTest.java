package com.example.applicants.service.businessLogic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutsideStateUseFactorTest {

    // SETUP VARIABLES
    String validYes, validNo, invalid;

    // DECLARING THE CLASS OBJECT
    OutsideStateUseFactor outsideStateUseFactor;

    @BeforeEach
    void setUp() throws IllegalArgumentException{
        // SETUP TEST DATA
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