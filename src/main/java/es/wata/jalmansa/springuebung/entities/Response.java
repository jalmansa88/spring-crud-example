package es.wata.jalmansa.springuebung.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {
	@JsonProperty("content")
	private List<Mitarbeiter> mitarbeiter;

	private ErrorResponse errorResponse;

	public Response(List<Mitarbeiter> mitarbeiter) {
		super();
		this.mitarbeiter = mitarbeiter;
		this.errorResponse = new ErrorResponse();
	}
	
	public Response(ErrorResponse errorResponse) {
		super();
		this.mitarbeiter = new ArrayList<>();
		this.errorResponse = errorResponse;
	}

	public Response(List<Mitarbeiter> mitarbeiter, ErrorResponse errorResponse) {
		super();
		this.mitarbeiter = mitarbeiter;
		this.errorResponse = errorResponse;
	}

	public List<Mitarbeiter> getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(List<Mitarbeiter> mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	public ErrorResponse getErrorResponse() {
		return errorResponse;
	}

	public void setErrorResponse(ErrorResponse message) {
		this.errorResponse = message;
	}
}
