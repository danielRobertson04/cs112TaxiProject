import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TaxiTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TaxiTest
{
    private Taxi taxi;
    
    /**
     * Default constructor for test class TaxiTest
     */
    public TaxiTest()
    {
    }

    /**
     * Create a taxi.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        TaxiCompany company = new TaxiCompany();
        Location taxiLocation = new Location();
        taxi = new Taxi(company, taxiLocation);
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
     * Test creation and the initial state of a taxi.
     */
    @Test
    public void testCreation()
    {
        assertEquals(true, taxi.isFree());
    }
    
    /**
     * Test that a taxi is no longer free after it has
     * picked up a passenger.
     */
    @Test
    public void testPickup()
    {
        Location pickup = new Location();
        Location destination = new Location();
        Passenger passenger = new Passenger(pickup, destination);
        taxi.pickup(passenger);
        assertEquals(false, taxi.isFree());
    }
    
    /**
     * Test that a taxi becomes free again after offloading
     * a passenger.
     */
    @Test
    public void testOffload()
    {
        testPickup();
        taxi.offloadPassenger();
        assertEquals(true, taxi.isFree());
    }
    
    //rajveer point 4 tests
 //Test that a taxi has arrived at the pickup location.

@Test
public void testArriveAtPickupLocation()
{
    Location pickup = new Location(1, 2);
    Location destination = new Location(3, 4);
    Passenger passenger = new Passenger(pickup, destination);
    taxi.pickup(passenger);
    assertEquals(pickup, taxi.getCurrentLocation());
}

 //Test that a taxi has picked up the correct passenger.

@Test
public void testPickupCorrectPassenger()
{
    Location pickup = new Location(1, 2);
    Location destination = new Location(3, 4);
    Passenger passenger = new Passenger(pickup, destination);
    taxi.pickup(passenger);
    assertEquals(passenger, taxi.getPassenger());
}


// Test that a taxi has arrived at the passenger's destination
@Test
public void testArriveAtDestination()
{
    Location pickup = new Location(1, 2);
    Location destination = new Location(3, 4);
    Passenger passenger = new Passenger(pickup, destination);
    taxi.pickup(passenger);
    taxi.offloadPassenger();
    assertEquals(destination, taxi.getCurrentLocation());
}

    
}

