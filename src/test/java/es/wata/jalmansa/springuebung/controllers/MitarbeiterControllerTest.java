package es.wata.jalmansa.springuebung.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import es.wata.jalmansa.springuebung.ApplicationConfigurationContext;
import es.wata.jalmansa.springuebung.impl.MitarbeiterService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfigurationContext.class)
@SpringBootTest
public class MitarbeiterControllerTest {

	private static final String BASE = "/mitarbeiter";

	@Autowired
	private WebApplicationContext context;

	@Mock
	private MitarbeiterService mitarbeiterService;

	@InjectMocks
	private MitarbeiterController mitarbeiterController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
//		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void contexLoads() throws Exception {
		assertThat(mitarbeiterController).isNotNull();
	}

	@Test
	public void testAll() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		mockMvc.perform(get("/mitarbeiter/all")).andExpect(status().isOk());
	}

	@Test
	public void testGetById() {
	}

	@Test
	public void testGetByName() {
	}

	@Test
	public void testAddMitarbetier() {
	}

	@Test
	public void testDeleteMitarbeiter() {
	}

}
