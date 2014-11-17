
public class Light {
    private int period;
    private int time;  // Internal clock: 0, 1, ... period-1, 0, 1 ...
    private int green; // Signal is green when time<green 
     /**
     * Creates a light with a green time and a period.
     *
     * @param period The period of this light.
     * @param green The time out of the period the light should be green.
     */
    public Light(int period, int green) {
    	//...
    	this.period = period;
    	this.green = green;
    	}
     /**
     * Steps the light one time unit
     *
     */
    public void    step() {
    	if(this.time == this.period){
    		this.time = 0;
    	}
    	
    	else{
    	this.time++;
    	}
    	// Steps the clock one step
    }
     /**
     * Checks if the light is green.  
     *
     * @return true if it is green, else false
     */

    public boolean isGreen()   {
    	if(this.time < this.green){
    		return true;
    	}
    	else return false;
    	// Returns true if time<green, else false
    }
     /**
     * Returns an ASCII representation of the light
     *
     * @return G if the light is green, else R
     */
    public String  toString()  {
    	if(this.isGreen()){
    		return "{G";
    	}
    	return  "{R";

    	
    	}
	
}
