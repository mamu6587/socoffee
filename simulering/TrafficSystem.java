package trafiksimulering;
import java.util.Random;

public class TrafficSystem {
    // Definierar de v�gar och signaler som ing�r i det 
    // system som skall studeras.
    // Samlar statistik
    
    // Attribut som beskriver best�ndsdelarna i systemet
   private Lane  r0;
    private Lane  r1;
    private Lane  r2;
    private Light s1;
    private Light s2;

    
	public int ankomstIntensitet;
	public int svangIntensitet;
	private int currentTime;
    // Diverse attribut f�r simuleringsparametrar (ankomstintensiteter,
    // destinationer...)

    // Diverse attribut f�r statistiksamling
    //....    
    
    private int time = 0;

    public TrafficSystem() {
    	//...
    	}

    public void readParameters() {
	// L�ser in parametrar f�r simuleringen
	// Metoden kan l�sa fr�n terminalf�nster, dialogrutor
	// eller fr�n en parameterfil. Det sista alternativet
	// �r att f�redra vid uttestning av programmet eftersom
	// man inte d� beh�ver mata in v�rdena vid varje k�rning.
        // Standardklassen Properties �r anv�ndbar f�r detta. 
    	
    	// period p� lights skall vara samma
    	
    	// variabel f�r ankomstintensitet
    	ankomstIntensitet = ;
    	
    	// variabel f�r sv�ngintensitet
    	svangIntensitet = ;
    }

    public void step() {
	// Stega systemet ett tidssteg m h a komponenternas step-metoder
	// Skapa bilar, l�gg in och ta ur p� de olika Lane-kompenenterna
    	
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
    	
    

    	// skapa en bil utifr�n ankomstintensitet
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
	// Skriv statistiken samlad s� h�r l�ngt
    }

    public void print() {
	// Skriv ut en grafisk representation av k�situationen
	// med hj�lp av klassernas toString-metoder
    }

}