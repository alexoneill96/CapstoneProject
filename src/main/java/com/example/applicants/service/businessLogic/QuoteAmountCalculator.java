package com.example.applicants.service.businessLogic;

import com.example.applicants.model.Applicant;
import org.springframework.stereotype.Service;

import static com.example.applicants.service.businessLogic.CommercialUseFactor.commercialUseFactor;
import static com.example.applicants.service.businessLogic.OutsideStateUseFactor.outsideStateUseFactor;
import static com.example.applicants.service.businessLogic.VehicleTypeFactor.typeFactor;
import static com.example.applicants.service.businessLogic.AdditionalDriversFactor.additionalDriversFactor;
import static com.example.applicants.service.businessLogic.EngineSizeFactor.sizeFactor;
import static com.example.applicants.service.businessLogic.VehicleValueFactor.valueFactor;

@Service
public class QuoteAmountCalculator {

    public void calculateQuote(Applicant applicant){

        double typeFactor = typeFactor(applicant.getVehicleType());
        double sizeFactor = sizeFactor(applicant.getEngineSize());
        double additionalDriversFactor = additionalDriversFactor((applicant.getAdditionalDrivers()));
        double commercialUseFactor = commercialUseFactor((applicant.getCommercialPurposes()));
        double outsideStateUseFactor = outsideStateUseFactor((applicant.getUsedOutsideState()));
        double valueFactor = valueFactor((applicant.getCurrentValue()));
        double quoteAmount = (100*typeFactor*sizeFactor*additionalDriversFactor*commercialUseFactor*outsideStateUseFactor*valueFactor);
        applicant.setQuoteAmount(quoteAmount);
    }
}
