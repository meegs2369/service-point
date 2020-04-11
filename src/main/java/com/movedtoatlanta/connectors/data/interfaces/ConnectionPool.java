package com.movedtoatlanta.connectors.data.interfaces;

/**
 * Interface for a pool of connections with an upper limit.
 */
public interface ConnectionPool {
    /**
     * Gets the upper limit of the number of connections allowed.
     *
     * @return int
     */
    int getMaxPoolSize();
}
