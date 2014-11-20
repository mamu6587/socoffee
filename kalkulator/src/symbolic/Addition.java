package symbolic;


public class Addition extends Binary{
	
	
	public Addition(Sexpr left, Sexpr right){
		super.left = left;
		super.right = right;
		
	}
	
	public Sexpr add(Sexpr left, Sexpr right){
		return left.eval() + right.eval();
	}
	
	public String toString(){ //overload to only return left or right?
		
		return this.left.toString() + " + " + this.right.toString();
	}
	
	public Sexpr eval(HashMap map){}
}