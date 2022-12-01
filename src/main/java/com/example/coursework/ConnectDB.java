package com.example.coursework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class ConnectDB {

    @Bean
    public DataSource getDatasource() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        datasource.setDriverClassName("org.postgresql.Driver");
        datasource.setUrl("jdbc:postgresql://localhost:5432/game_shop");
        datasource.setUsername("postgres");
        datasource.setPassword("lfifgjrf18P@");
        return datasource;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
