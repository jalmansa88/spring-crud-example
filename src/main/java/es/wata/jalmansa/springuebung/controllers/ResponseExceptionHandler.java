package es.wata.jalmansa.springuebung.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import es.wata.jalmansa.springuebung.entities.ErrorResponse;
import es.wata.jalmansa.springuebung.entities.Response;
import es.wata.jalmansa.springuebung.utils.ApiErrorCodes;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
	protected ResponseEntity<Response> handleException(Exception e) {

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new Response(new ArrayList<>(), new ErrorResponse(ApiErrorCodes.E500)));
	}
}
