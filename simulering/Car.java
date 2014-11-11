

public class Car {

    private int bornTime;
    private boolean Turn;

    private CarPosition currentPosition;
    
    public void step()
    {
    	this.currentPosition = this.currentPosition.getForward();
    	
    	/*if (this.currentPosition.owner == this.destination.owner){
    		if (currentPosition.moveForward()) {
    			this.currentPosition = currentPosition.forward;
    		}
    		else if ( isGreen() ) {
    			
    		}
    	}*/
    }
    
    public Car(int bornTime, CarPosition currentPosition,  boolean turn){
    	this.bornTime = bornTime;
    	this.Turn = turn;
    	this.currentPosition = currentPosition;
    	
  
    }
//konstruktor och get- och set-metoder
    
    public int getTime(){
    	return this.bornTime;
    }
    
    public CarPosition getPosition(){
    	return this.currentPosition;
    }
    
    public boolean getTurn(){
    	return this.Turn;
    }
    
    public void setPosition(CarPosition position){
    	this.currentPosition = position;
    }
    
    public void setTurn(boolean turn){
    	this.Turn = turn;
    	}
    //...
    

   
    public String toString() {
    	
    	/*
    	return ("borntime = " + this.bornTime +
    					"currentposition = " this.currentPosition +
    					"destination = " this.destination);
	*/

    	return "x";
    }
    /*	return "Car(bornTime = " + this.bornTime +
    "currentPosition = " + this.currentPosition + 
    	"destination = 	 " + this.destination + ")";
    	}
	*/
}
