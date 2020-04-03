package com.movedtoatlanta;

import com.movedtoatlanta.interfaces.Converter;

import java.util.Map;
import java.util.stream.Collectors;

public final class MapToString implements Converter<String, Map.Entry<String, String>, String> {

    private MapToString() {
    }

    @Override
    public String convert(Map.Entry<String, String> stringStringEntry, String s) {
        return stringStringEntry.getKey() + s + stringStringEntry.getValue();
    }

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
        return convert(x, keyValueDelimiter);
    }
}