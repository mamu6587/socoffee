


public class OverflowException extends RuntimeException {
	private String message;
	
	public OverflowException(String s){
		this.message = s;
		
	}

	public String getMessage(){
		return this.message;
	}

    }


