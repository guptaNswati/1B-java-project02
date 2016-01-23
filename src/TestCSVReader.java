import project02_swatig.CellularData;

/**
 *  Tests the CSVReader class, which reads input from a CSV file. Uses
 *  the attributes stored in CSVReader object to fill the CellularData class.
 *
 * @author Foothill College, [Swati Gupta]
 *
 */

public class TestCSVReader
{
    /**
     * Uses a CSVReader to parse a CSV file.
     * Adds each parsed line to an instance of the CellularData class.
     */
    public static void main(String[] args) 
    {			
        final String FILENAME = "resources/cellular.csv";

        CSVReader parser = new CSVReader(FILENAME);
     
        // pointer for CSV members               
        String[] countryNames = parser.getCountryNames(); 
        int [] yearLabels = parser.getYearLabels();
        double [][] parsedTable = parser.getParsedTable();

        CellularData datatable;
        int numRows = parsedTable.length;
        int numColumns = parsedTable[0].length;
        int startingYear = yearLabels[0];

        datatable = new CellularData(numRows, numColumns, startingYear);

        // From the array that stores parsed information,
        // add one country at a time to an object of type CellularData.				
        for (int countryIndex = 0; countryIndex < countryNames.length; countryIndex++)
        {
            double[] countryData = parsedTable[countryIndex];
            datatable.addCountry(countryNames[countryIndex], countryData);		
        }

        //additional test cases testing out of range data

        System.out.printf(countryNames[2] + " (1970 to 1990): %.2f \n \n", 
                datatable.getNumSubscriptionsInCountryForPeriod(countryNames[2],1970,1990));

        System.out.printf(countryNames[155] + " (1959 to 1989): %.2f \n \n", 
                datatable.getNumSubscriptionsInCountryForPeriod(countryNames[155],1959,1989));

        System.out.printf(countryNames[10] + " (1960 to 2000): %.2f \n \n", 
                datatable.getNumSubscriptionsInCountryForPeriod(countryNames[10],1960,2000));

        System.out.printf(countryNames[251] + " (1988 to 2012): %.2f \n \n", 
                datatable.getNumSubscriptionsInCountryForPeriod(countryNames[251],1988,2012));

        System.out.printf(countryNames[111] + " (1961 to 2014): %.2f \n \n", 
                datatable.getNumSubscriptionsInCountryForPeriod(countryNames[111],1961,2014));

        // given test cases

        System.out.printf(countryNames[0] + " (1960 to 2012): %.2f \n \n", 
                datatable.getNumSubscriptionsInCountryForPeriod(countryNames[0],1960,2012));

        System.out.printf(countryNames[100] + " (1960 to 2012): %.2f \n \n", 
                datatable.getNumSubscriptionsInCountryForPeriod(countryNames[100],1960,2012));

        System.out.printf(countryNames[200] + " (1960 to 2012): %.2f \n \n",
                datatable.getNumSubscriptionsInCountryForPeriod(countryNames[200],1960,2012));
    }
}
