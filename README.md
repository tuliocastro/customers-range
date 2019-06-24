# Intercom - Customers Find

This solution reads the full list of customers and output the names and user ids of matching customers (within 100km), sorted by User ID (ascending).

<img align="center" src="readme_files/devices.png" height="300" alt="Devices"/>

## System design

After reading the techtest I saw an opportunity to do a small functional example so I've developed the simple batch flow using jar file to read a file and parse to an ouput and a small web client consuming an API endpoint using the same code to return the customers in range of 100km.

<img align="center" src="readme_files/organization.png" height="300" alt="System Design Img"/>

### Libraries Used
* [Spark](http://sparkjava.com): micro framework for creating endpoints that can run in an embedded server (jetty);
* [Gson](https://github.com/google/gson): framework to serialize/deserialize objects from/to JSON;
* [ReactJS](https://reactjs.org/): Javascript library for ui.

## How to run

First we need to build the project, this commando will pack and test the project:

    //Unix
    cd server/ && ./mvnw clean package
    
    //Windows
    cd api && mvnw clean package

### 1 - Bash mode

In order to run the algorithm in a batch mode, execute the following:

    java -jar server/target/intercom-customer-finder.jar customers_example.txt

Passing a string with path file as argument you will receive the ouput of customers in 100km.

### 2 - Server mode

    java -jar server/target/intercom-customer-finder.jar

Using this command without any argument, will start a server which will be running in `http://localhost:4567/` and the endpoint `/customer` available:
* [POST] /customer: Add a file as parameter to consume this endpoint and receive the list of customers in 100km

### 3 - Client

Execute the command:

    cd client/ && npm install && npm start

The client will be running in `http://localhost:3000/`

