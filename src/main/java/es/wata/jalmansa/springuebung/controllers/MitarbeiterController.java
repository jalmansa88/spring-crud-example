package es.wata.jalmansa.springuebung.controllers;

import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.wata.jalmansa.springuebung.entities.ApiResponse;
import es.wata.jalmansa.springuebung.entities.Mitarbeiter;
import es.wata.jalmansa.springuebung.exceptions.MitarbeiterServiceException;
import es.wata.jalmansa.springuebung.impl.MitarbeiterService;
import es.wata.jalmansa.springuebung.utils.ApiCodes;

@RestController
@RequestMapping("/mitarbeiter")
public class MitarbeiterController {

	private static final Logger LOG = LoggerFactory.getLogger(MitarbeiterController.class);

	@Autowired
	private MitarbeiterService service;

	@GetMapping("/all")
	public ResponseEntity<ApiResponse> all() {
		return ResponseEntity.ok(new ApiResponse(service.getAll(), ApiCodes.C101));
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<ApiResponse> getById(@PathVariable Long id) {
		Optional<Mitarbeiter> optional = service.getById(id);

		if (!optional.isPresent()) {
			LOG.info("error finding in DB");
			return ResponseEntity.ok(new ApiResponse(ApiCodes.E700));
		}

		return ResponseEntity.ok(new ApiResponse(Arrays.asList(optional.get()), ApiCodes.C101));
	}

	@GetMapping("/username/{username}")
	public ResponseEntity<ApiResponse> getByName(@PathVariable String username) {
		Optional<Mitarbeiter> optional = service.getByUsername(username);

		if (!optional.isPresent()) {
			LOG.info("nicht gefunden");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse(ApiCodes.E700));
		}

		return ResponseEntity.ok(new ApiResponse(Arrays.asList(optional.get()), ApiCodes.C101));
	}

	@PostMapping("/create")
	public ResponseEntity<ApiResponse> addMitarbetier(@RequestBody Mitarbeiter newMitarbeiter) throws Exception {
		Mitarbeiter added = new Mitarbeiter();

		try {
			added = service.insert(newMitarbeiter).orElse(null);
		} catch (MitarbeiterServiceException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(ApiCodes.E701));
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(Arrays.asList(added), ApiCodes.C100));
	}

	@DeleteMapping("/delete/{username}")
	public ResponseEntity<ApiResponse> deleteMitarbeiter(@PathVariable String username) {

		try {
			service.delete(username);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(ApiCodes.E700));
		}

		return ResponseEntity.ok(new ApiResponse(ApiCodes.C102));
	}

}
