# Intercom

## System design

After reading the techtest my first I've developed the simple batch flow using jar file to read a file and parse to an ouput.

Then I've created a small example of a web consuming an API endpoint using the same code to return the customers in range of 100km.

<img align="center" src="readme_files/organization.png" height="300" alt="System Design Img"/>

### Libraries Used
* [Spark](http://sparkjava.com): micro framework for creating endpoints that can run in an embedded server (jetty);
* [Gson](https://github.com/google/gson): framework to serialize/deserialize objects from/to JSON;
* [ReactJS](https://reactjs.org/): Javascript library for ui.