package rest.dto;

public class CallbackForMessageRetrieval {

	private String message;
	
	public CallbackForMessageRetrieval( String data) {
		this.message=data;
		
	}

	public String getData() {
		return message;
	}

	public void setData(String data) {
		this.message = data;
	}
	
}
