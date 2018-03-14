package es.wata.jalmansa.springuebung.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import es.wata.jalmansa.springuebung.utils.ApiCodes;

@JsonInclude(Include.NON_NULL)
public class CodeResponse {
	
	@JsonProperty("ApiCode")
	private ApiCodes apiCode;

	@JsonProperty("shortMessage")
	private String message;

	public CodeResponse() {
		super();
	}

	public CodeResponse(ApiCodes apiCode) {
		super();
		this.apiCode = apiCode;
		this.message = apiCode.getMessage();
	}

	public ApiCodes getApiCode() {
		return apiCode;
	}

	public void setApiCode(ApiCodes apiCode) {
		this.apiCode = apiCode;
	}

	public String getMessage() {
		return message;
	}

}
