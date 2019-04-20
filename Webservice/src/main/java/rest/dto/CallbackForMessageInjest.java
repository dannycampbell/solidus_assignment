package rest.dto;

public class CallbackForMessageInjest {

	private String digest;
	
	public CallbackForMessageInjest( String digest) {
		this.digest=digest;
		
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}
	
}
