package symbolic;


public class Multiplication extends Binary{
Sexpr left;
Sexpr right;


	public Multiplication(Sexpr left, Sexpr right){
	this.left = left;
	this.right = right;
	
	}


	public String toString(){ //overload to only return left or right?
	
	return this.left.toString() + " + " + this.right.toString();
	}
	
	
	//public Sexpr eval(HashMap map){}
}