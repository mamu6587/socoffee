

// Contains a car and knows its "neighbours" 
public class CarPosition{
	
    private Car currentCar = null; // null if there is no car at the position
	
    private Lane owner;
	
    private CarPosition forward;
    private CarPosition turn;

    /**
     * Creates a CarPosition
     *
     * @param a_owner the Lane that owns this CarPpsition
     */	
    public CarPosition(Lane a_Owner)
    {
        owner = a_Owner;
    }
    /**
     * 
     *
     * @return he bornTime of the car
     */
    /* public boolean isEnd(CarPosition target)
    {
        return owner.matchEnd(target);
    }
    */	
    public boolean moveForward()
    { if (this.forward.getCar() == null){
            return true;
	}
        return false;
	       
    }
		
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
	
    public Car getCar(){
        return this.currentCar;
    }
	
    public void setCar(Car car){
        this.currentCar = car;
    }
	
    public CarPosition getForward(){
        return this.forward;
    }
    public void setForward(CarPosition forward){
        this.forward = forward;
    }
	
 /*   public boolean equals (CarPosition B){
    	if (this )
    }
	*/
    public String toString(){

    	/*
    	if(this.currentCar != null){
    		return "CarPosition(currentCar = "+ this.currentCar + 
              "owner = " + this.owner + 
              "forward =" + this.forward + 
              "turn = "+	this.turn + "carinfo =" + this.currentCar.toString();

    		else return "CarPosition(currentCar = "+ this.currentCar + 
          "owner = " + this.owner + 
          "forward =" + this.forward + 
          "turn = "+	this.turn;";
    	}
*/
    	

        if (this.currentCar != null) {
            return this.currentCar.toString();
        }
        else {
            return " ";
            

        }



    }
}
