package trafiksimulering;

public class Lane {

    public static class OverflowException extends RuntimeException {
        // Undantag som kastas n�r det inte gick att l�gga 
        // in en ny bil p� v�gen
    }

    protected CarPosition[] theLane;

    public Lane(int n) {
    this.theLane = new CarPosition[n] ;
    	
    	for(int i = n;i > 0;i--){
    		this.theLane[i].setForward(this.theLane[i-1]) ;
    	}
	// Konstruerar ett Lane-objekt med plats f�r n fordon
    // Samt l�nker ihop varje CarPosition med forward f�r den framf�r
    }
    
    public boolean matchEnd(CarPosition target)
    {
    	if(this.theLane[0] == target){
    		return true;
    	}
    	else{
    		return false;
    	}		
    }
    
    public int getLength(){
    	return theLane.length;
    }
    
    public void setParallel(Lane sideLane)
    {
    	int i = 0;
    	
    	while(i < sideLane.getLength() && i < theLane.length)
    	{
    		theLane[i].setTurn(sideLane.theLane[i]);
    		i++;
    	}
    }

    public void step() {
    	for(int i = 1; i < theLane.length;i++ ){if(this.theLane[i].moveForward()){
    		Car a = this.theLane[i].getCar();
    		a.step();
    		//this.theLane[i].getCar().step;
    		
    		this.theLane[i-1].setCar(a);
    		}
    	}
	// Stega fram alla fordon (utom det p� plats 0) ett steg 
        // (om det g�r). (Fordonet p� plats 0 tas bort utifr�n 
	// mm h a metoden nedan.)
    }

    public Car getFirst() {
    	if(this.theLane[0].getCar() != null){
    		Car temp = this.theLane[0].getCar();
    				this.theLane[0].setCar(null);
    		return temp;
    	}
    	return null;
	// Returnera och tag bort bilen som st�r f�rst
    }

    public Car firstCar() {
    	if(this.theLane[0].getCar() != null){
    		return this.theLane[0].getCar();
    	}
    	return null;
	// Returnera bilen som st�r f�rst utan att ta bort den
    }


    public boolean lastFree() {
    	if(this.theLane[this.theLane.length-1] == null){
    		return true;
    				}
    	return false;
	// Returnera true om sista platsen ledig, annars false
    }

    public void putLast(Car c) throws OverflowException {
    	if (this.lastFree()){
    		this.theLane[this.theLane.length - 1].setCar(c);
    				c.setPosition(this.theLane[this.theLane.length - 1]);
    	
    	}
 
	// St�ll en bil p� sista platsen p� v�gen
	// (om det g�r).
    }

    public String toString() {
    	String  temp = "";
    	for(int i = 0;i < this.theLane.length;i++){
    	temp += "index " + i + "= " + this.theLane[i];
    	}
    //	return {
    	return	temp;
    		
    	//kolla att hela filen skrivs ut, samt fundera �ver hur mkt som ska skrivas ut
    	}

}