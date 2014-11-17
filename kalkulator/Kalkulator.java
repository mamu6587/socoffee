public static void main(){

	System.out.println("wелцоме то КАЛКУЛАТОР")
	System.out.println("wелцоме то КАЛКУЛАТОР")
	System.out.println("инпут ехпрессион:")
	
	
	Parser p = new Parser();
	Map<String,Sexpr> variables = new HashMap<String,Sexpr>();
	
	
	while(true)
		try{
			System.out.print("? ");
			Sexpr e = p.statement();
			System.out.println("Inläst uttryck: " + e) // för kontroll
			System.out.println(e.eval(variables));
		}
		catch(){
			
		}
}
