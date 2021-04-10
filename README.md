# SimpleJSONAPIServlet
 API written in Java

Download org.json Package
https://jar-download.com/artifacts/org.json

Download javax.servlet Package
http://www.java2s.com/Code/Jar/j/Downloadjavaxservletjar.htm

Download org.apache.commons.io Package 
https://commons.apache.org/proper/commons-io/download_io.cgi

Run by command line:
Input one parameter as file path of JSON blob file

Run project in Apache Tomcat or other server:

Send POST Request to:
http://localhost:8080/SimpleJSONAPIServlet/api

Body content should contain JSON data in format like:
https://github.com/CoalChris/SimpleJSONAPIServlet/blob/master/input.txt

{
  "income": [
    {
      "value": "12.12",
      "frequency": "day"
    },
    {
      "value": "107.23",
      "frequency": "week"
    },
    {
      "value": "2869.34",
      "frequency": "month"
    },
    {
      "value": "34125.45",
      "frequency": "year"
    }
  ],
  "expenses": [
    "120.23",
    "227.34",
    "965.45"
  ]
} 

Sample Postman file for testing:
https://github.com/CoalChris/SimpleJSONAPIServlet/blob/master/SimpleJSONAPI.postman_collection.json


# Potential Further Improvements
How would you “version” your service so if the FACTOR or whole of the calculation changes you can replicate past results?
Using persisting storage such as a database, the factor could be saved in a table with unique version numbers. Entire calculations could be saved if they are constant and don't often change number of input variables used. To simply record historical calculations for reference, serviceability could be saved against a date or timestamp when it was calculated.

How could you allow an internal party (external to Engineering) to manage the FACTOR and calculation, changing or evolve them as needed?
Currently the factor is simply a constant. To enable users from other departments to change the factor and calculation, a frontend could be built with input fields to save and update the factor or other calculation parameters. The constant would also benefit from being swapped to a function which returns the final factor value.

Describe how would you deal with authorisation. E.g. how can you guarantee only “approved” consumers (humans or not) can access your service?
Authorisation credentials would be required. They could be saved in a database and checked on API call. To further increase security, another API could be developed to input the credentials and return a bearer token for use over a period of time. This means customers won't need to send their credentials every time.
