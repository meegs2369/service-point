package com.movedtoatlanta.interfaces;

/**
 * using values U and V convert to T
 *
 * @param <T> Class of desired result
 * @param <U> argument to create T
 * @param <V> second argument for creation of T
 */

public interface Converter<T, U, V> {
    T convert(U u, V v);
}
