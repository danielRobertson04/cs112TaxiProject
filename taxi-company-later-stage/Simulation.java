import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Run the simulation by asking a collection of actors to act.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class Simulation
{
    private List<Actor> actors;
    private int step;

    private PassengerSource source;
    private TaxiCompany company;

    /**
     * Create the initial set of actors for the simulation.
     */
    public Simulation()
    {
        actors = new LinkedList<>();
        step = 0;
        City city = new City();
        company = new TaxiCompany(city);
        source = new PassengerSource(city, company);
        
        actors.addAll(company.getVehicles());
        actors.add(source);
        actors.add(new CityGUI(city));
    }
    
    /**
     * Run the simulation for a fixed number of steps.
     * Pause after each step to allow the GUI to keep up.
     */
    public void run()
    {
        for(int i = 0; i < 500; i++){
            step++;
            step();
            wait(100);
        }
        generateReport();
    }

    /**
     * Take a single step of the simulation.
     */
    public void step()
    {
        for(Actor actor : actors) {
            actor.act();
        }
    }
    
    /**
     * Wait for a specified number of milliseconds before finishing.
     * This provides an easy way to cause a small delay.
     * @param milliseconds The number of milliseconds to wait.
     */
    private void wait(int milliseconds)
    {
        try
        {
            Thread.sleep(milliseconds);
        } 
        catch (InterruptedException e)
        {
            // ignore the exception
        }
    }

    public int getMissedPickups(){
        return source.getMissedPickups();
    }

    public void generateReport(){

        List<Vehicle> driverList = company.getVehicles();
        Iterator<Vehicle> drivers = driverList.iterator();
        double avgTotalPickup = 0;
        double avgTotalDropOff = 0;
        double avgIdleTime = 0;

        while (drivers.hasNext()){
            Vehicle currentVehicle = drivers.next();
            avgTotalPickup = avgTotalPickup + currentVehicle.getAvgPickUp();
            avgTotalDropOff = avgTotalDropOff + currentVehicle.getAvgDropOff();
            avgIdleTime = avgIdleTime + currentVehicle.getIdleCount();
        }

        avgTotalPickup = (avgTotalPickup / driverList.size()) / 10;
        avgTotalDropOff = (avgTotalDropOff + driverList.size()) / 10;
        avgIdleTime = (avgIdleTime + driverList.size()) / 10;

        System.out.println("Average Pick up Time: " + avgTotalPickup + " seconds");
        System.out.println("Average Drop off Time: " + avgTotalDropOff + " seconds");
        System.out.println("Number of Missed Passengers: " + source.getMissedPickups());
        System.out.println("Total idle time: " + avgIdleTime + " seconds");

    }
}
