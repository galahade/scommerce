package com.salmon.scommerce.config;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.Filter;

import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.authz.ModularRealmAuthorizer;
import org.apache.shiro.authz.permission.WildcardPermissionResolver;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.salmon.scommerce.core.services.UserService;
import com.salmon.scommerce.security.shiro.PasswordHelper;
import com.salmon.scommerce.security.shiro.UserRealm;

@Configuration
@Import(CoreConfig.class)
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ShiroConfig {
	
	@Inject UserService userService;
	
	
	/***********************************************************
	 * Filter config
	 ***********************************************************/
	//基于Form表单的身份验证过滤器 
	@Bean 
	public FormAuthenticationFilter formAuthenticationFilter() {
		FormAuthenticationFilter filter = new FormAuthenticationFilter();
		filter.setUsernameParam("username");
		filter.setPasswordParam("password");
		filter.setLoginUrl("/login");
		return filter;
	}
	//Shiro的Web过滤器
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager,FormAuthenticationFilter formAuthenticationFilter) {
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		bean.setSecurityManager(securityManager);
		bean.setLoginUrl("/login");
		bean.setSuccessUrl("/home");
		bean.setUnauthorizedUrl("/unauthorized");
		
		Map<String, Filter> filterMap = new HashMap<String, Filter>();
		filterMap.put("authc", formAuthenticationFilter);
		bean.setFilters(filterMap);
		
		Map<String, String> filterConfigMap = new HashMap<String, String>();
		filterConfigMap.put("/login", "authc");
		filterConfigMap.put("/user/**", "authc");
		
		bean.setFilters(filterMap);
		bean.setFilterChainDefinitionMap(filterConfigMap);;
		return bean;
	}
	
	@Bean
	public SecurityManager securityManager(Realm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		
		//设置authenticator  
		ModularRealmAuthenticator authenticator = new ModularRealmAuthenticator();  
		authenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy()); 
		securityManager.setAuthenticator(authenticator);
		
		//设置authorizer  
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
