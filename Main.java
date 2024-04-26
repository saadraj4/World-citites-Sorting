// Header Libraries
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


// Main class to read data from CSV file and sort the cities based on latitude
public class Main {
    //    Read data from CSV file
    public static List<City> readData(String path) throws IOException {
        List<City> cities = new ArrayList<>();
        Reader reader = Files.newBufferedReader(Paths.get(path));
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
        // Parse the CSV file and store the city details
        for (CSVRecord csvRecord : csvParser) {
            String cityName = csvRecord.get(0);
            String cityAscii = csvRecord.get(1);
            double latitude = csvRecord.get(2).isEmpty() ? 0.0 : Double.parseDouble(csvRecord.get(2).replaceAll("\"", ""));
            double longitude = csvRecord.get(3).isEmpty() ? 0.0 : Double.parseDouble(csvRecord.get(3).replaceAll("\"", ""));
            String country = csvRecord.get(4);
            String iso2 = csvRecord.get(5);
            String iso3 = csvRecord.get(6);
            String adminName = csvRecord.get(7);
            String capital = csvRecord.get(8);
            long population = csvRecord.get(9).isEmpty() ? 0 : (long) Double.parseDouble(csvRecord.get(9).replaceAll("\"", ""));
            long id = csvRecord.get(10).isEmpty() ? 0 : (long) Double.parseDouble(csvRecord.get(10).replaceAll("\"", ""));

            cities.add(new City(cityName, latitude, longitude, population, cityAscii, country, iso2, iso3, adminName, capital, id));
        }

        return cities;
    }

    public static void main(String[] args) {
        try {
            //  Read data from CSV file
            String path = "./worldcities.csv"; // Update with the actual path
            List<City> cities = readData(path);
            City[] originalOrderArray = cities.toArray(new City[0]);
            QuickSort.quickSort(originalOrderArray, 0, originalOrderArray.length - 1);

            // Sorting original order
            System.out.println("Part a: Sorted cities by latitude:");
            //  Print the sorted cities
            for (City city : originalOrderArray) {
                System.out.println(city);
            }
            System.out.println("-----------------------------------");
            System.out.println("Part b: Total number of comparisons: "+QuickSort.comparisonCount);


    // Uncomment below code for proving Part B: Does it change if you randomly order the list before sorting? Why/why not
    /*
        System.out.println("\nPart B: Does it change if you randomly order the list before sorting? Why/why not?");
        City[] randomOrderArray = cities.toArray(new City[0]);
        // Randomize the order of the array
        Collections.shuffle(Arrays.asList(randomOrderArray));
        // Sorting randomized order
        System.out.println("\nSorted cities by latitude (random order):");
        for (City city : randomOrderArray) {
            System.out.println(city);
        }
        System.out.println("Total number of comparisons (random order): "+ QuickSort.comparisonCount);
    */
        } catch (Exception e) {
            System.out.println("An error occurred. Please check the file path and try again.");
        }
    }
}