/**
 * address-reference-service
 *
 * Copyright (C) 2017 General Electric Transportation
 *
 * The copyright to the computer software herein is the property of General Electric Transportation. The software may
 * be used and/or copied only with the written permission of General Electric Transportation or in accordance with the
 * terms and conditions stipulated in the agreement/contract under which the software has been supplied.
 */

package com.suranku.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.OpenJpaVendorAdapter;

/**
 * Spring configurations for persistence layer in local environment.
 *
 * @author Akash Dave
 */
@Configuration
@EnableJpaRepositories("com.suranku.users.dao")
@PropertySource("classpath:persistence-config.properties")
public class PersistenceConfig {

    @Autowired
    private Environment env;

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan(env.getProperty("emf.packagesToScan"));
        emf.setJpaVendorAdapter(new OpenJpaVendorAdapter());
        emf.afterPropertiesSet();
        return emf.getObject();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("datasource.url"));
        dataSource.setUsername(env.getProperty("datasource.username"));
        dataSource.setPassword(env.getProperty("datasource.password"));
        return dataSource;
    }

}
