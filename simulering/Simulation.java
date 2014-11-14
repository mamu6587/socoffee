public class Simulation {

    public static void main(String [] args) {
    	
    	
    	
    	
    	
    	//error if input invalid
    	if(args.length != 8){
		System.out.println ("Accepted input: Arrival probability,\n" +
				 "Turn probability,\n  "
		+ "Lane length,\n "
		+ "Turn lane length,\n "
		+ "Simulation timelength,\n"
		+ "Traffic light specs,\n "
		+ "Turn light specs\n" );
    	}
	// Creates a TrafficSystem
	// Performs the stepping, calls printing methods
   
        // args will contain, in order :
    	
        // int arrivalProb, int turnProb, 
        // int lengthTurn, int lengthStart, 
        // int period, int green1, int green2 
    	// and args[7] = how many steps the simulation should have
    	
    	//add: validera indata
    	//aP & tP > 0, <= 10
    	// lT & lS > 0
    	//period >= 0
    	//green1 & 2 >= 0, <= period 
    	
    	//dokumentation med JavaDoc
    	//makefil med tester
    	//readme.md med:
    	//how to build
    	//how to run
    	//a list with all the goals that has been met with this program
    	//lists all additions
    	//other useful info
    	
    	//enhetstester
    	
    	


    	else{
        TrafficSystem	trafficSys = new TrafficSystem(Integer.parseInt(args[0]), 
    		Integer.parseInt(args[1]), Integer.parseInt(args[2]), 
    		Integer.parseInt(args[3]), Integer.parseInt(args[4]), 
    		Integer.parseInt(args[5]), Integer.parseInt(args[6])
    		);
    
    
    
    // timeloop
    for(int i = 0; i < Integer.parseInt(args[7]); i++){
    	trafficSys.step();
    	trafficSys.print();
    }

    trafficSys.printStatistics();
	//...
    	}
    }
}
