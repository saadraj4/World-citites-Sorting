// City class to store city details
public class City implements Comparable<City> {
    String name, cityAscii, country, iso2, iso3, adminName, capital;
    double latitude, longitude;
    long population, id;

    // Constructor to initialize the city details
    City(String name, double latitude, double longitude, long population, String cityAscii, String country, String iso2, String iso3, String adminName, String capital, long id) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.population = population;
        this.cityAscii = cityAscii;
        this.country = country;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.adminName = adminName;
        this.capital = capital;
        this.id = id;
    }
    // Compare cities based on latitude
    @Override
    public int compareTo(City other) {
        return Double.compare(this.latitude, other.latitude);
    }
    // Return city details as string
    @Override
    public String toString() {
        return "city= "+name +" latitude= "+latitude;
    }

    public double getLatitude() {
        return latitude;
    }
}