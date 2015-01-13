import static org.junit.Assert.*;

import org.junit.Test;

public class TrafficSystemTest{
	
	public static class OverflowException extends RuntimeException{
		//private String message;
		
		public OverflowException(String s){
			super(s);
			}
		
		/*	public String getMessage(){
				return this.message;*/
		}
	
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
	

	
}
	

