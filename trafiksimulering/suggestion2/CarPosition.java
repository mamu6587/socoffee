


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
	{ if (this.forward.currentCar == null){
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
	
	public string toString(){
		return currentCar = "this.currentCar " 
"this.owner "
"this.forward "
	"this.turn"
	}
}
