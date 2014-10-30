package trafiksimulering;
import java.util.Random;

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

    
	public int ankomstIntensitet;
	public int svangIntensitet;
	private int currentTime;
    // Diverse attribut för simuleringsparametrar (ankomstintensiteter,
    // destinationer...)

    // Diverse attribut för statistiksamling
    //....    
    
    private int time = 0;

    public TrafficSystem() {
    	//...
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
    	ankomstIntensitet = ;
    	
    	// variabel för svängintensitet
    	svangIntensitet = ;
    }

    public void step() {
	// Stega systemet ett tidssteg m h a komponenternas step-metoder
	// Skapa bilar, lägg in och ta ur på de olika Lane-kompenenterna
    	
    	if(s1.isGreen()){
    		r1.getFirst();
    	}
    	
    	if(s2.isGreen()){
    		r2.getFirst();
    	}
    	
    	
    	
    	r2.step();
    	r1.step();
    	
    	if(r0.theLane[0].getCar().getDestination() == r1.theLane[0] && r1.lastFree()){
    	r1.putLast(r0.getFirst());
    	}
    	else r2.putLast(r0.getFirst());
    	
    	r0.step();
    	
    

    	// skapa en bil utifrån ankomstintensitet
    	Random carMaybe = new Random();
    	int randomInt = carMaybe.nextInt(10);
    	if(randomInt < ankomstIntensitet){
    		Car car;
    		if(carMaybe.nextInt(10) < svangIntensitet){
    	    car = new Car(currentTime, r0.theLane[r0.getLength()-1], r2.theLane[0]);
    		}
    		else car = new Car(currentTime, r0.theLane[r0.getLength()-1], r1.theLane[0]);
    	r0.putLast(car);
    	}
    	
    }

    public void printStatistics() {
	// Skriv statistiken samlad så här långt
    }

    public void print() {
	// Skriv ut en grafisk representation av kösituationen
	// med hjälp av klassernas toString-metoder
    }

}