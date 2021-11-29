package com.example.applicants.service.businessLogic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTypeFactorTest {

    // SET UP TEST VARIABLES
    String validVehicleType, invalidVehicleType;

    // INSTANTIATION OF METHOD
    VehicleTypeFactor vehicleTypeFactor;


    @BeforeEach
    void setUp() throws IllegalArgumentException {
        validVehicleType = "Hatchback";
        invalidVehicleType = "Invalid";
        // engineSizeFactor OBJECT
        vehicleTypeFactor = new VehicleTypeFactor();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void typeFactorValid() {
        double expectedResult = 1.6;
        double actualResult = vehicleTypeFactor.typeFactor(validVehicleType);
        assertEquals(expectedResult, actualResult, 0.1);
    }

    @Test
    void sizeFactorInvalid() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {vehicleTypeFactor.typeFactor(invalidVehicleType);});
    }
}