project folder:
project02_swatig/


Brief description of submitted files:

src/CSVReader.java
    - CSVReader Class with three private fields.
    - constructor that takes in filename, reads the cellular.csv file and sets its members data. 
    - getters for members.   


src/CellularData.java
    - CellularData Class with four private fields.
    - constructor that takes in number of rows, columns and starting year.
    - Includes addCountry() for storing the name of the country in 1D array and their cellular data in 2D array.     
    - Includes printTableData() for printing the name of the country and its corresponding data.
    - Includes getNumSubscriptionsInCountryForPeriod() for finding the total number of subscriptions for a country in a specified period.


src/TestCSVReader.java
    - Includes main() for running the application. 
    - Tests the CSVReader which reads input from a CSV file. 
    - Imports cellularData class
    - uses the attributes stored in CSVReader object to fill the CellularData object.
    - Includes printf() that prints the total number of subscriptions for a specified country in a specified period.


resources/cellular.csv
    - A CSV (Comma Separated Value) file containing cellular data of 252 countries from 1960-2012
    - Row contains the data of each country 
    - First Column contains the country name, followed by its data in a given year 
 
resources/cellular_short.csv 
    - A short CSV file containing cellular data of 3 countries from 1960-2012 
    - Row contains the data of each country 
    - First Column contains the country names, followed by its data in a given year
       
RUN.txt
    - console output of CSVReader.java & TestCSVReader.java

README.txt
    - description of submitted files