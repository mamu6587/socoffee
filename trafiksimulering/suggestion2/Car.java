

public class Car {

    private int bornTime;
    private CarPosition destination; 

    private CarPosition currentPosition;
    
    public void step()
    {
    	this.currentPosition = this.currentPosition.forward;
    	
    	/*if (this.currentPosition.owner == this.destination.owner){
    		if (currentPosition.moveForward()) {
    			this.currentPosition = currentPosition.forward;
    		}
    		else if ( isGreen() ) {
    			
    		}
    	}*/
    }
    
    public Car(int bornTime, CarPosition destination, CarPosition currentPosition){
    	this.bornTime = bornTime;
    	this.destination = destination;
    	this.currentPosition = currentPosition;
    	
  
    }
//konstruktor och get- och set-metoder
    
    public getTime(){
    	return this.bornTime;
    }
    
    public getPosition(){
    	return this.currentPosition;
    }
    
    public getDestination(){
    	return this.destination;
    }
    
    public setPosition(CarPosition position){
    	this.currentPosition = position;
    }
    
    public setDestination(CarPosition destination){
    	this.destination = destination;}
    //...

    public String toString() {
    	return "Car(bornTime = " + this.bornTime +",
    currentPosition = " + this.currentPosition + "
    	destination = 	 " + this.destination + ")";
    	}
	
}
