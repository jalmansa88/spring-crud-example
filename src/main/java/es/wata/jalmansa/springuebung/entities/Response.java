package es.wata.jalmansa.springuebung.entities;

import java.util.List;

public class Response {
	private List<Mitarbeiter> mitarbeiter;
	private String message;

	public Response(List<Mitarbeiter> mitarbeiter, String msg) {
		super();
		this.mitarbeiter = mitarbeiter;
		this.message = msg;
	}

	public List<Mitarbeiter> getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(List<Mitarbeiter> mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
