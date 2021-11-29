package com.example.applicants.service.businessLogic;

import com.example.applicants.model.Applicant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestQuoteAmount {

    // SETUP THE TEST VARIABLES
    String vehicleType, engineSize, additionalDrivers, commercialUse, outsideState, vehicleValue;

    // INSTANTIATION OF METHODS
    QuoteAmountCalculator quoteAmountCalculator;
    Applicant applicant;
    Applicant applicant2;

    @BeforeEach
    void setUp() {

        // SETUP TEST DATA
        applicant = new Applicant(3L, "prefix", "firstName", "lastName", "telephone", "address1", "address2",
                "city", "postcode","Hatchback", "1600", "3", "Yes", "Yes", "date",
                "500", "N/A", 0.0 );

        applicant2 = new Applicant(3L, "prefix", "firstName", "lastName", "telephone", "address1", "address2",
                "city", "postcode","Cabriolet", "3000", "1", "No", "No", "date",
                "15000", "N/A", 0.0 );

        // businessLogic OBJECT
       quoteAmountCalculator = new QuoteAmountCalculator();
    }

    @Test
    void calculateQuote1() {
        double expectedResult = 371.71;
        quoteAmountCalculator.calculateQuote(applicant);
        assertEquals(expectedResult, applicant.getQuoteAmount(), 0.2);
    }

    @Test
    void calculateQuote2() {
        double expectedResult = 514.80;
        quoteAmountCalculator.calculateQuote(applicant2);
        assertEquals(expectedResult, applicant2.getQuoteAmount(), 0.2);
    }
}