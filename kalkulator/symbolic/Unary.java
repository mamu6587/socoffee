package symbolic;
abstract public class Unary extends Sexpr{

Sexpr argument;
	
public String toString(){
	return getName() + "(to be implemented)" + argument.toString() + ")";
	
	}
	
public int priority(){
	
}
	
	
	
}