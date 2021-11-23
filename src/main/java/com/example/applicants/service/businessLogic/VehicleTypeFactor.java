package com.example.applicants.service.businessLogic;

public class VehicleTypeFactor {
    public static double typeFactor(String vehicleType){
        double vehicleTypeFactor = 0.0;

        if(vehicleType.equalsIgnoreCase("cabriolet")){
            return vehicleTypeFactor = 1.3;
        } else if(vehicleType.equalsIgnoreCase("coupe")){
            return  vehicleTypeFactor = 1.4;
        }else if(vehicleType.equalsIgnoreCase("estate")){
            return  vehicleTypeFactor = 1.5;
        }else if(vehicleType.equalsIgnoreCase("hatchback")){
            return  vehicleTypeFactor = 1.6;
        }else if(vehicleType.equalsIgnoreCase("other")){
            return  vehicleTypeFactor = 1.7;
        }else {
            throw new IllegalArgumentException("Invalid Vehicle Type Exception");
        }


    }
}
