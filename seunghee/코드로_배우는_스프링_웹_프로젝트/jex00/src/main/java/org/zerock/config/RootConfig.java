package org.zerock.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan( basePackages = { "org.zerock.sample" })
@MapperScan( basePackages = { "org.zerock.mapper" })
public class RootConfig {
	// HikariCP JDBC		
	@Bean		
	public javax.sql.DataSource dataSource( ) {		
		HikariConfig hikariConfig = new HikariConfig( );
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");	
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@toy-oracle.cwkdq9ftbcnp.ap-northeast-2.rds.amazonaws.com:1521:ORACLE");	
		hikariConfig.setUsername("study_book_ex");
		hikariConfig.setPassword("study_book_ex");
			
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);	
			
		return dataSource;
	}
	
	// MyBatis
	@Bean
	public SqlSessionFactory sqlSessionFactory( ) throws Exception {	
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean( );
		sqlSessionFactory.setDataSource(dataSource( ));
		return ( SqlSessionFactory ) sqlSessionFactory.getObject( );
	}	
	
}
