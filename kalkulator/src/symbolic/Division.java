package symbolic;


public class Division extends Binary{

Sexpr left;
Sexpr right;


public Division(Sexpr left, Sexpr right){
	this.left = left;
	this.right = right;
	
	}


public String toString(){ //overload to only return left or right?
	
	return this.left.toString() + " + " + this.right.toString();
	}



	//public Sexpr eval(HashMap map){}

}