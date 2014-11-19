import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	CarPositionTest.class,
	LaneTest.class, 
	SimulationTest.class, 
	TrafficSystemTest.class,
	LightTest.class
	})


public class AllTests{
	}