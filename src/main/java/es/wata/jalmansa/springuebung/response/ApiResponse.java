package es.wata.jalmansa.springuebung.response;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.wata.jalmansa.springuebung.utils.ApiCodes;

public class ApiResponse {
	@JsonProperty("ApiContent")
	private List<?> content;
	
	@JsonProperty("ApiResult")
	private CodeResponse codeResponse;
	
	public ApiResponse() {
		super();
		this.content = new ArrayList<>();
		this.codeResponse = new CodeResponse();
	}
	
	public ApiResponse(List<?> content) {
		super();
		this.content = content;
		this.codeResponse = new CodeResponse();
	}
	
	public ApiResponse(ApiCodes apiCode) {
		super();
		this.content = new ArrayList<>();
		this.codeResponse = new CodeResponse(apiCode);
	}

	public ApiResponse(List<?> mitarbeiter, ApiCodes apiCode) {
		super();
		this.content = mitarbeiter;
		this.codeResponse = new CodeResponse(apiCode);
	}

	public List<?> getContent() {
		return content;
	}

	public void setConten(List<?> content) {
		this.content = content;
	}

	public CodeResponse getCodeResponse() {
		return codeResponse;
	}

	public void setCodeResponse(CodeResponse message) {
		this.codeResponse = message;
	}
}
