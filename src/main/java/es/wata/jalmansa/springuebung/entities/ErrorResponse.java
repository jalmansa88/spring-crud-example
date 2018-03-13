package es.wata.jalmansa.springuebung.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import es.wata.jalmansa.springuebung.utils.ApiErrorCodes;

@JsonInclude(Include.NON_NULL)
public class ErrorResponse {

	private ApiErrorCodes errorCode;

	@JsonProperty("shortMessage")
	private String message;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(ApiErrorCodes errorCode) {
		super();
		this.errorCode = errorCode;
		this.message = errorCode.getErrorMessage();
	}

	public ApiErrorCodes getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ApiErrorCodes errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

}
