package es.wata.jalmansa.springuebung.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.wata.jalmansa.springuebung.entities.Mitarbeiter;
import es.wata.jalmansa.springuebung.entities.Projekte;
import es.wata.jalmansa.springuebung.exceptions.ServiceException;
import es.wata.jalmansa.springuebung.repositories.ProjekteRepository;

@Service
public class ProjekteService {

	private static final Logger LOG = LoggerFactory.getLogger(ProjekteService.class);

	@Autowired
	private ProjekteRepository repo;

	public List<Projekte> getAll() {
		LOG.info("finding all Projekte");
		return repo.findAll();
	}

	public List<Mitarbeiter> getMitarbeiter(Long projektId) throws ServiceException {
		Optional<Projekte> opt = repo.findById(projektId);

		if (!opt.isPresent()) {
			LOG.warn("Projekt Id " + projektId + " not found");
			throw new ServiceException(20, "Projekt Id " + projektId + " not found");
		}

		return opt.get().getMitarbeiterList();
	}
}
