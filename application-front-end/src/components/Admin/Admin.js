import React, { useState } from "react";
import "./Admin.css";
import {Divider, Segment, Image, Icon} from "semantic-ui-react";
import { Table, Button, Form } from "semantic-ui-react";
import axios from "axios";
import logo from "./allstate-banner.png";
import { toast } from "react-toastify";
import {Link} from "react-router-dom";

function Admin() {
  const [idToGet, setIdToGet] = useState(null);
  const [idToDelete, setIdToDelete] = useState(null);
  const [idToUpdate, setIdToUpdate] = useState(null);
  const [telephoneNumber, setTelephoneNumber] = useState(null);
  const [customerData, setCustomerData] = useState([]);

  // CALL API GET
  function callMockAPIWithAxiosGET() {
    const endpointURL = `http://capstone-project-capstone-project.allstatejenkins11.conygre.com/applicants/id?id=${idToGet}`;
    axios
      .get(endpointURL)
      .then((response) => {
        if ((response.status >= 200) & (response.status < 300)) {
          setCustomerData(response.data);
        }
      })
      .catch((err) => {
        console.log(err);
        if (err.response.status === 404) {
          toast.error(
            `Sorry, Driver Record does not exist for Driver ID ${idToGet}`
          );
        } else {
          toast.error("Oops, something went wrong!");
        }
      });
  }

  // CALL API DELETE
  function callMockAPIWithAxiosDELETE() {
    const endpointURL = `http://capstone-project-capstone-project.allstatejenkins11.conygre.com/applicants?id=${idToDelete}`;
    axios
      .delete(endpointURL)
      .then((response) => {
        if ((response.status >= 200) & (response.status < 300)) {
          toast.success(`Driver ID: ${idToDelete} - Driver Record Deleted!`);
        }
      })
      .catch((err) => {
        console.log(err);
        if (err.response.status === 500) {
          toast.error(
            `Sorry, Driver Record does not exist for Driver ID ${idToDelete}`
          );
        } else {
          toast.error("Oops, something went wrong!");
        }
      });
  }

  // CALL API UPDATE
  function callMockAPIWithAxiosPUT() {
    const formData = {
      telephoneNumber,
    };
    const endpointURL =
      "http://capstone-project-capstone-project.allstatejenkins11.conygre.com/applicants/?id=" +
      idToUpdate +
      "&telephoneNumber=" +
      telephoneNumber;
    axios
      .put(endpointURL, formData)
      .then((response) => {
        if ((response.status >= 200) & (response.status < 300)) {
          toast.success(
            `Driver ID ${idToUpdate}'s telephone number updated to ${telephoneNumber}`
          );
        }
      })
      .catch((err) => {
        console.log(err);
        if (err.response.status === 500) {
          toast.error(
            `Sorry, Driver Record does not exist for Driver ID ${idToUpdate}`
          );
        } else {
          toast.error(
            "Oops, something went wrong! Check you have entered the correct Driver ID."
          );
        }
      });
  }

  // POPULATES A TABLE WITH CUSTOMER DATA
  const renderDataTable = () => {
    if (customerData.id > 0) {
      let quote2dp = customerData.quoteAmount.toFixed(2);
      return (
        <>
          <Table celled color={'grey'}>
            <Table.Header>
              <Table.Row>
                <Table.HeaderCell>ID</Table.HeaderCell>
                <Table.HeaderCell>Prefix</Table.HeaderCell>
                <Table.HeaderCell>First Name</Table.HeaderCell>
                <Table.HeaderCell>Last Name</Table.HeaderCell>
                <Table.HeaderCell>Telephone Number</Table.HeaderCell>
                <Table.HeaderCell>Address Line 1</Table.HeaderCell>
                <Table.HeaderCell>Address Line 2</Table.HeaderCell>
                <Table.HeaderCell>City</Table.HeaderCell>
                <Table.HeaderCell>Postcode</Table.HeaderCell>
              </Table.Row>
            </Table.Header>
            <Table.Body>
              <Table.Row>
                <Table.Cell>{customerData.id}</Table.Cell>
                <Table.Cell>{customerData.prefix}</Table.Cell>
                <Table.Cell>{customerData.firstName}</Table.Cell>
                <Table.Cell>{customerData.lastName}</Table.Cell>
                <Table.Cell>{customerData.telephoneNumber}</Table.Cell>
                <Table.Cell>{customerData.addressLine1}</Table.Cell>
                <Table.Cell>{customerData.addressLine2}</Table.Cell>
                <Table.Cell>{customerData.city}</Table.Cell>
                <Table.Cell>{customerData.zipCode}</Table.Cell>
              </Table.Row>
            </Table.Body>
          </Table>
          <Table celled color={'grey'}>
            <Table.Header>
              <Table.Row>
                <Table.HeaderCell>Vehicle Type</Table.HeaderCell>
                <Table.HeaderCell>Engine Size</Table.HeaderCell>
                <Table.HeaderCell>Additional Drivers</Table.HeaderCell>
                <Table.HeaderCell>Commercial Use</Table.HeaderCell>
                <Table.HeaderCell>Register State Use Only</Table.HeaderCell>
                <Table.HeaderCell>Vehicle Value</Table.HeaderCell>
                <Table.HeaderCell>Date Registered</Table.HeaderCell>
              </Table.Row>
            </Table.Header>
            <Table.Body>
              <Table.Row>
                <Table.Cell>{customerData.vehicleType}</Table.Cell>
                <Table.Cell>{customerData.engineSize}</Table.Cell>
                <Table.Cell>{customerData.additionalDrivers}</Table.Cell>
                <Table.Cell>{customerData.commercialPurposes}</Table.Cell>
                <Table.Cell>{customerData.usedOutsideState}</Table.Cell>
                <Table.Cell>${customerData.currentValue}</Table.Cell>
                <Table.Cell>{customerData.dateRegistered}</Table.Cell>
              </Table.Row>
            </Table.Body>
          </Table>
          <Table celled color={'blue'} >
            <Table.Header>
              <Table.Row >
                <Table.HeaderCell>Quote Amount</Table.HeaderCell>
              </Table.Row>
            </Table.Header>
            <Table.Body>
              <Table.Row positive>
                <Table.Cell>${quote2dp}</Table.Cell>
              </Table.Row>
            </Table.Body>
          </Table>
        </>
      );
    }
  };

  // HTML
  return (
    <div>
      <Form className="main-form">
        <Segment color="grey" className="first-box">
          <Image src={logo} />
        </Segment>
        <Segment className="first-box">
          <h1 className="heading">Admin Panel</h1>
        </Segment>
        <Segment color="grey" className="first-box">
          <Divider horizontal>
            <b>View Driver Details</b>
          </Divider>
          <Form.Group width="equal">
            <Form.Field inline>
              <label>View Driver Details</label>
              <input
                placeholder="Enter driver's Id"
                onChange={(e) => setIdToGet(e.target.value)}
              />
            </Form.Field>
            <Button animated='vertical' color={'green'} type="submit" onClick={callMockAPIWithAxiosGET}>
              <Button.Content visible>Get Driver</Button.Content>
              <Button.Content hidden>
                <Icon name='address card' />
              </Button.Content>
            </Button>
          </Form.Group>
          {renderDataTable()}
        </Segment>
        <Segment color="grey">
          <Divider horizontal>
            <b>Delete Driver</b>
          </Divider>
          <Form.Group width="equal">
            <Form.Field inline>
              <label>Delete a Driver</label>
              <input
                placeholder="Enter driver's Id"
                onChange={(e) => setIdToDelete(e.target.value)}
              />
            </Form.Field>
            <Button animated='vertical' color={'red'} type="submit" onClick={callMockAPIWithAxiosDELETE}>
              <Button.Content visible>Delete Driver</Button.Content>
              <Button.Content hidden>
                <Icon name='delete' />
              </Button.Content>
            </Button>
          </Form.Group>
        </Segment>
        <Segment color="grey">
          <Divider horizontal>
            <b>Update Driver Telephone Number</b>
          </Divider>
          <Form.Group width="equal">
            <Form.Field inline>
              <label>Driver ID</label>
              <input
                placeholder="Enter driver's Id"
                onChange={(e) => setIdToUpdate(e.target.value)}
              />
            </Form.Field>
            <Form.Field inline>
              <label>New Telephone Number</label>
              <input
                placeholder="Enter new telephone number"
                onChange={(e) => setTelephoneNumber(e.target.value)}
              />
            </Form.Field>
            <Button animated='vertical' color={'yellow'} type="submit" onClick={callMockAPIWithAxiosPUT}>
              <Button.Content visible>Update Telephone Number</Button.Content>
              <Button.Content hidden>
                <Icon name='upload' />
              </Button.Content>
            </Button>
          </Form.Group>
        </Segment>
        <Segment>
          <Link to={'/'}>
          <Button fluid size='huge' animated='vertical' color={'blue'} type="submit">
            <Button.Content visible>Back To New Driver Form</Button.Content>
            <Button.Content hidden>
              <Icon name='arrow left' />
            </Button.Content>
          </Button>
          </Link>
        </Segment>
      </Form>
    </div>
  );
}

export default Admin;
