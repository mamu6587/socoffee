package symbolic;



public class Constant extends Atom{
	
	double value;
	
	public Constant(double value){
		this.value = value;	
	}
	
	public double getValue(){
		return this.value;
	}
	
	public boolean isConstant(){ //what is this supposed to do?
		return true;
	}
	
	public Sexpr eval(HashMap map){
	
		
	}

}
