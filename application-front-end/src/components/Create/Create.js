import React, { useState, useEffect } from "react";
import { Button, Form, Divider, Segment, Image, Icon } from "semantic-ui-react";
import axios from "axios";
import * as ErrorMsgConstants from "./ErrorMessages.js";
import * as DropDownOptions from "./DropdownOptions";
import logo from "./allstate-banner.png";
import "./Create.css";
import { toast } from "react-toastify";
import {Link} from "react-router-dom";
import SERVER_ADDRESS from "../../server/server";

// FUNCTION FOR RELOADING PAGE ON FORM COMPLETION
function Create() {
  const refreshPage = () => {
    window.location.reload();
  };

  // GET CURRENT DATE
  let newDate = new Date();
  let date = newDate.getDate().toLocaleString("en-US",{minimumIntegerDigits: 2, useGrouping: false})
  let month = newDate.getMonth()+1;
  let year = newDate.getFullYear();
  let dateFormatted = `${year}-${month}-${date}`;



  // INITIALISING FORM FIELD STATES
  const [prefix, setPrefix] = useState();
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [telephoneNumber, setTelephoneNumber] = useState("");
  const [addressLine1, setAddressLine1] = useState("");
  const [addressLine2, setAddressLine2] = useState("");
  const [city, setCity] = useState("");
  const [zipCode, setZipCode] = useState("");
  const [vehicleType, setVehicleType] = useState("");
  const [engineSize, setEngineSize] = useState("");
  const [additionalDrivers, setAdditionalDrivers] = useState("");
  const [commercialPurposes, setCommercialPurposes] = useState("No");
  const [usedOutsideState, setUsedOutsideState] = useState("No");
  const [currentValue, setCurrentValue] = useState("");
  const [dateRegistered, setDateRegistered] = useState("");

  // FIELD ERROR STATUS
  const [fieldErrors, setFieldErrors] = useState({
    prefix: false,
    firstName: false,
    lastName: false,
    telephoneNumber: {
      missing: false,
      invalid: false,
    },
    addressLine1: false,
    city: false,
    zipCode: false,
    vehicleType: false,
    engineSize: false,
    additionalDrivers: false,
    commercialPurposes: false,
    usedOutsideState: false,
    currentValue: {
      missing: false,
      invalid: false,
    },
    dateRegistered: false,
  });

  // CALL MOCKAPI FUNCTION
  const callMockAPI = () => {
    const formData = {
      prefix,
      firstName,
      lastName,
      telephoneNumber,
      addressLine1,
      addressLine2,
      city,
      zipCode,
      vehicleType,
      engineSize,
      additionalDrivers,
      commercialPurposes,
      usedOutsideState,
      currentValue,
      dateRegistered,
    };
    const endpointURL = `${SERVER_ADDRESS}applicants`;
    axios
      .post(endpointURL, formData)
      .then((response) => console.log(response.data))
      .catch((err) => console.log(err));

  };


  // HANDLE SUBMIT FUNCTION
  const handleSubmit = (event) => {
    event.preventDefault();

    // INITIALISE VALID
    let formValidFlag = true;

    //CHECK FIRST FORM FIELD
    formValidFlag = validatePrefix(prefix);
    // IF VALID, MOVE ON...
    if (formValidFlag) {
      formValidFlag = validateFirstName(firstName);
    }
    if (formValidFlag) {
      formValidFlag = validateLastName(lastName);
    }
    if (formValidFlag) {
      formValidFlag = validateTelephoneNumber(telephoneNumber);
    }
    if (formValidFlag) {
      formValidFlag = validateAddressLine1(addressLine1);
    }
    if (formValidFlag) {
      formValidFlag = validateCity(city);
    }
    if (formValidFlag) {
      formValidFlag = validateZipCode(zipCode);
    }
    if (formValidFlag) {
      formValidFlag = validateVehicleType(vehicleType);
    }
    if (formValidFlag) {
      formValidFlag = validateEngineSize(engineSize);
    }
    if (formValidFlag) {
      formValidFlag = validateAdditionalDrivers(additionalDrivers);
    }
    if (formValidFlag) {
      formValidFlag = validateCurrentValue(currentValue);
    }
    if (formValidFlag) {
      formValidFlag = validateDateRegistered(dateRegistered);
    }

    // IF ALL VALID, CALL POST TO DATABASE
    if (formValidFlag) {
      callMockAPI();
      toast.success("New Driver Record Created!");
      setTimeout(() => {
        refreshPage();
      }, 10000);
    } else {
      toast.error("Oops, something went wrong! Please Try Again!");
    }
  };

  // VALIDATION RULES - VALIDATE PREFIX
  const validatePrefix = (prefix) => {
    if (prefix === "" || prefix === null || prefix === undefined) {
      fieldErrors.prefix = true;
      setFieldErrors({ ...fieldErrors });
      return false;
    }

    fieldErrors.prefix = false;
    setFieldErrors({ ...fieldErrors });
    return true;
  };

  // VALIDATION RULES - VALIDATE FIRSTNAME
  const validateFirstName = (firstName) => {
    if (firstName === "" || firstName === null || firstName === undefined) {
      fieldErrors.firstName = true;
      setFieldErrors({ ...fieldErrors });
      return false;
    }

    fieldErrors.firstName = false;
    setFieldErrors({ ...fieldErrors });
    return true;
  };

  // VALIDATION RULES - VALIDATE SURNAME
  const validateLastName = (lastName) => {
    if (lastName === "" || lastName === null || lastName === undefined) {
      fieldErrors.lastName = true;
      setFieldErrors({ ...fieldErrors });
      return false;
    }

    fieldErrors.lastName = false;
    setFieldErrors({ ...fieldErrors });
    return true;
  };

  // VALIDATION RULES - VALIDATE TELEPHONE NUMBER
  const validateTelephoneNumber = (telephoneNumber) => {
    if (
      telephoneNumber === "" ||
      telephoneNumber === null ||
      telephoneNumber === undefined
    ) {
      fieldErrors.telephoneNumber.missing = true;
      setFieldErrors({ ...fieldErrors });
      return false;
    }

    if (telephoneNumber.length < 10) {
      fieldErrors.telephoneNumber.missing = false;
      fieldErrors.telephoneNumber.invalid = true;
      setFieldErrors({ ...fieldErrors });
      return false;
    }

    fieldErrors.telephoneNumber.missing = false;
    fieldErrors.telephoneNumber.invalid = false;
    setFieldErrors({ ...fieldErrors });
    return true;
  };

  // VALIDATION RULES - VALIDATE ADDRESS LINE 1
  const validateAddressLine1 = (addressLine1) => {
    if (
      addressLine1 === "" ||
      addressLine1 === null ||
      addressLine1 === undefined
    ) {
      fieldErrors.addressLine1 = true;
      setFieldErrors({ ...fieldErrors });
      return false;
    }

    fieldErrors.addressLine1 = false;
    setFieldErrors({ ...fieldErrors });
    return true;
  };

  // VALIDATION RULES - VALIDATE CITY
  const validateCity = (city) => {
    if (city === "" || city === null || city === undefined) {
      fieldErrors.city = true;
      setFieldErrors({ ...fieldErrors });
      return false;
    }

    fieldErrors.city = false;
    setFieldErrors({ ...fieldErrors });
    return true;
  };

  // VALIDATION RULES - VALIDATE ZIPCODE
  const validateZipCode = (zipCode) => {
    if (zipCode === "" || zipCode === null || zipCode === undefined) {
      fieldErrors.zipCode = true;
      setFieldErrors({ ...fieldErrors });
      return false;
    }

    fieldErrors.zipCode = false;
    setFieldErrors({ ...fieldErrors });
    return true;
  };

  // VALIDATION RULES - VALIDATE VEHICLE TYPE
  const validateVehicleType = (vehicleType) => {
    if (
      vehicleType === "" ||
      vehicleType === null ||
      vehicleType === undefined
    ) {
      fieldErrors.vehicleType = true;
      setFieldErrors({ ...fieldErrors });
      return false;
    }

    fieldErrors.vehicleType = false;
    setFieldErrors({ ...fieldErrors });
    return true;
  };

  // VALIDATION RULES - VALIDATE ENGINE SIZE
  const validateEngineSize = (engineSize) => {
    if (engineSize === "" || engineSize === null || engineSize === undefined) {
      fieldErrors.engineSize = true;
      setFieldErrors({ ...fieldErrors });
      return false;
    }

    fieldErrors.engineSize = false;
    setFieldErrors({ ...fieldErrors });
    return true;
  };

  // VALIDATION RULES - VALIDATE ADDITIONAL DRIVERS
  const validateAdditionalDrivers = (additionalDrivers) => {
    if (
      additionalDrivers === "" ||
      additionalDrivers === null ||
      additionalDrivers === undefined
    ) {
      fieldErrors.additionalDrivers = true;
      setFieldErrors({ ...fieldErrors });
      return false;
    }

    fieldErrors.additionalDrivers = false;
    setFieldErrors({ ...fieldErrors });
    return true;
  };

  // VALIDATION RULES - VALIDATE CURRENT VALUE
  const validateCurrentValue = (currentValue) => {
    if (
      currentValue === "" ||
      currentValue === null ||
      currentValue === undefined
    ) {
      fieldErrors.currentValue = true;
      setFieldErrors({ ...fieldErrors });
      return false;
    }

    if(
        currentValue > 50000
    ){
      fieldErrors.currentValue.missing = false;
      fieldErrors.currentValue.invalid = true;
      setFieldErrors({...fieldErrors});
      return false;
    }

    fieldErrors.currentValue.missing = false;
    fieldErrors.currentValue.invalid = false;
    setFieldErrors({ ...fieldErrors });
    return true;
  };

  // VALIDATION RULES - VALIDATE DATE REGISTERED
  const validateDateRegistered = (dateRegistered) => {
    if (
      dateRegistered === "" ||
      dateRegistered === null ||
      dateRegistered === undefined
    ) {
      fieldErrors.dateRegistered = true;
      setFieldErrors({ ...fieldErrors });
      return false;
    }

    fieldErrors.dateRegistered = false;
    setFieldErrors({ ...fieldErrors });
    return true;
  };

  // RADIO HANDLES - COMMERCIAL PURPOSES
  const handleCommercialPurposesChange = (value) => {
    if (value) {
      setCommercialPurposes("Yes");
    } else {
      setCommercialPurposes("No");
    }
  };

  // RADIO HANDLES - OUTSIDE REGISTERED STATE
  const handleOutsideRegisteredStateChange = (value) => {
    if (value) {
      setUsedOutsideState("Yes");
    } else {
      setUsedOutsideState("No");
    }
  };

  // HTML
  return (
    <div>
      <Form className="main-form">
        <Segment>
          <Link to={'/Admin'}>
          <Button color='blue' size={'large'}animated>
            <Button.Content visible>Go To Admin Panel</Button.Content>
            <Button.Content hidden>
              <Icon name='settings' />
            </Button.Content>
          </Button>
          </Link>
        </Segment>
        <Segment color="blue" className="first-box">
          <Image src={logo} />
          <Divider horizontal>
            <b>Your Details</b>
          </Divider>
          <Form.Group widths="equal">
            <Form.Field>
              <label>Prefix</label>
              <Form.Select
                placeholder="Please Select"
                options={DropDownOptions.prefixOptions}
                onChange={(e, { value }) => setPrefix(value)}
                value={prefix}
                error={
                  fieldErrors.prefix ? ErrorMsgConstants.PREFIX_REQUIRED : false
                }
              />
            </Form.Field>
            <Form.Field>
              <label>First Name</label>
              <Form.Input
                placeholder="First Name"
                onChange={(e) => setFirstName(e.target.value)}
                error={
                  fieldErrors.firstName
                    ? ErrorMsgConstants.FIRST_NAME_REQUIRED
                    : false
                }
              />
            </Form.Field>
          </Form.Group>
          <Form.Group widths="equal">
            <Form.Field>
              <label>Last Name</label>
              <Form.Input
                placeholder="Last Name"
                onChange={(e) => setLastName(e.target.value)}
                error={
                  fieldErrors.lastName
                    ? ErrorMsgConstants.LAST_NAME_REQUIRED
                    : false
                }
              />
            </Form.Field>
            <Form.Field>
              <label>Telephone Number</label>
              <Form.Input
                placeholder="Telephone Number"
                onChange={(e) => setTelephoneNumber(e.target.value)}
                error={
                  fieldErrors.telephoneNumber.missing
                    ? ErrorMsgConstants.TELEPHONE_NUMBER_REQUIRED
                    : fieldErrors.telephoneNumber.invalid
                    ? ErrorMsgConstants.TELEPHONE_NUMBER_INVALID
                    : false
                }
              />
            </Form.Field>
          </Form.Group>
          <Form.Group widths="equal">
            <Form.Field>
              <label>Address Line 1</label>
              <Form.Input
                placeholder="Address Line 1"
                onChange={(e) => setAddressLine1(e.target.value)}
                error={
                  fieldErrors.addressLine1
                    ? ErrorMsgConstants.ADDRESS_LINE_1_REQUIRED
                    : false
                }
              />
            </Form.Field>
            <Form.Field>
              <label>Address Line 2</label>
              <input
                placeholder="Address Line 2"
                onChange={(e) => setAddressLine2(e.target.value)}
              />
            </Form.Field>
          </Form.Group>
          <Form.Group widths="equal">
            <Form.Field>
              <label>City</label>
              <Form.Input
                placeholder="City"
                onChange={(e) => setCity(e.target.value)}
                error={
                  fieldErrors.city ? ErrorMsgConstants.CITY_REQUIRED : false
                }
              />
            </Form.Field>
            <Form.Field>
              <label>ZIP Code</label>
              <Form.Input
                placeholder="ZIP Code"
                onChange={(e) => setZipCode(e.target.value)}
                error={
                  fieldErrors.zipCode
                    ? ErrorMsgConstants.ZIPCODE_REQUIRED
                    : false
                }
              />
            </Form.Field>
          </Form.Group>
        </Segment>
        <Segment color="blue">
          <Divider horizontal>
            <b>Vehicle Details</b>
          </Divider>
          <Form.Group widths="equal">
            <Form.Field>
              <label>Vehicle type</label>
              <Form.Select
                placeholder="Please Select"
                options={DropDownOptions.vehTypeOptions}
                onChange={(e, { value }) => setVehicleType(value)}
                value={vehicleType}
                error={
                  fieldErrors.vehicleType
                    ? ErrorMsgConstants.VEHICLE_TYPE_REQUIRED
                    : false
                }
              />
            </Form.Field>
            <Form.Field>
              <label>Engine size</label>
              <Form.Select
                placeholder="Please Select"
                options={DropDownOptions.engSizeOptions}
                onChange={(e, { value }) => setEngineSize(value)}
                value={engineSize}
                error={
                  fieldErrors.engineSize
                    ? ErrorMsgConstants.ENGINE_SIZE_REQUIRED
                    : false
                }
              />
            </Form.Field>

            <Form.Field>
              <label>Additional Drivers</label>
              <Form.Input
                type="number"
                min="0"
                placeholder="How Many Additional Drivers"
                onChange={(e) => setAdditionalDrivers(e.target.value)}
                error={
                  fieldErrors.additionalDrivers
                    ? ErrorMsgConstants.ADDITIONAL_DRIVERS_REQUIRED
                    : false
                }
              />
            </Form.Field>
          </Form.Group>
          <Form.Field>
            <label>Will this vehicle be used for commercial purposes?</label>
          </Form.Field>
          <Form.Field>
            <Form.Checkbox
              toggle
              label={commercialPurposes}
              onChange={(e, data) =>
                handleCommercialPurposesChange(data.checked)
              }
            />
          </Form.Field>
          <Form.Field>
            <label>
              Will this vehicle be used outside the registered state?
            </label>
          </Form.Field>
          <Form.Field>
            <Form.Checkbox
              toggle
              label={usedOutsideState}
              onChange={(e, data) =>
                handleOutsideRegisteredStateChange(data.checked)
              }
            />
          </Form.Field>
          <Form.Group widths="equal">
            <Form.Field>
              <label>What is the current value of vehicle?</label>
              <Form.Input
                type="number"
                min="0"
                max="50000"
                placeholder="Current value"
                onChange={(e) => setCurrentValue(e.target.value)}
                error={
                  fieldErrors.currentValue.missing
                    ? ErrorMsgConstants.CURRENT_VALUE_REQUIRED
                      : fieldErrors.currentValue.invalid ? ErrorMsgConstants.CURRENT_VALUE_INVALID
                    : false
                }

              />
            </Form.Field>
            <Form.Field>
              <label>Date of first registration:</label>
              <Form.Input
                type="date"
                max={dateFormatted}
                min="1980-11-10"
                onChange={(e) => setDateRegistered(e.target.value)}
                error={
                  fieldErrors.dateRegistered
                    ? ErrorMsgConstants.DATE_REGISTERED_REQUIRED
                    : false
                }
              />
            </Form.Field>
          </Form.Group>
        </Segment>
        <Segment>
          <Button fluid size='huge' animated='vertical' color={'blue'} type="submit" onClick={handleSubmit}>
            <Button.Content hidden>Get Your Quote</Button.Content>
            <Button.Content visible>
              <Icon name='shop' />
            </Button.Content>
          </Button>
        </Segment>
      </Form>
    </div>
  );
}

export default Create;
