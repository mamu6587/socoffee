
public class Light {
    private int period;
    private int time;  // Intern klocka: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signalen grön när time<green 

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
    	// Stegar fram klocka ett steg
    }

    public boolean isGreen()   {
    	if(this.time < this.green){
    		return true;
    	}
    	else return false;
    	// Returnerar true om time<green, annars false
    }

    public String  toString()  {
    	return "sak";
    	
    	/*
    	return "Light(period = " +this.period + 
    				"time = " +this.time + 
    				"green =  "+ this.green +")";
    	*/
    	//...
    	}
	
}