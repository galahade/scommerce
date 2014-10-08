package com.salmon.scommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.salmon.scommerce.core.services.UserService;
import com.salmon.scommerce.core.services.handlers.MockedUserServiceHandler;

@Configuration
public class CoreConfig {
	
	@Bean
	public UserService userService() {
		return new MockedUserServiceHandler();
	}

}
