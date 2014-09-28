package com.salmon.scommerce.config;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:/com/salmon/properties/database.properties")
public class DataSourceConfig {
	
	private Logger LOG = LoggerFactory.getLogger(this.getClass()); 
	
	@Inject
	Environment evn;
	
	@Bean
	public DriverManagerDataSource dataSource() {
		
		LOG.debug("driver is :" + evn.getProperty("mysql.driver"));
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(evn.getProperty("mysql.driver"));
		dataSource.setUrl(evn.getProperty("mysql.url"));
		dataSource.setUsername(evn.getProperty("mysql.username"));
		dataSource.setPassword(evn.getProperty("mysql.password"));
		
		return dataSource;
	}
	
	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
