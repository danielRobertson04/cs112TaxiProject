/**
 * Indicate that the destination cannot be the same as the pickup location.
 *
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class InvalidPickupDestinationException extends RuntimeException
{
    private Vehicle vehicle;
    /**
     * Constructor for objects of class MissingPassengerException.
     * @param pickup The vehicle expecting a passenger.
     */
    public InvalidPickupDestinationException(Location pickup)
    {
        super("Destination cannot equal pickup location. You have set both locations to " + pickup);
    }

    /**
     * @return The vehicle for which there was no passenger.
     */
    public Vehicle getVehicle()
    {
        return vehicle;
    }
}
