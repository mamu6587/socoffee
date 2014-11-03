

// Håller i en bil och känner till sina "grannar". 
public class CarPosition{
	
	private Car currentCar = null; // null om ingen bil finns på positionen
	
	private Lane owner;
	
	private CarPosition forward;
	private CarPosition turn;
	
	public CarPosition(Lane a_Owner)
	{
		owner = a_Owner;
	}
	
	public boolean isEnd(CarPosition target)
	{
		return owner.matchEnd(target);
	}
	
	public boolean moveForward()
	{ if (this.forward.getCar() == null){
		return true;
	}
		return false;
		// Flytta bilen fram till forward
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
		return currentCar;
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
	
	
	public String toString(){
		if (this.currentCar != null) {
		return "X";
		}
		else {
			return " ";
		}
			/*
		return "CarPosition(currentCar = "+ this.currentCar + 
"owner = " + this.owner + 
"forward =" + this.forward + 
"turn = "+	this.turn;
*/
	}
}
