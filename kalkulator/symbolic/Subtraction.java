package symbolic;

public class Subtraction extends Binary{
Sexpr left;
Sexpr right;


public Subtraction(Sexpr left, Sexpr right){
	this.left = left;
	this.right = right;
	
}


public String toString(){ //overload to only return left or right?
	
	return this.left.toString() + " + " + this.right.toString();	
	}

	//public Sexpr eval(HashMap map){}
}