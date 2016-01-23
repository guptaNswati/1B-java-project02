package project02_swatig;

public class CellularData
{
    private int countryCount = 0; // total number of countries stored in table
    private int initialYear;
    private String[] countryNames;  // array of names of added countries
    private double[][] table; // 2D array containing rows with cellular data of a given country over many years 

    public CellularData(int numRows, int numColumns, int startingYear)
    {  
        initialYear = startingYear;
        countryNames = new String[numRows];
        table = new double[numRows][numColumns];  
    }

    // stores the name of the country in one array and their cellular data in 2D array
    public void addCountry(String countryName, double[] countrySubscriptionData)
    {
        countryNames[countryCount] = countryName;

        for(int i = 0; i < countrySubscriptionData.length; i++)
        {
            table[countryCount][i] = countrySubscriptionData[i];  
        }

        countryCount++;       
    }
  
    // prints name of country and its data 
    public void printTableData()
    {
        for(int i = 0; i < table.length; i++)
        {
            System.out.println();
            System.out.println(countryNames[i] + "\n");

            for(int j = 0; j < table[i].length; j++)
            {
                System.out.print(table[i][j] + " | ");  

            }
            System.out.println();                              
        }    
    }
  
    // computes total number of subscriptions for a given country over a period of time
    public double getNumSubscriptionsInCountryForPeriod(String countryName,
            int startingYear, int endingYear)
    {
        double totalSubscriptions = 0;

        try
        {
            for(int i = 0; i < table.length; i++)
            {
                if (countryNames[i].equals(countryName))
                {
                    for(int j = startingYear - initialYear; j <= endingYear - initialYear; j++) 
                    {
                        totalSubscriptions += table[i][j];
                    }
                    break;
                }
            
            }
       
        }
        
        // handles error for out of range year
        catch(Exception e)
        {
            /*
             * starting from initial year checks for all the years in a specified period 
             */
            if (startingYear < initialYear)
            {
                System.out.println("Please enter a valid year. The requested year is less than " + initialYear); 
            }

            else if (endingYear > table.length - 1 + initialYear)
            {
                System.out.println("Please enter a valid year. The requested year is out of range");
            }
            return 0.0;
        }  

        return totalSubscriptions;
    }      

}
