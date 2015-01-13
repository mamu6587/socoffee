
import java.util.Random;
//import java.io.*;

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


	// Attributes for simulation parameters (probabilities for arrivals and destinations
	public int arrivalProb;
	public int turnProb;
	private int currentTime;

	// Attributes for simulation statistics

	private int maxTime;
	private int sumTime;
	private int meanTime;
	private int forwardBlocked; //how many times way forward blocked by other lane
	private int sumCars;
	private int overFlows;

	//Time during the simulation    
	private int time;

	/**
	 * Creates a TrafficSystem.
	 *
	 * @param arrivalProb the probability out of 10 that a car arrives
	 * @param turnProb the probability out of 10 that a car will turn   
	 * @param lengthTurn the length of the turning lane
	 * @param lengthStart the length of the 
	 * @param period the period of the lights
	 * @param green1 green time of the light for cars going forward
	 * @param green2 green time of the turning light    
	 */

	public TrafficSystem(int arrivalProb, int turnProb, 
			int lengthTurn, int lengthStart, 
			int period, int green1, int green2){
		this.r0 = new Lane(lengthStart);
		this.r1 = new Lane(lengthTurn);
		this.r2 = new Lane(lengthTurn);
		this.s1 = new Light(period, green1);
		this.s2 = new Light(period, green2);
		this.time = 0;
		this.maxTime = 0;
		this.sumCars = 0;
		this.sumTime = 0;
		this.arrivalProb = arrivalProb;
		this.turnProb = turnProb;
		this.overFlows = 0;
	}

	// public void readParameters() {
	// Reads the parameters for the simulation
	// The method can read from the terminal(check), dialogue windows 
	// or from a parameterfile. A parameterfile is preferrable 
	// when testing many different parameters since one does 
	// not have to enter new values for each simulation.
	// The standard class Properties is useful for this purpose.

	// The period should be the same for both lights

	// Variable for arrival probability


	// variable for turn probability






	/**
	 * Steps the whole TrafficSystem one time unit 
	 *
	 * 
	 */

	public void step() {
		// Step the system one time step by using the components step methods
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

		if (!r2.lastFree() && r0.firstCar()!= null){
			if(r0.firstCar().getTurn()){
				for (CarPosition a : r0.theLane ){
					if (a.getCar() != null){
						if(a.getCar().getTurn()){
							forwardBlocked++;
							break;
						}
					}
					else break;
				}
			}
		}


		if (!r1.lastFree() && r0.firstCar()!= null){
			if(!r0.firstCar().getTurn()  ){
				for (CarPosition a : r0.theLane ){
					if (a.getCar() != null){
						if(!a.getCar().getTurn()){
							forwardBlocked++;
							break;
						}

					}
					else break;
				}
			}
		}

		// r0.theLane[0].getCar().getDestination() == r1.theLane[0]
		
				if(r0.theLane[0].getCar() != null){
					if(r0.theLane[0].getCar().getTurn()&&r2.lastFree()){
						r2.putLast(r0.getFirst());
					}
					else if(r1.lastFree()){
						r1.putLast(r0.getFirst());
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

					if(!r0.lastFree()){
					overFlows++;

					}
					else{
						
						r0.putLast(car);
					}

						



					sumCars++;

				}

				this.time++;

	}
	/**
	 * Prints all the gathered statistics
	 *
	 * 
	 */
	public void printStatistics() {
		// Print the gathered statistics

		System.out.println(
				"\n\n For parameters:" +
						"\n Arrival probability = " + this.arrivalProb + "/10 " +
						"\n Turn probability = " + this.turnProb + "/10" +
						"\n Lane length = " + (this.r0.theLane.length + this.r1.theLane.length) +
						"\n Turn lane length = " + this.r2.theLane.length +
						"\n Simulation timelength = " + this.time +
						"\n Traffic light specs =" + " " + this.s1.getGreen() + "/" + this.s1.getPeriod() +
						"\n Turn light specs =" + " " + this.s2.getGreen() + "/" + this. s2.getPeriod() 
					
				);
		if (sumCars != 0){this.meanTime = sumTime/sumCars;
		}
		else {this.meanTime = 0;}


		System.out.println("----------------------------------");
		System.out.println(" MaxTime = " + this.maxTime +", "+
				" MeanTime = " + meanTime + ", " +
				" ForwardBlocked = " + this.forwardBlocked + 
				", Overflows = " + this.overFlows);
		System.out.println("----------------------------------");    	    
	}

	/**
	 * 
	 * Prints an ASCII-representation of the TrafficSystem at a specific point in time.
	 * 
	 */
	public void print() {
		System.out.println("\n");
		System.out.println(s1.toString() + "|" + this.r1.toString()  + this.r0.toString() );
		System.out.println(s2.toString() + "|" + this.r2.toString());

		// Print a graphical representation by using the Classes toString-methods
	}

}
