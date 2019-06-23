import React, { Component } from 'react';
import { Map, TileLayer, Marker, Popup } from 'react-leaflet';
import './CustomerMap.scss';

export default class CustomerMap extends Component {

    render() {

        console.log("loading map", this.props);

        return (
            <Map
                center={[53.339428, -6.257664]}
                zoom={8}
                maxZoom={10}
                easeLinearity={0.35}
            >
                <TileLayer
                    url="https://{s}.basemaps.cartocdn.com/light_all/{z}/{x}/{y}{r}.png"
                    attribution='&copy; <a href="http://www.openstreetmap.org/copyright">OpenStreetMap</a>, &copy; <a href="https://carto.com/attribution">CARTO</a>'
                />
                {this.props.customers.map((customer, idx) =>
                    <Marker key={`marker-${idx}`} position={[customer.latitude, customer.longitude]}>
                        <Popup>
                            Popup for any custom information.
                        </Popup>
                    </Marker>
                )}
            </Map>
        );
    }
}
