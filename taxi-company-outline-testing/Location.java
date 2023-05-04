/**
 * Model a location in a city.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class Location
{

    private String name;

    /**
     * Constructor for objects of class Location
     */
    public Location() {

    }

    public Location(String name) {
        this.name = name;
    }

    // Getters and setters for name, latitude, and longitude

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
