public class Lane{

    public static class OverflowException extends RuntimeException {
        // Exception thrown when a new car could not be placed on theLane 
    }

    protected CarPosition[] theLane;

    public Lane(int n) {
        this.theLane = new CarPosition[n];
        for(int i = 0;i < n;++i){
            this.theLane[i] = new CarPosition(this);
        }
    	
    	for(int i = (n-1);i > 0;--i){
            this.theLane[i].setForward(this.theLane[i-1]);
    	}
	// Constructs a Lane-object with room for n vehicles
        // and links every CarPosition to the one in front of it
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
    	return this.theLane.length;
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
	for(int i = 1; i <= theLane.length-1;i++ ){
	    if(this.theLane[i].moveForward()){
		if(this.theLane[i].getCar() != null){
		    Car a = this.theLane[i].getCar();
		    a.step();
		    this.theLane[i].setCar(null);
		    //this.theLane[i].getCar().step;
		    
		    this.theLane[i-1].setCar(a);
		}	
	    }			
	}	
	// Step every vehicle one step forward (except for index 0), if possible. 
	// . The vehicle at index 0 is removed with another method 
    }
    
    public Car getFirst() {
	if(this.theLane[0].getCar() != null){
	    Car temp = this.theLane[0].getCar();
	    this.theLane[0].setCar(null);
	    return temp;
    	}
    	return null;
	// If there is a car at index 0; return it and remove the car.
    }
    
    public Car firstCar() {
    	if(this.theLane[0].getCar() != null){
	    return this.theLane[0].getCar();
    	}
    	return null;
	// Return the car at index 0 without removing it.
    }
    
    
    public boolean lastFree() {
    	//if(this.theLane[this.theLane.length-1].getCar() == null){
	return true;
	//		}
    	//return false;
	// Return true if the last place is empty, else false.
    }
    
    public void putLast(Car c) throws OverflowException {
    	if (this.lastFree()){
            this.theLane[this.theLane.length - 1].setCar(c); 
            //set the CarPositions currentCar to car c
            c.setPosition(this.theLane[this.theLane.length - 1]); 
            //update the Cars currentPosition
        }
	
	// Place a car on the last CarPosition (if possible)
    }
    
    public String toString() {
	
    	
    	String temp ="";
    	for (CarPosition a : theLane){
            temp +=  " " + a.toString() + " |" ;
    	}
    	return temp ;
    	
    	/*
    	
	  for(CarPosition a : theLane){
	  String b = "";
	  b += a.toString();
	  
    	}
    	return b;
    	*/
    	
    	/*
          String  temp = "";
          for(int i = 0;i < this.theLane.length;i++){
          temp += "index " + i + "= " + this.theLane[i];
          }
          //	return {
          return	temp;
        */
    	//Check that the whole file are printed, and think about
        //how much that should be printed
    }
    
}
