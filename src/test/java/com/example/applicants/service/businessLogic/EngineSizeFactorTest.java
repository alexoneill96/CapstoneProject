package com.example.applicants.service.businessLogic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineSizeFactorTest {

    // Set up test variables
    String validEngineSize, invalidEngineSize;

    // Instantiation of method
    EngineSizeFactor engineSizeFactor;


    @BeforeEach
    void setUp() throws IllegalArgumentException {
        validEngineSize = "1000";
        invalidEngineSize = "Invalid";

        // engineSizeFactor object
        engineSizeFactor = new EngineSizeFactor();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sizeFactorValid() {
        double expectedResult = 1.0;

        double actualResult = engineSizeFactor.sizeFactor(validEngineSize);

        assertEquals(expectedResult, actualResult, 0.1);

    }

    @Test
    void sizeFactorInvalid() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {engineSizeFactor.sizeFactor(invalidEngineSize);});

    }
}