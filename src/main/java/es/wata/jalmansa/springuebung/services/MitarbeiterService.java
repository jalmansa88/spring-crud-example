package es.wata.jalmansa.springuebung.services;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.wata.jalmansa.springuebung.entities.Mitarbeiter;
import es.wata.jalmansa.springuebung.exceptions.ServiceException;
import es.wata.jalmansa.springuebung.repositories.MitarbeiterRepository;

@Service
public class MitarbeiterService {

	private static final Logger LOG = LoggerFactory.getLogger(MitarbeiterService.class);

	private final String PATTERN = "Finding Mitarbeiter by {0} {1}";
	
	@Autowired
	private MitarbeiterRepository repo;

	public List<Mitarbeiter> getAll() {
		LOG.info("Finding all mitarbeiters in DB");
		return repo.findAll();
	}

	public Optional<Mitarbeiter> insert(Mitarbeiter mitarbeiter) throws ServiceException {
		LOG.info(MessageFormat.format("Saving Mitarbeiter in DB: {0}", mitarbeiter));
		if(getByUsername(mitarbeiter.getUsername()).isPresent())
			throw new ServiceException(1, "Mitarbeiter schon benutzen");
		
		return Optional.of(repo.save(mitarbeiter));
	}

	public Optional<Mitarbeiter> getById(Long id) {
		LOG.info(MessageFormat.format(PATTERN, "id", id));

		return repo.findById(id);
	}

	public Optional<Mitarbeiter> getByName(String name) {
		LOG.info(MessageFormat.format(PATTERN, "name", name));

		return repo.findByName(name);
	}
	public Optional<Mitarbeiter> getByUsername(String username) {
		LOG.info(MessageFormat.format(PATTERN, "username", username));
		
		return repo.findByUsername(username);
	}
	
	public void delete(String username) throws ServiceException {
		LOG.info("Removing Mitarbeiter " + username + " from Database");
		
		if(!getByUsername(username).isPresent())
			throw new ServiceException(10, "Username does no exist!");
		
		
		repo.removeByUsername(username);
	}

}
