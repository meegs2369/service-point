package com.movedtoatlanta.connectors.network.interfaces;

/**
 * @project service-point
 * @created 2020-May-25
 * Classes implementing this will have take a String parameter and produce a String of a response.
 */
public interface Communicator {
    /**
     * Method to produce the response
     *
     * @param endpoint String
     * @return String
     */
    String communicate(String endpoint);
}

