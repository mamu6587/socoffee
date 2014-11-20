package symbolic;


public class Variable extends Atom{

public String ident; 
	
	
	public Variable(String ident){
		this.ident = ident;
	}
	

	
	public String getName(){
		return this.ident;
	}
	
	//public Sexpr eval(HashMap map){}
}