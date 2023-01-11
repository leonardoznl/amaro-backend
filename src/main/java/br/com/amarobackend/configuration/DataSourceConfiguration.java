package br.com.amarobackend.configuration;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class DataSourceConfiguration {

    private final ApplicationConfig dataSourceConfiguration;

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .driverClassName(dataSourceConfiguration.getDriverClassName())
                .url(dataSourceConfiguration.getUrl())
                .username(dataSourceConfiguration.getUsername())
                .password(dataSourceConfiguration.getPassword())
                .build();
    }

}