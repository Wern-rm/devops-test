package org.lightning.digital.log.gate.configs;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author WeRn
 */
@Configuration
@MapperScan(
		basePackages = {"org.lightning.digital.log.gate.db"},
		sqlSessionFactoryRef = "postgresqlDataSourceApiFactory")
public class PostgresqlApiConfig {

	@Bean(name = "postgresqlDataSourceApiProperties")
	@ConfigurationProperties("spring.datasource.postgresql")
	public DataSourceProperties postgresqlDataSourceApiProperties() {
		return new DataSourceProperties();
	}

	@Bean(name = "postgresqlApiDataSource")
	@ConfigurationProperties("spring.datasource.hikari")
	public DataSource postgresqlDataSourceApi(@Qualifier("postgresqlDataSourceApiProperties") DataSourceProperties dataSourceProperties) {
		return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

	@Bean("postgresqlDataSourceApiFactory")
	public SqlSessionFactory dataSourceApiFactory(@Qualifier("postgresqlApiDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		return factoryBean.getObject();
	}

	@Bean("postgresqlSqlSessionTemplateApi")
	@Primary
	public SqlSessionTemplate sqlSessionTemplate(@Qualifier("postgresqlDataSourceApiFactory") SqlSessionFactory sessionFactory) {
		return new SqlSessionTemplate(sessionFactory);
	}

	@Bean(name = "postgresqlApiTransactionManager")
	public DataSourceTransactionManager transactionManager(@Qualifier("postgresqlApiDataSource") DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}
}