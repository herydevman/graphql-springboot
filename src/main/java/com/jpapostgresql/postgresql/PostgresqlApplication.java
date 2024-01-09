package com.jpapostgresql.postgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication()
@EnableJpaRepositories("com.jpapostgresql.postgresql.repository")
public class PostgresqlApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PostgresqlApplication.class, args);
	}
}
