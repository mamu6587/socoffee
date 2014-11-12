
import java.util.Random;
import java.io.*;

public class TrafficSystem {
    // Defines the lanes and traffic lights included in the traffic systems that are studied
    // 
    // Gathers statistics
    
    // Attributes that describes the parts of the system
    private Lane  r0;
    private Lane  r1;
    private Lane  r2;
    private Light s1;
    private Light s2;

    
    // Attributes for simulation parameters (probabilities for arraivals and destinations
    public int arrivalProb;
    public int turnProb;
    private int currentTime;

    // Attributes for simulation statistics
    
    private int maxTime;
    private int sumTime;
    private int forwardBlocked; //Needs to be implemented
    private int sumCars;
    
    //Time during the simulation    
    private int time;

    public TrafficSystem(int arrivalProb, int turnProb, 
                         int lengthTurn, int lengthStart, 
                         int period, int green){
    	this.r0 = new Lane(lengthStart);
    	this.r1 = new Lane(lengthTurn);
    	this.r2 = new Lane(lengthTurn);
    	this.s1 = new Light(period, green);
    	this.s2 = new Light(period, green);
    	this.time = 0;
    	this.maxTime = 0;
    	this.sumCars = 0;
    	this.sumTime = 0;
    	this.arrivalProb = arrivalProb;
    	this.turnProb = turnProb;
    	}

    public void readParameters() {
	// Reads the parameters for the simulation
	// The method can read from the terminal(check), dialogue windows 
        // or from a parameterfile. A parameterfile is preferrable 
        // when testing many different parameters since one does 
        // not have to enter new values for each simulation.
        // The standard class Properties is useful for this purpose.
    	
    	// The period should be the same for both lights
    	
    	// Variable for arrival probabiity
    	
    	
    	// variable for turn probability

    	
    	
    	
    }

    public void step() {
        //Step the system one time step by using the components step methods
	// Create cars, put them in the last place and remove them from 
        // the different Lane-components

    	
	    	if(s1.isGreen()){
                    // summarize the time for removed cars and compare with previous max times
	    		if (r1.firstCar() != null){
	    		int timeInSystem = this.time - (r1.getFirst()).getTime();
	        	sumTime += timeInSystem;
	        	if (timeInSystem > maxTime){
	        		this.maxTime = timeInSystem;
	        	}
	    		}
	    	}
	    	
    	if(s2.isGreen()){
    		if (r2.firstCar() != null){
    			int timeInSystem = this.time - (r2.getFirst()).getTime();
    			sumTime += timeInSystem;
    			
    			if (timeInSystem > maxTime){
    		this.maxTime = timeInSystem;
    								}
    	}
    	}
    	
    	
    	r2.step();
    	r1.step();
    	
    	// r0.theLane[0].getCar().getDestination() == r1.theLane[0]
    	
    	if(r0.theLane[0].getCar() != null){
    		if(r0.theLane[0].getCar().getTurn()){
    			r1.putLast(r0.getFirst());
    			}
    		else {
    			r2.putLast(r0.getFirst());
    			}
        	}
    	r0.step();
    	
    	s1.step();
    	s2.step();
    	
    

    	// Create a car with regards to arrival probability
    	
    	Random carMaybe = new Random();
    	int randomInt = carMaybe.nextInt(10);
    	

    	
	    	if(randomInt < arrivalProb){
	    		Car car;
	    		//check if the car is going to the turnoff lane
	        	Random carTurn = new Random();
	        	int randomTurn = carTurn.nextInt(10);
	        	
	    		 		if(randomTurn < turnProb){
	    	    car = new Car(currentTime, r0.theLane[r0.getLength()-1], true);
	    		}
	    		 		else{ 
	    		 			car = new Car(currentTime, r0.theLane[r0.getLength()-1], false);
	    		 		}
	    	r0.putLast(car);
	    	sumCars++;
	    	}
    	
    	
    	this.time++;

    }

    public void printStatistics() {
	// Print the gathered statistics
    				
System.out.println(
                       "\n\n For parameters:" +
                        "\n Arrival probability = " + this.arrivalProb + "/10 " +
    			"\n Turn probability = " + this.turnProb + "/10" +
    			"\n Lane length = " + (this.r0.theLane.length + this.r1.theLane.length) +
    			"\n Turn lane length = " + this.r2.theLane.length +
    			"\n Simulation timelength = " + this.time +
    			"\n Traffic light specs =" + this.s1.toString() +
    			"\n Turn light specs =" + this.s2.toString() 
    			);
    	int meanTime = sumTime/sumCars;
        System.out.println("----------------------------------");
    	System.out.println(" MaxTime = " + this.maxTime +", "+
                           "MeanTime = " + meanTime + " ");
        System.out.println("----------------------------------");    	    
}

    public void print() {
    	System.out.println("\n");
    	System.out.println("|" + this.r1.toString()  + this.r0.toString() );
    	System.out.println("|" + this.r2.toString());
    	
        // Print a graphical representation by using the Classes toString-methods
    }

}
