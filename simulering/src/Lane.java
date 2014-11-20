public class Lane {
	@SuppressWarnings("serial")
	public static class OverflowException extends RuntimeException{
		//private String message;
		
		public OverflowException(String s){
			super(s);
			}
		
		/*	public String getMessage(){
				return this.message;*/
		}
	


    protected CarPosition[] theLane;
     /**
     * Creates a Lane with length n 
     *
     * @param n length of Lane aka number of CarPositions
     */

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
     /**
     * Returns the length of a Lane 
     *
     * @return length of this Lane
     */
    public int getLength(){
    	return this.theLane.length;
    }
    /*
    public void setParallel(Lane sideLane)
    {
    	int i = 0;
    	
    	while(i < sideLane.getLength() && i < theLane.length)
    	{
    		theLane[i].setTurn(sideLane.theLane[i]);
    		i++;
    	}
    }
    */
     /**
     * Steps a lane one time unit forward 
     *
     *  
     */
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
    /**
     * Gets the first car in a lane and removes it.
     *
     * @return the car at position 0, null if there is no car.
     */
    public Car getFirst() {
	if(this.theLane[0].getCar() != null){
	    Car temp = this.theLane[0].getCar();
	    this.theLane[0].setCar(null);
	    return temp;
    	}
    	return null;
	// If there is a car at index 0; return it and remove the car.
    }
    
     /**
     * Gets the first car in a lane. 
     *
     * @return the car at position 0, null if there is no car.
     */
    public Car firstCar() {
    	if(this.theLane[0].getCar() != null){
	    return this.theLane[0].getCar();
    	}
    	return null;
	// Return the car at index 0 without removing it.
    }
    
     /**
     * Checks if the last position is empty.
     *
     * @return true if it is, else false
     */
    public boolean lastFree() {
    	if(this.theLane[this.theLane.length-1].getCar() == null){
            return true;
        }
    	return false;
	// Return true if the last place is empty, else false.
    }
   

     /**
     * Puts a car at the last position of the lane and updates the neccessary attributes.
     * 
     * @param c The car to be put at the last position.  
     *
     */  

  
	    public void putLast(Car c) throws OverflowException{
	    	
	    	if(!this.lastFree()){
	    		throw new OverflowException("Too many cars");
	    		}
	    	// Place a car on the last CarPosition (if possible)
	    	else {
	   		 this.theLane[this.theLane.length - 1].setCar(c); 
	         //set the CarPositions currentCar to car c
	     		 c.setPosition(this.theLane[this.theLane.length - 1]); 
	         //update the Cars currentPosition
	     }
	    }
	    
	    
     /**
     * Prints a representation of a Lane with any car in the lane.
     *
     * @return The lane modelled in ASCII.
     */
    
    public String toString() {
	
    	
    	String temp ="";
    	for (CarPosition a : theLane){
            temp +=  " " + a.toString() + " |" ;
    	}
    	return temp ;
    }
    
}
