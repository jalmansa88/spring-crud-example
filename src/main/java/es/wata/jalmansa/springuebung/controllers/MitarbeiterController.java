package es.wata.jalmansa.springuebung.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.wata.jalmansa.springuebung.entities.Mitarbeiter;
import es.wata.jalmansa.springuebung.entities.Response;
import es.wata.jalmansa.springuebung.impl.MitarbeiterService;
import es.wata.jalmansa.springuebung.utils.HttpMessages;

@RestController
@RequestMapping("/mitarbeiter")
public class MitarbeiterController {

	@Autowired
	private MitarbeiterService service;

	@GetMapping("/all")
	public List<Mitarbeiter> all() {
		return service.getAll();
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<Response> getById(@PathVariable Long id) {
		Optional<Mitarbeiter> optional = service.getById(id);

		if (!optional.isPresent())
			return ResponseEntity.noContent().build();

		return ResponseEntity.ok(new Response(Arrays.asList(optional.get()), HttpMessages.FOUND.getMessage()));
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Response> getByName(@PathVariable String name) {
		Optional<Mitarbeiter> optional = service.getByName(name);

		if (!optional.isPresent())
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
					.body(new Response(new ArrayList<>(), HttpMessages.NOT_FOUND.getMessage()));

		return ResponseEntity.ok(new Response(Arrays.asList(optional.get()), HttpMessages.FOUND.toString()));
	}

	@PostMapping("/create")
	public ResponseEntity<Response> addMitarbetier(@RequestBody Mitarbeiter newMitarbeiter) {
		Mitarbeiter added = service.insert(newMitarbeiter).orElse(null);

		return ResponseEntity.ok(new Response(Arrays.asList(added), HttpMessages.CREATED.getMessage()));
	}

}
