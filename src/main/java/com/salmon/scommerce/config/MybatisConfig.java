package com.salmon.scommerce.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.salmon.scommerce.repository.mybatis.config.AdminRoleMapper;

@Configuration
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
}
