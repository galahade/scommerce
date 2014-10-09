package com.salmon.scommerce.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.salmon.scommerce.core.services.UserService;
import com.salmon.scommerce.core.services.handlers.MockedUserServiceHandler;
import com.salmon.scommerce.security.shiro.PasswordHelper;

@Configuration
public class CoreConfig {
	
	@Inject PasswordHelper passwordHelper;
	
	@Bean
	public UserService userService() {
		return new MockedUserServiceHandler(passwordHelper);
	}

}
