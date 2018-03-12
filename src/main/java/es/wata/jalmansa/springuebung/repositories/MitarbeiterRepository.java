package es.wata.jalmansa.springuebung.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.wata.jalmansa.springuebung.entities.Mitarbeiter;

@Repository
public interface MitarbeiterRepository extends JpaRepository<Mitarbeiter, Long> {
	Optional<Mitarbeiter> findByAge(Integer age);

	Optional<Mitarbeiter> findByUsername(String username);

	Optional<Mitarbeiter> findByName(String name);

	Optional<Mitarbeiter> findById(Long id);
}
