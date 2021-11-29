package com.example.applicants.service.businessLogic;

public class CommercialUseFactor {
    public static double commercialUseFactor(String commercialUse){
        double commercialUseFactor = 0.0;
        if(commercialUse.equalsIgnoreCase("Yes")){
            return commercialUseFactor = 1.1;
        } else if (commercialUse.equalsIgnoreCase("No")){
            return commercialUseFactor = 1.0;
        } else {
            throw new IllegalArgumentException("Invalid Entry");
        }
    }
}
