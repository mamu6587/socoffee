public class TrafficSystemTest{
	
	
	@before
	//to test that cars that run forward are inserted and run
	TrafficSystem testSystem = new TrafficSystem(10,0,3,3,3,3,3);
	//to test that that cars that run the turnlane are inserted and run forward
	TrafficSystem testSystem2 = new TrafficSystem(10,10,3,3,3,3,3);
	//to test that cars can run turnlane, be blocked and overflow
	TrafficSystem testSystem3 = new TrafficSystem(10,10,3,3,0,3,0);
	//to test that cars can run forward, be blocked and overflow
	TrafficSystem testSystem4 = new TrafficSystem(10,0,3,3,0,0,3);
	
	@test
	public void carsShouldForwardAndExit(){
		for(int i = 0; i < 20; i++){
		TrafficSystem.step();
		}
	}
	@test
	public void carsShouldTurnAndExit(){
		for(int i = 0; i < 20; i++){
		TrafficSystem2.step();	
		} 		
	}
	
	@test(expected = OverFlowException)
	public void carsShouldTurnAndOverflow(){
		for(int i = 0; i < 20; i++){
		TrafficSystem3.step();
		}
	}
	
	@test(expected = OverFlowException)
	public void carsShouldForwardAndOverflow(){
		for(int i = 0; i < 20; i++){
		TrafficSystem4.step();
		}
	}
}