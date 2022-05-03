package org.zerock.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = { "org.zerock.mapper" })
@PropertySource("file:src/main/java/org/zerock/config/jdbc.properties")
public class RootConfig {

	@Value("${dcn}")
	private String dcn;

	@Value("${url}")
	private String url;

	@Value("${user}")
	private String user;

	@Value("${pass}")
	private String pass;
	
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig( );
		hikariConfig.setDriverClassName(dcn);
		hikariConfig.setJdbcUrl(url);
		hikariConfig.setUsername(user);
		hikariConfig.setPassword(pass);
			
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
