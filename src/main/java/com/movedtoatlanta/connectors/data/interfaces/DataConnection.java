package com.movedtoatlanta.connectors.data.interfaces;

/**
 * Interface for basic DataConnection.
 */
public interface DataConnection {
    /**
     * Returns the FQDN of the driver being used.
     *
     * @return String
     */
    String getDriverClassName();

    /**
     * Returns the url to connect to the data source.
     *
     * @return String
     */
    String getUrl();

    /**
     * Returns the username needed for login to the data source.
     *
     * @return String
     */
    String getUsername();

    /**
     * Return the password needed for login to the data source.
     *
     * @return String
     */
    String getPassword();
}