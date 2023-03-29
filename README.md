# ratelimitting

A rate limiter is a tool that monitors the number of requests per
a window time a service agrees to allow. 
If the request count exceeds the number agreed by the
service owner and the user (in a decided window time), the rate limiter blocks all the excess


# **Prerequisites**
To run this application, you'll need:

Java 11 or higher
Maven 3.6.3 or higher


# Installation
To download and install the application, follow these steps:

Clone the repository: git clone https://github.com/aashishjha99/ratelimitting.git <br>
Navigate to the project directory: cd ratelimitting <br>
Build the application: mvn package <br>
Run the application: java -jar target/sratelimitting.jar


# Configuration
The application uses the following configuration files:<br>
  application.properties: contains general application settings, such as server port and database configuration.


# Usage
To use the application, make HTTP requests to the following endpoints:<br>

GET /api/save/{empid}: returns a simple JSON response.<br>
POST /api/v1/save: save user object
