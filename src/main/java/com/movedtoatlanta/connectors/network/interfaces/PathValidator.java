package com.movedtoatlanta.connectors.network.interfaces;

import java.util.regex.Pattern;

/**
 * @project service-point
 * @created 2020-May-25
 * Classes implementing this interface will have the ability to verify a path to only allow the desired path.
 */

public interface PathValidator {
    /**
     * Validation method
     *
     * @param path String
     * @return String
     */
    default String validate(String path, String baseUrl) {
        String regex = baseUrl + ".*";
        if (Pattern.matches(regex, path)) {
            return path;
        } else {
            return "";
        }
    }
}