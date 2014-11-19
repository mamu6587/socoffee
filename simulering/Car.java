

public class Car {

    private int bornTime;
    private boolean Turn;

    private CarPosition currentPosition;
    
    public void step(){
    	this.currentPosition = this.currentPosition.getForward();
    }
    
    /**
     * Creates an instance of a Car object 
     *
     * @param bornTime an int representing the time this car was created
     * @param currentPosition which CarPosition this Car should be initialized to
     * @param turn  a boolean to know whether the car is supposed to turn
     */
    public Car(int bornTime, CarPosition currentPosition,  boolean turn){
    	this.bornTime = bornTime;
    	this.Turn = turn;
    	this.currentPosition = currentPosition;
    }

//konstruktor och get- och set-metoder
    /**
     * Gets the bornTime from the car
     *
     * @return the bornTime of the car
     */
    public int getTime(){
    	return this.bornTime;
    }
    
    /**
     * Gets the current position from the car
     *
     * @return the current position of the car
     */

    public CarPosition getPosition(){
    	return this.currentPosition;
    }
    /**
     * 
     *
     * @return true if the car should turn, false otherwise
     */
    public boolean getTurn(){
    	return this.Turn;
    }
    /**
     * Sets the current osition for the Car
     *
     * @param position the new position
     */
    public void setPosition(CarPosition position){
    	this.currentPosition = position;
    }
    /**
     * Sets the turn attribute
     *
     * @param turn true for turn, false for going straight
     */
    public void setTurn(boolean turn){
    	this.Turn = turn;
    	}
    
  
    
    
    /**
     * Prints a representation of a car
     *
     * @return the String "X"
     */
   
    public String toString() {
        	return "x";
    }

}
