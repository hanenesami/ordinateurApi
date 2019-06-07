package com.web.commerce.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
@Configuration
public class JdbcTemplateBase {


    @Bean(name = "commerceJdbcTemplate")
    @Primary
    public JdbcTemplate dossierJdbcTemplate(@Qualifier("datasourceCommerce") DataSource dossierDS)  {
        return new JdbcTemplate(dossierDS);
    }

    @Bean(name = "datasourceCommerce")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource primaryDataSource() {
        return DataSourceBuilder.create().build();
    }

}
