public class Simulation {

    public static void main(String [] args) {
    	
    	
    	
    	
    	
    	//error if input invalid
    	if(args.length != 8){
		System.out.println ("Accepted input: \n"
				+ "Arrival probability,\n" +
				 "Turn probability,\n  "
		+ "Lane length,\n "
		+ "Turn lane length,\n "
		+ "Traffic lights' period (shared)"
		+ "Traffic light green time,\n "
		+ "Turn light green time\n" 
		+ "Simulation timelength,\n");
    	}
	// Creates a TrafficSystem
	// Performs the stepping, calls printing methods
   
        // args will contain, in order :
    	
        // int arrivalProb, int turnProb, 
        // int lengthTurn, int lengthStart, 
        // int period, int green1, int green2 
    	// and args[7] = how many steps the simulation should have
    	

    	
    	//dokumentation med JavaDoc
    	//makefil med tester
    	//readme.md med:
    	//hur man bygger
    	//hur man kör
    	//en lista över samtliga mål som redovisats med programmet
    	//listar eventuella utökningar
    	//övrig information av nytta
    	
    	//enhetstester
    	
    	


    	final int[] convertedArgs = {Integer.parseInt(args[0]), Integer.parseInt(args[1]), 
    			Integer.parseInt(args[2]), Integer.parseInt(args[3]), 
    			Integer.parseInt(args[4]), Integer.parseInt(args[5]), 
    			Integer.parseInt(args[6]), Integer.parseInt(args[7])
    			};
    	

    	//validerar indata
    	//aP & tP > 0, <= 10
    	// lT & lS > 0
    	//period >= 0
    	//green1 & 2 >= 0, <= period 
    	
    	
    	 if(convertedArgs[0] < 0 || convertedArgs[1] < 0 //everything should be above or equal to zero
    			 ||  convertedArgs[2] <= 0 || convertedArgs[3] <= 0
    			|| convertedArgs[4] < 0 || convertedArgs[5] <0
    			|| convertedArgs[6] < 0 || convertedArgs[7] < 0
    			|| convertedArgs[0] > 10 || convertedArgs[1] > 10 //ArrivalProb and TurnProb cannot be larger than 10
    			|| convertedArgs[5] > convertedArgs[4] || convertedArgs[6] > convertedArgs[4]
    				
    			 ){
    	
    		
    		
    		System.out.println("Accepted input: integers a s d f g h j"
    				+ "Arrival probability (a out of 10)\n"
    				+ "Turn probability (s out of 10)\n "
   		+ "Lane length (d larger than 0)\n "
   		+ "Turn lane length (f larger than 0)\n "
   		+ "Traffic lights' period (g, shared) \n "
   		+ "Forward light green time (h out of period)"
   		+ "Turn light green time (j out of period)\n"
   				+ "Simulation timelength (i)\n");
    	
    	 }
    	
    	 else{
        TrafficSystem	trafficSys = new TrafficSystem(convertedArgs[0], 
        		convertedArgs[1], convertedArgs[2], 
        		convertedArgs[3], convertedArgs[4], 
        		convertedArgs[5], convertedArgs[6]
    		);
    
    
    
    // timeloop
    for(int i = 0; i < convertedArgs[7]; i++){
    	trafficSys.step();
    	trafficSys.print();
    }

    trafficSys.printStatistics();
	//...
    	 }
    }
}
