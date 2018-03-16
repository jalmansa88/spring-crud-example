package es.wata.jalmansa.springuebung.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.wata.jalmansa.springuebung.entities.Projekte;

@Repository
public interface ProjekteRepository extends JpaRepository<Projekte, Long>{
	public Optional<Projekte> findById(Long id);
}
