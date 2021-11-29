package com.example.applicants.service.businessLogic;

public class VehicleValueFactor {
    public static double valueFactor(String currentValue) {
        double vehicleValueFactor = 0.0;
        int currentValueInt = Integer.parseInt(currentValue);
        try {
            if (currentValueInt > 0 && currentValueInt <= 5000) {
                return vehicleValueFactor = 1.0;
            } else {
                return vehicleValueFactor = 1.2;
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("String cannot be converted to Int!");
        }
    }
}
