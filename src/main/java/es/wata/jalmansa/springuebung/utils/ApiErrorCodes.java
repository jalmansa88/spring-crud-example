package es.wata.jalmansa.springuebung.utils;

public enum ApiErrorCodes {
	E100("Mitarbeiter nicht gefunden"), E200("Username schon benutzen"), E500("Fehler");

	private String errorMessage;

	ApiErrorCodes(String msg) {
		this.errorMessage = msg;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}
}
