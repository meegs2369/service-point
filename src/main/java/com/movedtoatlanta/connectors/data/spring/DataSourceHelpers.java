package com.movedtoatlanta.connectors.data.spring;

import com.movedtoatlanta.connectors.data.interfaces.DataConnection;
import com.movedtoatlanta.connectors.data.interfaces.PooledDataConnection;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;


public class DataSourceHelpers {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceHelpers.class);

    private DataSourceHelpers() {
    }

    public static DataSource buildDatasource(PooledDataConnection connection) {
        LOGGER.info("building connection pool for {} ", connection.getUrl());
        HikariConfig hikariConfig = new HikariConfig();
        DataSource ds = DataSourceBuilder.create()
                .driverClassName(connection.getDriverClassName())
                .url(connection.getUrl())
                .username(connection.getUsername())
                .password(connection.getPassword())
                .build();
        hikariConfig.setDataSource(ds);
        hikariConfig.setMaximumPoolSize(connection.getMaxPoolSize());
        hikariConfig.setConnectionTestQuery("SELECT 1");
        return new HikariDataSource(hikariConfig);
    }

    public static DataSource buildBasicDatasource(DataConnection connection) {
        LOGGER.info("building connection for {} ", connection.getUrl());
        return DataSourceBuilder.create()
                .driverClassName(connection.getDriverClassName())
                .url(connection.getUrl())
                .username(connection.getUsername())
                .password(connection.getPassword())
                .build();
    }

    public static LocalContainerEntityManagerFactoryBean configureLocalEmf(String[] scanPackages, DataSource ds) {
        LocalContainerEntityManagerFactoryBean lef = new LocalContainerEntityManagerFactoryBean();
        lef.setPackagesToScan(scanPackages);
        lef.setDataSource(ds);
        lef.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return lef;
    }
}