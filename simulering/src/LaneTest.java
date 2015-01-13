import static org.junit.Assert.*;

import org.junit.Test;


public class LaneTest {

		@Test
		public void constructorBuildsCorrectly (){
		    
		    Lane testLane = new Lane(6);
		    for(int i = 5; i > 0; i--){
			assertTrue("Carpositions not forwardlinked", testLane.theLane[i].getForward() == testLane.theLane[i-1]);
		    }
		}

		@Test
		public void laneTest(){ //check that car/carposition references are updated correctly,
		    Lane testLane = new Lane(4);
		    Car car = new Car(0,testLane.theLane[3],false);
		    Car car2 = new Car(0,testLane.theLane[3],false);
		    testLane.putLast(car);
		    testLane.step();
		    testLane.putLast(car2);
		    
		    assertNull("Getfirst didn't return null on empty spot", testLane.getFirst());
		    
		    assertTrue("Car 1 isn't in spot 3", testLane.theLane[2].getCar() == car);
		    assertTrue("Car 2 isn't in spot 4", testLane.theLane[3].getCar() == car2);
		    testLane.step();

		    assertNull("Last place isn't empty", testLane.theLane[3].getCar());
		    System.out.println("carposition: "+car.getPosition()+  " thelane: " +  testLane.theLane+ " " + testLane.theLane[3].getCar() + " ");
		    
		    		
		    assertTrue("Car 1 isn't in spot 2", testLane.theLane[1].getCar() == car);
		    assertTrue("Car 2 isn't in spot 3", testLane.theLane[2].getCar() == car2);	
		    testLane.step();
		    
		    //check that theLane[0] isn't stepped, somehow.
		    assertTrue("Car 1 isn't in spot 1", testLane.theLane[0].getCar() == car);
		    assertTrue("Car 2 isn't in spot 2", testLane.theLane[1].getCar() == car2);	
		    testLane.step();

		    assertTrue("Car 1 isn't in spot 1", testLane.theLane[0].getCar() == car);
		    assertTrue("Car 2 isn't in spot 2", testLane.theLane[1].getCar() == car2);

		    assertNotNull("getFirst didn't return car correctly",testLane.getFirst());
		    testLane.step();
		    assertNotNull("getFirst didn't return car2 correctly",testLane.getFirst());
		}


    @Test
    public void everythingKnowsItsPlace(){
        Lane testLane = new Lane(4);    
        Car car = new Car(0,null,false); 
        Car car1 = new Car(0,null,false); 
        Car car2 = new Car(0,null,false); 
        Car car3 = new Car(0,null,false); 
        testLane.putLast(car);
        testLane.step();
        testLane.putLast(car1);
        testLane.step();
        testLane.putLast(car2);
        testLane.step();
        testLane.putLast(car3);
       
        assertTrue("CarPos1 and Car1 aren't mutually linked",car1.getPosition().getCar() == car1);
        assertTrue("CarPos2 and Car2 aren't mutually linked",car2.getPosition().getCar() == car2);
        assertTrue("CarPos3 and Car3 aren't mutually linked",car3.getPosition().getCar() == car3);
        assertTrue("CarPos0 and Car aren't mutually linked",car.getPosition().getCar() == car);
    }
}

