package com.salmon.scommerce.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.salmon.scommerce.persistence.repository.AdminRoleMapper;
import com.salmon.scommerce.persistence.repository.AdminUserMapper;
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
		try {
			return getSqlSessionFactoryBean(dataSource).getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Bean 
	public MapperFactoryBean<AdminRoleMapper> adminRoleMapper() throws Exception{
		MapperFactoryBean<AdminRoleMapper> bean = new MapperFactoryBean<AdminRoleMapper>();
		bean.setMapperInterface(AdminRoleMapper.class);
		bean.setSqlSessionFactory(getSqlSessionFactory());
		return bean;
	}
	
	@Bean 
	public MapperFactoryBean<AdminUserMapper> adminUserMapper() throws Exception{
		MapperFactoryBean<AdminUserMapper> bean = new MapperFactoryBean<AdminUserMapper>();
		bean.setMapperInterface(AdminUserMapper.class);
		bean.setSqlSessionFactory(getSqlSessionFactory());
		return bean;
	}
	

}
