package es.wata.jalmansa.springuebung.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.wata.jalmansa.springuebung.utils.ApiCodes;

public class ApiResponse {
	@JsonProperty("ApiContent")
	private List<Mitarbeiter> mitarbeiter;
	
	@JsonProperty("ApiResult")
	private CodeResponse codeResponse;
	
	public ApiResponse() {
		super();
		this.mitarbeiter = new ArrayList<>();
		this.codeResponse = new CodeResponse();
	}
	
	public ApiResponse(List<Mitarbeiter> mitarbeiter) {
		super();
		this.mitarbeiter = mitarbeiter;
		this.codeResponse = new CodeResponse();
	}
	
	public ApiResponse(ApiCodes apiCode) {
		super();
		this.mitarbeiter = new ArrayList<>();
		this.codeResponse = new CodeResponse(apiCode);
	}

	public ApiResponse(List<Mitarbeiter> mitarbeiter, ApiCodes apiCode) {
		super();
		this.mitarbeiter = mitarbeiter;
		this.codeResponse = new CodeResponse(apiCode);
	}

	public List<Mitarbeiter> getMitarbeiter() {
		return mitarbeiter;
	}

	public void setMitarbeiter(List<Mitarbeiter> mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}

	public CodeResponse getCodeResponse() {
		return codeResponse;
	}

	public void setCodeResponse(CodeResponse message) {
		this.codeResponse = message;
	}
}
