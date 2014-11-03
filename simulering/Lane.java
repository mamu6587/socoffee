

public class Lane{

    public static class OverflowException extends RuntimeException {
        // Undantag som kastas när det inte gick att lägga 
        // in en ny bil på vägen
    }

    protected CarPosition[] theLane;

    public Lane(int n) {
    this.theLane = new CarPosition[n];
    for(int i = 0;i < n;++i){
    	this.theLane[i] = new CarPosition(this);
    }
    	
    	for(int i = (n-1);i > 0;--i){
    		this.theLane[i].setForward(this.theLane[i-1]) ;
    	}
	// Konstruerar ett Lane-objekt med plats för n fordon
    // Samt länker ihop varje CarPosition med forward för den framför
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
	    	for(int i = 1; i < theLane.length-1;i++ ){
	    		if(this.theLane[i].moveForward()){
	    			if(this.theLane[i].getCar() != null){
	    				Car a = this.theLane[i].getCar();
	    				a.step();
	    		//this.theLane[i].getCar().step;
	    		
	    				this.theLane[i-1].setCar(a);
	    			}	
	    			}			
	    		}	
		// Stega fram alla fordon (utom det på plats 0) ett steg 
	        // (om det går). (Fordonet på plats 0 tas bort utifrån 
		// mm h a metoden nedan.)
	    }
	
	    public Car getFirst() {
    	if(this.theLane[0].getCar() != null){
    		Car temp = this.theLane[0].getCar();
    				this.theLane[0].setCar(null);
    		return temp;
    	}
    	return null;
	// Returnera och tag bort bilen som står först
    }

    public Car firstCar() {
    	if(this.theLane[0].getCar() != null){
    		return this.theLane[0].getCar();
    	}
    	return null;
	// Returnera bilen som står först utan att ta bort den
    }


    public boolean lastFree() {
    	if(this.theLane[this.theLane.length-1].getCar() == null){
    		return true;
    				}
    	return false;
	// Returnera true om sista platsen ledig, annars false
    }

    public void putLast(Car c) throws OverflowException {
    	if (this.lastFree()){
    		this.theLane[this.theLane.length - 1].setCar(c); //sätt carpositions current till car
    		c.setPosition(this.theLane[this.theLane.length - 1]); //sätt bilens currentposition
    	
    	}
 
	// Ställ en bil på sista platsen på vägen
	// (om det går).
    }

    public String toString() {
    	String temp ="";
    	for (int i =0; i < this.getLength() - 1; i++ ){
    		temp +=  " " + this.theLane[i].toString() + " |" ;
    	}
    	return temp ;
    	/*
    	String  temp = "";
    	for(int i = 0;i < this.theLane.length;i++){
    	temp += "index " + i + "= " + this.theLane[i];
    	}
    //	return {
    	return	temp;
    		*/
    	//kolla att hela filen skrivs ut, samt fundera över hur mkt som ska skrivas ut
    	}

}