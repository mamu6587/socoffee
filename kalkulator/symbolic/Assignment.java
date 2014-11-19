package symbolic;
public class Assignment extends Binary{
	Sexpr left;
	Sexpr right;
	
	
	public Assignment(Sexpr left, Sexpr right){
		this.left = left;
		this.right = right;
		
	}
	
	
	public String toString(){ //overload to only return left or right?
		
		return this.left.toString() + " + " + this.right.toString();
	}

	public String getName(){
		return "to be implemented";
	}
	
	//public int priority(){}

	//public Sexpr eval(HashMap map){}
}
