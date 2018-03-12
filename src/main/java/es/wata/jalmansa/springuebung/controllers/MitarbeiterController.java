package es.wata.jalmansa.springuebung.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.wata.jalmansa.springuebung.entities.Mitarbeiter;
import es.wata.jalmansa.springuebung.impl.MitarbeiterService;

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
	public ResponseEntity<Mitarbeiter> getById(@PathVariable Long id) {
		Optional<Mitarbeiter> optional = service.getById(id);
		if(!optional.isPresent())
			return ResponseEntity.noContent().build();
		
		return new ResponseEntity<Mitarbeiter>(optional.get(), HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Mitarbeiter> getByName(@PathVariable String name){
		Optional<Mitarbeiter> optional = service.getByName(name);
		if(!optional.isPresent())
			return ResponseEntity.noContent().build();
		
		return new ResponseEntity<Mitarbeiter>(optional.get(), HttpStatus.OK);
	}

}
