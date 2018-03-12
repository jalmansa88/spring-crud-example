package es.wata.jalmansa.springuebung.utils;

public enum HttpMessages {
	CREATED("created"), FOUND("found"), NOT_FOUND("not found"), ERROR_OCCURRED("an error occurred");
	
	private String message;
	
	HttpMessages(String msg){
		this.message = msg;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	@Override
	public String toString() {
		return this.message;
	}
}
