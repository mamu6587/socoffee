public class Simulation {

    public static void main(String [] args) {
	// Creates a TrafficSystem
	// Performs the stepping, calls printing methods
   
        // args will contain, in order :
    	
        // int arrivalProb, int turnProb, 
        // int lengthTurn, int lengthStart, 
        // int period, int green 

    	// add args[6] = s2 greentime
    	// and args[7] = how many steps the simulation should have


        TrafficSystem	trafficSys = new TrafficSystem(Integer.parseInt(args[0]), 
    		Integer.parseInt(args[1]), Integer.parseInt(args[2]), 
    		Integer.parseInt(args[3]), Integer.parseInt(args[4]), 
    		Integer.parseInt(args[5])
    		);
    
    
    
    // timeloop
    for(int i = 0; i < Integer.parseInt(args[6]); i++){
    	trafficSys.step();
    	trafficSys.print();
    }

    trafficSys.printStatistics();
	//...

    }
}
