package com.example.applicants.model;

// IMPORTS
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

@NoArgsConstructor
@Entity (name = "DRIVER_DETAILS")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Applicant(Long id, String prefix, String firstName, String lastName, String telephoneNumber, String addressLine1, String addressLine2, String city, String zipCode, String vehicleType, String engineSize, String additionalDrivers, String commercialPurposes, String usedOutsideState, String dateRegistered, String currentValue, String comments, double quoteAmount) {
        this.id = id;
        this.prefix = prefix;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.zipCode = zipCode;
        this.vehicleType = vehicleType;
        this.engineSize = engineSize;
        this.additionalDrivers = additionalDrivers;
        this.commercialPurposes = commercialPurposes;
        this.usedOutsideState = usedOutsideState;
        this.dateRegistered = dateRegistered;
        this.currentValue = currentValue;
        this.comments = comments;
        this.quoteAmount = quoteAmount;
    }

    private String prefix;
    @Column
    private String firstName;
    private String lastName;
    private String telephoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String zipCode;
    private String vehicleType;
    private String engineSize;
    private String additionalDrivers;
    private String commercialPurposes;
    private String usedOutsideState;
    private String dateRegistered;
    private String currentValue;
    private String comments;
    private double quoteAmount;

    // GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(String engineSize) {
        this.engineSize = engineSize;
    }

    public String getAdditionalDrivers() {
        return additionalDrivers;
    }

    public void setAdditionalDrivers(String additionalDrivers) {
        this.additionalDrivers = additionalDrivers;
    }

    public String getCommercialPurposes() {
        return commercialPurposes;
    }

    public void setCommercialPurposes(String commercialPurposes) {
        this.commercialPurposes = commercialPurposes;
    }

    public String getUsedOutsideState() {
        return usedOutsideState;
    }

    public void setUsedOutsideState(String usedOutsideState) {
        this.usedOutsideState = usedOutsideState;
    }

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public String getCurrentValue() {
        return currentValue;
    }

    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public double getQuoteAmount() {
        return quoteAmount;
    }

    public void setQuoteAmount(double quoteAmount) {
        this.quoteAmount = quoteAmount;
    }

    // FORMAT CURRENCY FUNCTION
    public String formatCurrencyDouble(Double value){
        Locale locale = new Locale("en", "US");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return formatter.format(value);
    }

    // FORMAT CURRENCY FUNCTION (For String Values)
    public String formatCurrencyString(String value){
        double valueDouble = Double.parseDouble(value);
        Locale locale = new Locale("en", "US");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        return formatter.format(valueDouble);
    }

    // FORMAT DATE FUNCTION
    public String formatDateRegistered(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(dateRegistered);
    }
}

