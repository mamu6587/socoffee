

// Contains a car and knows its "neighbours" 
public class CarPosition{
	
    private Car currentCar = null; // null if there is no car at the position
	@SuppressWarnings("unused")
	private Lane owner;
  
	
    private CarPosition forward;


    /**
     * Creates a CarPosition
     *
     * @param a_owner the Lane that owns this CarPpsition
     */	
    public CarPosition(Lane owner){
    	this.owner = owner;
    }
    
    /**
     * Checks if the CarPosition forward is null or not 
     * @return  true if there is no Car in forward, else false 
     */
    	
    public boolean moveForward()
    { if (this.forward.getCar() == null){
            return true;
	}
        return false;
	       
    }

    /**
     * Gets the bornTime from the car
     *
     * @return the bornTime of the car
     */
    

/*		
    public boolean turn()
    { if (this.turn.currentCar == null){
            return true;
        }
        else return false;
        // Flytta bilen till turn
    }


    public void setTurn(CarPosition turn) {
        this.turn = turn;
    }

    public CarPosition getTurn() {
        return turn;
    }
*/	
     /**
     * Gets the currentCar from this CarPosition 
     *
     * @return the currentCar
     */
    public Car getCar(){
        return this.currentCar;
    }
     /**
     * Sets a Car in this CarPosition 
     *
     *
     * @param car the Car that is supposed to be set in the CarPosition
     */
    public void setCar(Car car){
        this.currentCar = car;
    }
     /**
     * Gets the forward CarPosition
     *
     * @return the attribute CarPosition forward 
     */
    public CarPosition getForward(){
        return this.forward;
    }
     /**
     * Sets the forward CarPosition
     *
     * @param forward forward gets set as the forward CarPosition to this car
     */

    public void setForward(CarPosition forward){
        this.forward = forward;
    }
     

     /**
     * Prints a representation of a CarPosition 
     *
     * @return " " or "X"
     */
    public String toString(){
        if (this.currentCar != null) {
            return this.currentCar.toString();
        }
        else {
            return " ";
            

        }
    }
}
