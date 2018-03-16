package es.wata.jalmansa.springuebung.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.wata.jalmansa.springuebung.entities.Mitarbeiter;
import es.wata.jalmansa.springuebung.exceptions.ServiceException;
import es.wata.jalmansa.springuebung.response.ApiResponse;
import es.wata.jalmansa.springuebung.services.ProjekteService;
import es.wata.jalmansa.springuebung.utils.ApiCodes;

@Controller
@RequestMapping("/projekte")
public class ProjekteController {

	private static final Logger LOG = LoggerFactory.getLogger(ProjekteController.class);

	@Autowired
	private ProjekteService service;

	@GetMapping("/all")
	public ResponseEntity<ApiResponse> all() {
		return ResponseEntity.ok(new ApiResponse(service.getAll(), ApiCodes.C101));
	}

	@GetMapping("/{projektId}/mitarbeiter")
	public ResponseEntity<ApiResponse> getMitarbeiters(@PathVariable Long projektId) {
		List<Mitarbeiter> mitarbeiter = new ArrayList<>();

		try {
			mitarbeiter = service.getMitarbeiter(projektId);
		} catch (ServiceException e) {
			LOG.warn("Projekt Id " + projektId + " nicht gefunden");
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(ApiCodes.E710));
		}

		return ResponseEntity.ok(new ApiResponse(mitarbeiter, ApiCodes.C101));
	}
}
