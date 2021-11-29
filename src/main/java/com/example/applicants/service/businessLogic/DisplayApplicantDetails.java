package com.example.applicants.service.businessLogic;
import com.example.applicants.model.Applicant;
import java.util.List;

public class DisplayApplicantDetails {
    public static void displayApplicantDetails(List<Applicant> applicantList){
        System.out.printf("%-10.10s %-15.15s %-15.15s %-20.20s %-25.25s %-25.25s %-20.20s %-15.15s %-15.15s %-15.15s %-20.20s %-15.15s %-25.25s %-15.15s %-20.20s %-20.20s %n",
                "Prefix", "First Name", "Last Name", "Telephone Number", "Address Line 1", "Address Line 2",
                "City", "Postcode", "Vehicle Type", "Engine Size", "Additional Drivers", "Commercial Use",
                "Outside of State Use", "Current Value", "Date Registered", "Final Quote Amount");

        for(Applicant applicant : applicantList){

            String currentValueFormatted = applicant.formatCurrencyString(applicant.getCurrentValue());

            String finalQuoteAmountFormatted = applicant.formatCurrencyDouble(applicant.getQuoteAmount());

            System.out.printf("%-10.10s %-15.15s %-15.15s %-20.20s %-25.25s %-25.25s %-20.20s %-15.15s %-15.15s %-15.15s %-20d %-15.15s %-25.25s %-15.15s %-20.20s %-20.20s %n",
                    applicant.getPrefix(), applicant.getFirstName(), applicant.getLastName(), applicant.getTelephoneNumber(),
                    applicant.getAddressLine1(), applicant.getAddressLine2(), applicant.getCity(), applicant.getZipCode(),
                    applicant.getVehicleType(), applicant.getEngineSize(), applicant.getAdditionalDrivers(),
                    applicant.getCommercialPurposes(), applicant.getUsedOutsideState(), currentValueFormatted,
                    applicant.formatDateRegistered(), finalQuoteAmountFormatted);
        }
    }
}
