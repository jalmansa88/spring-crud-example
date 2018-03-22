package es.wata.jalmansa.springuebung;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
@EnableJpaRepositories
@ComponentScan("es.wata.jalmansa.springuebung")
public class ApplicationContextForTests {

	@Bean
	@Profile("test")
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE");
		dataSource.setUsername("sa");
		dataSource.setPassword("");

		// schema init
		Resource initSchema = new ClassPathResource("schema.sql");
		Resource initData = new ClassPathResource("data.sql");
		DatabasePopulator databasePopulator = new ResourceDatabasePopulator(initSchema, initData);
		DatabasePopulatorUtils.execute(databasePopulator, dataSource);

		return dataSource;
	}
//
//	@Bean
//	ServletRegistrationBean<WebServlet> h2servletRegistration() {
//		ServletRegistrationBean<WebServlet> registrationBean = new ServletRegistrationBean<WebServlet>(new WebServlet());
//		registrationBean.addUrlMappings("/h2-console/*");
//		return registrationBean;
//	}
}
