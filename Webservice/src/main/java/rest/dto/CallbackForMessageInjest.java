package rest.dto;

public class CallbackForMessageInjest {

	private String digest;
	
	public CallbackForMessageInjest( String data) {
		this.digest=data;
		
	}

	public String getData() {
		return digest;
	}

	public void setData(String data) {
		this.digest = data;
	}
	
}
