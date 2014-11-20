package symbolic;
	import java.util.HashMap;


	
public abstract class Sexpr{
	
	HashMap variabelnamn = new HashMap();
	
	/*String name;
	double value;
	int priority;
	boolean constant; 
	*/
	
	public Sexpr(){
	
	
	}
	
	public abstract String getName();
	
	public double getValue(){
		return this.value;
	}
	
	public int getPriority(){
		return this.priority;
	}
	
	public boolean isConstant(){
		return this.constant;
	}
	
	public abstract Sexpr eval(HashMap map);
	
	public String toString(){
		return Double.toString(this.value);
	}
	
}