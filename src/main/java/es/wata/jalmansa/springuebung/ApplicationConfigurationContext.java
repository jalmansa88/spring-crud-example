package es.wata.jalmansa.springuebung;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import es.wata.jalmansa.springuebung.entities.Mitarbeiter;
import es.wata.jalmansa.springuebung.impl.MitarbeiterService;

@Configuration
@ComponentScan("es.wata.jalmansa.springuebung")
public class ApplicationConfigurationContext {

	private static final Logger LOG = LoggerFactory.getLogger(ApplicationConfigurationContext.class);

	@Bean
	public CommandLineRunner demoBean(MitarbeiterService service) {

		return (args) -> {
			LOG.info("*********************");
			LOG.info("**** DEMO - INIT ****");

			// service.insert(new Mitarbeiter("paco", "francisco", 32));

			List<Mitarbeiter> arbeiterList = service.getAll();

			arbeiterList.forEach(a -> LOG.info(
					MessageFormat.format("{0}, username: {1}, age {2}", a.getName(), a.getUsername(), a.getAge())));

			Optional<Mitarbeiter> mitarbeiterOpt2 = service.getById(2L);
			Optional<Mitarbeiter> mitarbeiterOpt5 = service.getById(5L);

			LOG.info("Mitarbeiter con ID 2 es " + mitarbeiterOpt2.orElse(null));
			LOG.info("Mitarbeiter con ID 5 es " + mitarbeiterOpt5.orElse(null));
			arbeiterList.stream().filter(a -> a.getAge() > 27)
					.forEach(a -> LOG.info("Mitarbeiters con edad > 27: " + a.getName()));

			LOG.info("**** DEMO - END *****");
			LOG.info("*********************");
		};
	}

}
