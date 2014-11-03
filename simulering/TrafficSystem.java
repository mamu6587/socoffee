
import java.util.Random;
import java.io.*;

public class TrafficSystem {
    // Definierar de vägar och signaler som ingår i det 
    // system som skall studeras.
    // Samlar statistik
    
    // Attribut som beskriver beståndsdelarna i systemet
   private Lane  r0;
    private Lane  r1;
    private Lane  r2;
    private Light s1;
    private Light s2;

    
	public int arrivalProb;
	public int turnProb;
	private int currentTime;
    // Diverse attribut för simuleringsparametrar (ankomstintensiteter,
    // destinationer...)

    // Diverse attribut för statistiksamling
    //....    
	private int maxTime;
	private int sumTime;
	private int forwardBlocked; //behöver implementeras
	private int sumCars;
    
    private int time;

    public TrafficSystem(int arrivalProb, int turnProb, 
    		int lengthTurn, int lengthStart, int period, int green) {
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
	// Läser in parametrar för simuleringen
	// Metoden kan läsa från terminalfönster, dialogrutor
	// eller från en parameterfil. Det sista alternativet
	// är att föredra vid uttestning av programmet eftersom
	// man inte då behöver mata in värdena vid varje körning.
        // Standardklassen Properties är användbar för detta. 
    	
    	// period på lights skall vara samma
    	
    	// variabel för ankomstintensitet

    	
    	// variabel för svängintensitet

    }

    public void step() {
	// Stega systemet ett tidssteg m h a komponenternas step-metoder
	// Skapa bilar, lägg in och ta ur på de olika Lane-kompenenterna
    	
	    	if(s1.isGreen()){
	    	// summera tid för utplockade bilar och jämför med tidigare max
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
    	
    	if(r0.theLane[0].getCar() != null){
    		if(r0.theLane[0].getCar().getDestination() == r1.theLane[0] && r1.lastFree()){
    	r1.putLast(r0.getFirst());
    	}
    	else r2.putLast(r0.getFirst());
        	}
    	r0.step();
    	
    	s1.step();
    	s2.step();
    	
    

    	// skapa en bil utifrån ankomstintensitet
    	/*
    	Random carMaybe = new Random();
    	int randomInt = carMaybe.nextInt(10);
    	if(randomInt < arrivalProb){
    		Car car;
    		if(carMaybe.nextInt(10) < turnProb){
    	    car = new Car(currentTime, r0.theLane[r0.getLength()-1], r2.theLane[0]);
    		}
    		else car = new Car(currentTime, r0.theLane[r0.getLength()-1], r1.theLane[0]);
    	r0.putLast(car);
    	sumCars++;
    	}
    	*/
    	Car car = new Car(currentTime,r0.theLane[r0.getLength()-1],r1.theLane[0]);
    	r0.putLast(car);
    	currentTime++;
    }

    public void printStatistics() {
	// Skriv statistiken samlad så här långt
    	//int meanTime = sumTime/sumCars;
    //	System.out.println("maxTime = " + this.maxTime +" " +
    	//			"meanTime = " + meanTime + " "
    		//		);
    }

    public void print() {
    	System.out.println("\n");
    	System.out.println("|" + this.r1.toString()  + this.r0.toString() );
    	System.out.println("|" + this.r2.toString());
    	
	// Skriv ut en grafisk representation av kösituationen
	// med hjälp av klassernas toString-metoder
    }

}