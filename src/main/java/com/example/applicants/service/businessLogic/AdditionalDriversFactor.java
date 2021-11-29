package com.example.applicants.service.businessLogic;

public class AdditionalDriversFactor {
    public static double additionalDriversFactor(String additionalDrivers){
        double additionalDriversFactor = 0.0;
        int additionalDriversInt = Integer.parseInt(additionalDrivers);
        try{
            if(additionalDriversInt >=0 && additionalDriversInt < 2){
                return additionalDriversFactor = 1.1;
            } else {
                return additionalDriversFactor = 1.2;
            }
        } catch (NumberFormatException e){
            throw new NumberFormatException("String cannot be converted to Int!");
        }
    }
}
