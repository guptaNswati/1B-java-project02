/**
 *  Tests the CSVReader class, which reads input from a CSV file. Uses
 *  the attributes stored in CSVReader object to fill the CellularData class.
 *
 * @author Foothill College, [YOUR NAME HERE]
 *
 * REMINDER: Include text cases in addition to those provided.
 *           See suggestions at the end of the main() method.
 */
public class TestCSVReader
{

	/**
	 * Uses a CSVReader to parse a CSV file.
     * Adds each parsed line to an instance of the CellularData class.
	 */
	public static void main(String[] args) 
	{	
		// NOTE: Make sure to use relative path instead of specifying the entire path 
        // (such as /Users/alicew/myworkspace/so_on_and_so_forth).
		final String FILENAME = "resources/cellular.csv";	// Directory path for Mac OS X
		//final String FILENAME = "resources\\cellular.csv";	// Directory path for Windows OS (i.e. Operating System)

		CSVReader parser = new CSVReader(FILENAME);

		String [] countryNames = parser.getCountryNames();
		int [] yearLabels = parser.getYearLabels();
		double [][] parsedTable = parser.getParsedTable();		

		CellularData datatable;
		int numRows = parsedTable.length;
		int numColumns = parser.getNumberOfYears();
		int startingYear = yearLabels[0];
		
		datatable = new CellularData(numRows, numColumns, startingYear);

		// From the array that stores parsed information,
		// add one country at a time to an object of type CellularData.
		for (int countryIndex = 0; countryIndex < countryNames.length; countryIndex++)
		{
			double [] countryData = parsedTable[countryIndex];
			datatable.addCountry(countryNames[countryIndex], countryData);					
		}
			
		
		System.out.printf(countryNames[0] + " (1960 to 2012): %.2f \n", datatable.getNumSubscriptionsInCountryForPeriod(countryNames[0],1960,2012));
		// the output is: 
		// Aruba (1960 to 2012): 1170.50 

		System.out.printf(countryNames[100] + " (1960 to 2012): %.2f \n", datatable.getNumSubscriptionsInCountryForPeriod(countryNames[100],1960,2012));
		// the output is: 
		// Hungary (1960 to 2012): 1246.58 
		
		System.out.printf(countryNames[200] + " (1960 to 2012): %.2f \n", datatable.getNumSubscriptionsInCountryForPeriod(countryNames[200],1960,2012));
		// the output is: 
		// Singapore (1960 to 2012): 1582.80
		
		
		// Note: Include additional test cases 
		//
		// Note: Also, make sure to test for other invalid requests for range of years.
	}
}
