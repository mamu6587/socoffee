
public class Light {
    private int period;
    private int time;  // Internal clock: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signal is green when time<green 

    public Light(int period, int green) {
    	//...
    	this.period = period;
    	this.green = green;
    	}

    public void    step() {
    	if(this.time == this.period){
    		this.time = 0;
    	}
    	
    	else{
    	this.time++;
    	}
    	// Steps the clock one step
    }

    public boolean isGreen()   {
    	if(this.time < this.green){
    		return true;
    	}
    	else return false;
    	// Returns true if time<green, else false
    }

    public String  toString()  {

    	
    	
    	return " (greenTime/period = " +this.green + "/"
    				+ this.period + 
    				")";
    	
    	//...
    	}
	
}
