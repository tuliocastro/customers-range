import React, { Component } from 'react';
import './CustomerList.scss';

export default class CustomerList extends Component {

    render() {
        return (

            <div className="CustomerList">

                {this.props.customers.map((customer, idx) =>
                    <div key={`marker-${idx}`} className="customer">
                        <label className="id">#{customer.user_id}</label>
                        <label className="name">{customer.name}</label>
                        <label className="distance">{customer.distance.toFixed(0)} KM</label>
                        <div className="distance-bar">
                            <div className="distance-bar-value" style={{ width: customer.distance * 100 / 100 + '%' }}></div>
                        </div>
                    </div>
                )}
            </div>
        )
    }
}
