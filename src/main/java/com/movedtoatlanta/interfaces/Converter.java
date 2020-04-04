package com.movedtoatlanta.interfaces;

/**
 * A converter to be implemented in such a way that param U and V result in an instance of T.
 *
 * @param <T> Class of desired result
 * @param <U> argument to create T
 * @param <V> second argument for creation of T
 */

public interface Converter<T, U, V> {
    /**
     * Method to perform the conversion.
     *
     * @param u Class
     * @param v Class
     * @return Class
     */
    T convert(U u, V v);
}
