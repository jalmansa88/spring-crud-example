package es.wata.jalmansa.springuebung;

import java.text.MessageFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.wata.jalmansa.springuebung.entities.Mitarbeiter;
import es.wata.jalmansa.springuebung.repositories.MitarbeiterRepository;

@Configuration
public class Demo {

	private static final Logger LOG = LoggerFactory.getLogger(Demo.class);

//	@Bean
//	public CommandLineRunner demo(MitarbeiterRepository repo) {
//		LOG.info("Demo INIT");
//		return (args) -> {
//			List<Mitarbeiter> arbeiterList = (List<Mitarbeiter>) repo.findAll();
//
//			arbeiterList.forEach(a -> LOG.info(
//					MessageFormat.format("{0}, username: {1}, age {2}", a.getName(), a.getUsername(), a.getAge())));
//		};
//	}

}
