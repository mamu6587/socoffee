// att testa: putlast, getfirst, toString,
public class LaneTest{


@test
public void constructorBuildsCorrectly (){
    
    Lane testLane = new Lane(6);
    for(int i = 5; i > 0; i--){
	assertTrue("Carpositions not forwardlinked", testLane.theLane[i].getForward() == testLane.theLane[i-1]);
    }
}

@test
public void laneTest(){ //check that car/carposition references are updated correctly,
    Lane testLane = new Lane(4);
    Car car = new Car(0,null,null);
    Car car2 = new Car(0,null,null);
    testLane.putLast(car);
    testLane.step();
    testLane.putLast(car2);
    assertNull("Getfirst didn't return null on empty spot", testLane.getFirst());

    
    assertTrue("Car 1 isn't in spot 3", testLane.theLane[2].getCar() == car);
    assertTrue("Car 2 isn't in spot 4", testLane.theLane[3].getCar() == car2);
    testLane.step();

    assertNull("Last place isn't empty" testLane.theLane[3].getCar());
    assertTrue("Cars currentposition isn't updated", car2.getPosition() == testLane.theLane[3]);
    assertTrue("Cars currentposition isn't updated", car1.getPosition() == testLane.theLane[2]);
    assertTrue("Carposition 2's currentcar isn't updated", testLane.theLane[2].getCar() == car);	
    	
    		
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

@test(expected = OverflowException.Lane)
public void tooManyCarsShouldOverflow(){
    Lane testLane = new Lane(2);
    Car car = new Car(0,null,null);
    Car car2 = new Car(0,null,null);
    testLane.putLast(car);
    testLane.putLast(car2);
}

}
