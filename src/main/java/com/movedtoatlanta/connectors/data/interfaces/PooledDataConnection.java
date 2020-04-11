package com.movedtoatlanta.connectors.data.interfaces;

/**
 * A combination of {@link DataConnection} and {@link ConnectionPool} for pooled Database Connections.
 */
public interface PooledDataConnection extends DataConnection, ConnectionPool {
}