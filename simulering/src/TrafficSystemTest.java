import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TrafficSystemTest{
	
	@Test
	public void carsShouldForwardAndExit(){
		
		//to test that cars that run forward are inserted and run
		TrafficSystem testSystem = new TrafficSystem(10,0,3,3,3,3,3);
		for(int i = 0; i < 20; i++){
		testSystem.step();
		}
		
	}
	@Test
	public void carsShouldTurnAndExit(){
		//to test that that cars that run the turnlane are inserted and run forward
		TrafficSystem testSystem2 = new TrafficSystem(10,10,3,3,3,3,3);
		for(int i = 0; i < 20; i++){
		testSystem2.step();	
		} 		
	}
	/*
	@Test(expected = OverflowException.class)
	public void carsShouldTurnAndOverflow(){
		//to test that cars can run turnlane, be blocked and overflow
		TrafficSystem testSystem3 = new TrafficSystem(10,10,3,3,0,3,0);
		for(int i = 0; i < 20; i++){
		testSystem3.step();
		}
	}
	
	@Test(expected = OverflowException.class)
	public void carsShouldForwardAndOverflow(){
		//to test that cars can run forward, be blocked and overflow
		TrafficSystem testSystem4 = new TrafficSystem(10,0,3,3,0,0,3);
		for(int i = 0; i < 20; i++){
		testSystem4.step();
		}
	}
	*/
}
