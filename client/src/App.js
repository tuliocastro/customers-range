import React, { Component } from 'react';
import axios from 'axios';
import './App.scss';
import CustomerForm from './components/customer-form/CustomerForm';
import CustomerMap from './components/customer-map/CustomerMap';
import CustomerList from './components/customer-list/CustomerList';

export default class App extends Component {

  constructor(props) {
    super(props);
    this.state = {
      error: false,
      customers: []
    }
  }

  uploadFile = (file) => {

    this.setState({ error: false });

    if (!file) {
      this.setState({ customers: [] });
      return;
    }

    const url = "http://localhost:4567/customer";
    const formData = new FormData();
    formData.append('file', file);
    const config = {
      headers: {
        'content-type': 'multipard/form-data'
      }
    }

    axios.post(url, formData, config)
      .then(response => {
        this.setState({ customers: response.data });
      })
      .catch(ex => {
        this.setState({ customers: [], file: null, error: true });
      });

  }

  render() {

    return (
      <div className="App">

        <div className="list">

          {this.state.error &&
            <div className="error">
              Invalid file, please select another one.
          </div>
          }

          <CustomerForm callback={this.uploadFile} />

          <CustomerList customers={this.state.customers} />
        </div>

        <div className="map">

          <CustomerMap customers={this.state.customers} />

        </div>
      </div>
    );
  }

}

