package com.movedtoatlanta.connectors.data.impl;

import com.movedtoatlanta.connectors.data.DataConnection;
import com.movedtoatlanta.connectors.data.PooledDataConnection;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

/**
 * Class that can produce data objects for DataConfigClasses.
 */
public final class DataHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataHelper.class);

    private DataHelper() {
    }

    /**
     * Method to create a minimal pooled Hikari Data Source.
     *
     * @param connection {@link PooledDataConnection}
     * @return {@link com.zaxxer.hikari.HikariDataSource}
     */
    public static DataSource buildHikariDataSource(PooledDataConnection connection) {
        LOGGER.info("building connection pool for {} ", connection.getUrl());
        HikariConfig hikariConfig = new HikariConfig();
        DataSource ds = buildBasicDataSource(connection);
        hikariConfig.setDataSource(ds);
        hikariConfig.setMaximumPoolSize(connection.getMaxPoolSize());
        hikariConfig.setConnectionTestQuery("SELECT 1");
        return new HikariDataSource(hikariConfig);
    }

    /**
     * Method to create a data source.
     *
     * @param connection {@link DataConnection}
     * @return DataSource
     */
    public static DataSource buildBasicDataSource(DataConnection connection) {
        LOGGER.info("building connection for {} ", connection.getUrl());
        return DataSourceBuilder.create()
                .driverClassName(connection.getDriverClassName())
                .url(connection.getUrl())
                .username(connection.getUsername())
                .password(connection.getPassword())
                .build();
    }
}