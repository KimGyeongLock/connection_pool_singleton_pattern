package com.example.singleton.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/singleton")
                .username("root")
                .password("kkl7445468")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }
}
