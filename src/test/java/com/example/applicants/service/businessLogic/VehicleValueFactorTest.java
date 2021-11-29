package com.example.applicants.service.businessLogic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleValueFactorTest {

    // SET UP TEST VARIABLES
    String validValueLower, validValueMiddle, validValueUpper, invalidValue;
    VehicleValueFactor vehicleValueFactor;


    @BeforeEach
    void setUp() throws NumberFormatException{
        // SET UP TEST DATA
        validValueLower = "4999";
        validValueMiddle = "5000";
        validValueUpper = "50000";
        invalidValue = "Invalid";
        // VEHICLE VALUE FACTOR OBJECT
        vehicleValueFactor = new VehicleValueFactor();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void vehicleValueFactorTestValidLower() {
        double expectedResult = 1.0;
        double actualResult = vehicleValueFactor.valueFactor(validValueLower);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void vehicleValueFactorTestValidMiddle() {
        double expectedResult = 1.0;
        double actualResult = vehicleValueFactor.valueFactor( validValueMiddle);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void vehicleValueFactorTestValidUpper() {
        double expectedResult = 1.2;
        double actualResult = vehicleValueFactor.valueFactor( validValueUpper);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void vehicleValueFactorTestInvalid() {
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {vehicleValueFactor.valueFactor(invalidValue);});
    }
}