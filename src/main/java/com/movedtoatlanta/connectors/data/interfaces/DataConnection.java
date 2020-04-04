package com.movedtoatlanta.connectors.data.interfaces;

public interface DataConnection {

    String getDriverClassName();

    String getUrl();

    String getUsername();

    String getPassword();
}