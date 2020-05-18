package com.movedtoatlanta.converters;


import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Implementation of {@link java.util.function.BiFunction} that turns a map of strings into a String
 */
public final class MapToString implements BiFunction<Map.Entry<String, String>, String, String> {

    private MapToString() {
    }

    /**
     * Turns a Map.Entry into a String using with a given delimiter
     *
     * @param stringEntry Map.Entry
     * @param delimiter   String
     * @return String
     */
    @Override
    public String apply(Map.Entry<String, String> stringEntry, String delimiter) {
        return stringEntry.getKey() + delimiter + stringEntry.getValue();
    }

    /**
     * Exposes implementation in a static way.
     *
     * @param stringMap         Map
     * @param keyValueDelimiter String
     * @param elemDelimiter     String
     * @return String
     */
    public static String buildSet(Map<String, String> stringMap, String keyValueDelimiter,
                                  String elemDelimiter) {
        MapToString mts = new MapToString();
        return (elemDelimiter != null && !elemDelimiter.isEmpty()) ? mts.construct(stringMap, keyValueDelimiter,
                elemDelimiter)
                : mts.construct(stringMap, keyValueDelimiter, " ");

    }

    private String construct(Map<String, String> stringMap, String keyValueDelimiter, String elemDelimiter) {
        return stringMap.entrySet()
                .stream()
                .map(x -> getConversion(x, keyValueDelimiter))
                .collect(Collectors.joining(elemDelimiter));

    }

    private String getConversion(Map.Entry<String, String> x, String keyValueDelimiter) {
        return apply(x, keyValueDelimiter);
    }
}