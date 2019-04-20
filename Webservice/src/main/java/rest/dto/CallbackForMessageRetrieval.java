package rest.dto;

public class CallbackForMessageRetrieval {

	private String message;
	
	public CallbackForMessageRetrieval( String message) {
		this.message=message;
		
	}

	public String getMessage() {
		return message;
	}

	public void setData(String message) {
		this.message = message;
	}
	
}
