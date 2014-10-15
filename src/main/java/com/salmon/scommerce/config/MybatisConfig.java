package com.salmon.scommerce.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.core.io.Resource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;

import com.salmon.scommerce.persistence.repository.AdminRoleMapper;
import com.salmon.scommerce.persistence.repository.AdminUserMapper;
import com.salmon.scommerce.persistence.repository.Api2AclRoleMapper;
import com.salmon.scommerce.persistence.repository.Api2AclRuleMapper;
import com.salmon.scommerce.persistence.repository.Api2AclUserMapper;
import com.salmon.scommerce.persistence.services.*;
import com.salmon.scommerce.persistence.services.impl.UserPersistenceEventHandler;

@Configuration
@ComponentScan(basePackages = { "com.salmon.scommerce.services"})
@Import(DataSourceConfig.class)
public class MybatisConfig {

	@Inject DataSource dataSource;
	
	@Bean(name="sqlSessionFactory")
	public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource) {
		
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		return bean;
		
		
	}
	
	public SqlSessionFactory getSqlSessionFactory() throws Exception{

		SqlSessionFactory sqlSessionFactory =  getSqlSessionFactoryBean(dataSource).getObject(); 
		try {
			return sqlSessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Bean(name="sqlSessionTemplate")
	public SqlSessionTemplate getSqlSessionTemplate(){
		SqlSessionTemplate sqlSessionTemplate = null;
		try {
			 sqlSessionTemplate = new SqlSessionTemplate(getSqlSessionFactory());
			 //sqlSessionTemplate.getConfiguration().addMappers("com.salmon.scommerce.persistence.repository");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqlSessionTemplate;
		
	}
		
	
	@Bean 
	public MapperFactoryBean<AdminRoleMapper> adminRoleMapper() throws Exception{
		
		MapperFactoryBean<AdminRoleMapper> bean = new MapperFactoryBean<AdminRoleMapper>();
		bean.setMapperInterface(AdminRoleMapper.class);
		bean.setSqlSessionFactory(getSqlSessionFactory());
		return bean;
				
	}
	
	public AdminRoleMapper getAdminRoleMapper() throws Exception{
		try {
			return adminRoleMapper().getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	

	
	@Bean 
	public MapperFactoryBean<AdminUserMapper> adminUserMapper() throws Exception{
		MapperFactoryBean<AdminUserMapper> bean = new MapperFactoryBean<AdminUserMapper>();
		bean.setMapperInterface(AdminUserMapper.class);
		bean.setSqlSessionFactory(getSqlSessionFactory());
		return bean;
	}
	
	public AdminUserMapper getAdminUserMapper() throws Exception{
		try {
			return adminUserMapper().getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	@Bean 
	public MapperFactoryBean<Api2AclRoleMapper> api2AclRoleMapper() throws Exception{
		MapperFactoryBean<Api2AclRoleMapper> bean = new MapperFactoryBean<Api2AclRoleMapper>();
		bean.setMapperInterface(Api2AclRoleMapper.class);
		bean.setSqlSessionFactory(getSqlSessionFactory());
		return bean;
	}
	
	
	@Bean 
	public MapperFactoryBean<Api2AclRuleMapper> api2AclRuleMapper() throws Exception{
		MapperFactoryBean<Api2AclRuleMapper> bean = new MapperFactoryBean<Api2AclRuleMapper>();
		bean.setMapperInterface(Api2AclRuleMapper.class);
		bean.setSqlSessionFactory(getSqlSessionFactory());
		return bean;
	}
	
	@Bean 
	public MapperFactoryBean<Api2AclUserMapper> api2AclUserMapper() throws Exception{
		MapperFactoryBean<Api2AclUserMapper> bean = new MapperFactoryBean<Api2AclUserMapper>();
		bean.setMapperInterface(Api2AclUserMapper.class);
		bean.setSqlSessionFactory(getSqlSessionFactory());
		return bean;
	}
	
	public Api2AclUserMapper getApi2AclUserMapper() throws Exception{
		try {
			return api2AclUserMapper().getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
	/***********************************************************
	 * Service Inject
	 ***********************************************************/
	@Bean 
	public UserPersistenceService userPersistenceService() throws Exception{
		
		UserPersistenceService userservice = new UserPersistenceEventHandler(getAdminUserMapper(), getAdminRoleMapper());
		
		return userservice;
	}

}
