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
input.txt

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
SimpleJSONAPI.postman_collection.json