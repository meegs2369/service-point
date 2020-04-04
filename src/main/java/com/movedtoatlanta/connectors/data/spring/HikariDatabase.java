package com.movedtoatlanta.connectors.data.spring;

import com.movedtoatlanta.connectors.data.interfaces.PooledDataConnection;

public class HikariDatabase implements PooledDataConnection {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
    private int maxPoolSize;

    public HikariDatabase(String driverClassName, String url, String username, String password, int maxPoolSize) {
        this.driverClassName = driverClassName;
        this.url = url;
        this.username = username;
        this.password = password;
        this.maxPoolSize = this.setPoolSize(maxPoolSize);
    }

    @Override
    public String getDriverClassName() {
        return driverClassName;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int getMaxPoolSize() {
        return this.maxPoolSize;
    }

    private int setPoolSize(int maxPoolSize) {
        int poolSize = 10;
        if (maxPoolSize > 0) {
            poolSize = maxPoolSize;
        }
        return poolSize;
    }
}
