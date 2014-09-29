package com.salmon.scommerce.config;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ShiroConfig {
	
	@Bean
	public ShiroFilterFactoryBean shiroFilter() {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager());
		bean.setLoginUrl("/login");
		return null;
	}
	
	@Bean
	public SecurityManager securityManager() {
		DefaultSecurityManager manager = new DefaultSecurityManager();
		manager.setRealm(null);
		return manager;
	}
	
	@Bean
	public  LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		LifecycleBeanPostProcessor processor = new LifecycleBeanPostProcessor();
		return processor;
	}

}
