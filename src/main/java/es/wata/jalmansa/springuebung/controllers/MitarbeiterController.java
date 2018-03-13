package es.wata.jalmansa.springuebung.controllers;

import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.wata.jalmansa.springuebung.entities.ErrorResponse;
import es.wata.jalmansa.springuebung.entities.Mitarbeiter;
import es.wata.jalmansa.springuebung.entities.Response;
import es.wata.jalmansa.springuebung.impl.MitarbeiterService;
import es.wata.jalmansa.springuebung.utils.ApiErrorCodes;

@RestController
@RequestMapping("/mitarbeiter")
public class MitarbeiterController {

	private static final Logger LOG = LoggerFactory.getLogger(MitarbeiterController.class);

	@Autowired
	private MitarbeiterService service;

	@GetMapping("/all")
	public ResponseEntity<Response> all() {
		return ResponseEntity.ok(new Response(service.getAll()));
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Response> getById(@PathVariable Long id) {
		Optional<Mitarbeiter> optional = service.getById(id);

		if (!optional.isPresent()) {
			LOG.info("error finding in DB");
			return ResponseEntity.ok(new Response(new ErrorResponse(ApiErrorCodes.E100)));
		}

		return ResponseEntity.ok(new Response(Arrays.asList(optional.get())));
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Response> getByName(@PathVariable String name) {
		Optional<Mitarbeiter> optional = service.getByName(name);

		if (!optional.isPresent()) {
			LOG.info("nicht gefunden");
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
					.body(new Response(new ErrorResponse(ApiErrorCodes.E100)));
		}

		return ResponseEntity.ok(new Response(Arrays.asList(optional.get())));
	}

	@PostMapping("/create")
	public ResponseEntity<Response> addMitarbetier(@RequestBody Mitarbeiter newMitarbeiter) {
		Mitarbeiter added = new Mitarbeiter();
		
		try{
			added = service.insert(newMitarbeiter).orElse(null);
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new Response(new ErrorResponse(ApiErrorCodes.E200)));
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(new Response(Arrays.asList(added)));
	}

}
