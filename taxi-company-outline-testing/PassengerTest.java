import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PassengerTest.
 *
 * @author  David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class PassengerTest
{

    Passenger passenger;
    Location pickup;
    Location dropoff;
    double accountBalance;
    /**
     * Default constructor for test class PassengerTest
     */
    public PassengerTest()
    {
        pickup = new Location("Waterloo Street");
        dropoff = new Location("Bothwell Street");
        passenger = new Passenger(pickup, dropoff);
        accountBalance = 0;
    }

    @Test
    public void TestPassengerDetailsAreCorrect() {
        assertEquals(passenger.getPickupLocation(), pickup);
        assertEquals(passenger.getDestination(), dropoff);
    }

    @Test
    public void TestPassengerBalanceIncrease() {
        passenger.incrementBalance(12);
        assertEquals(12, passenger.getAccountBalance(), 0.001);
    }

    @Test
    public void TestMakePaymentMethod() {
        passenger.incrementBalance(20);
        assertEquals(passenger.makePayment(20), 0, 0.001);
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test basic creation of a passenger.
     * Ensure that the pickup and destination locations
     * have been set.
     */
    @Test
	public void testCreation()
	{
		Location pickup = new Location();
		Location destination = new Location();
		Passenger passenger1 = new Passenger(pickup, destination);
		assertEquals(destination, passenger1.getDestination());
		assertEquals(pickup, passenger1.getPickupLocation());
	}
}


