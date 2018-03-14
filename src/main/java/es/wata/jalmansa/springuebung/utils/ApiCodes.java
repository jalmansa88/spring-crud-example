package es.wata.jalmansa.springuebung.utils;

public enum ApiCodes {
	E700("Mitarbeiter nicht gefunden"), E701("Username schon benutzen"), E500("Fehler"), C100("created"), C101("found"), C102("deleted");

	private String message;

	ApiCodes(String msg) {
		this.message = msg;
	}

	public String getMessage() {
		return this.message;
	}
}
