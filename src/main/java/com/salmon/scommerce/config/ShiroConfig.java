package com.salmon.scommerce.config;

import javax.inject.Inject;

import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;

import com.salmon.scommerce.core.services.UserService;
import com.salmon.scommerce.security.shiro.PasswordHelper;
import com.salmon.scommerce.security.shiro.UserRealm;

@Configuration
@Import(CoreConfig.class)
public class ShiroConfig {
	
	@Inject UserService userService;
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager);
		bean.setLoginUrl("/login");
		bean.setSuccessUrl("/home");
		bean.setUnauthorizedUrl("/unauthorized");
		//bean.setFilterChainDefinitions(" /admin/** = authc, roles[admin]/docs/** = authc, perms[document:read]/** = authc");
		return bean;
	}
	
	@Bean
	public SecurityManager securityManager(Realm userRealm) {
		DefaultSecurityManager securityManager = new DefaultSecurityManager();
		
		//…Ë÷√authenticator  
		ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();  
		authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy()); 
		securityManager.setAuthenticator(authenticator);
		
		//…Ë÷√authorizer  
		ModularRealmAuthorizer authorizer = new ModularRealmAuthorizer();  
		authorizer.setPermissionResolver(new WildcardPermissionResolver());  
		securityManager.setAuthorizer(authorizer); 
		
		securityManager.setRealm(userRealm);
		return securityManager;
	}
	
	@Bean
	public  LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
		LifecycleBeanPostProcessor processor = new LifecycleBeanPostProcessor();
		return processor;
	}
	
	@Bean 
	@DependsOn("lifecycleBeanPostProcessor")
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
		return creator;
	}
	
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(securityManager);
		return advisor;
	}
	
	@Bean
	public Realm userRealm() {
		UserRealm userRealm = new UserRealm(userService);
		
		return userRealm;
	}
	
	@Bean
	public RandomNumberGenerator randomNumberGenerator() {
		return new SecureRandomNumberGenerator();
	}
	
	@Bean
	public PasswordHelper passwordHelper(RandomNumberGenerator randomNumberGenerator) {
		PasswordHelper passwordHelper = new PasswordHelper("md5", 2, randomNumberGenerator);
		return passwordHelper;
	}

}
