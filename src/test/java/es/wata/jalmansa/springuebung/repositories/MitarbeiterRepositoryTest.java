package es.wata.jalmansa.springuebung.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import es.wata.jalmansa.springuebung.ApplicationContextForTests;
import es.wata.jalmansa.springuebung.entities.Mitarbeiter;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest(classes = { ApplicationContextForTests.class })
@TestPropertySource("classpath:application.properties")
@ActiveProfiles("test")
public class MitarbeiterRepositoryTest {

	@Autowired
	private MitarbeiterRepository mitarbeiterRepo;

	@Test
	public void repoTest() {
		
		List<Mitarbeiter> mitarbeiterList = mitarbeiterRepo.findAll();
		assertNotNull(mitarbeiterList);
		assertNotEquals(0, mitarbeiterList.size());
		
		Mitarbeiter mitarbeiterToSave = new Mitarbeiter();
		mitarbeiterToSave.setId(100L);
		mitarbeiterToSave.setName("testname");
		mitarbeiterToSave.setUsername("testusername");
		mitarbeiterToSave.setAge(30);

		Mitarbeiter mitarbeiterSaved = mitarbeiterRepo.save(mitarbeiterToSave);
		assertNotNull(mitarbeiterSaved);

		Mitarbeiter foundMitarbeiter = mitarbeiterRepo.getOne(mitarbeiterSaved.getId());

		assertNotNull(foundMitarbeiter);
		assertEquals("testname", foundMitarbeiter.getName());
	}

}
