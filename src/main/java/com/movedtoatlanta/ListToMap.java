package com.movedtoatlanta;

import com.movedtoatlanta.interfaces.Converter;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Implementation of Converter to convert a list of items into a Map of items.
 */
public final class ListToMap implements Converter<Map<String, String>, List<String>, String> {
    private ListToMap() {
    }

    /**
     * Splits a string into Key Value pair on the requested delimiter.
     *
     * @param elements  List (of Strings)
     * @param delimiter String
     * @return Map
     */
    @Override
    public Map<String, String> convert(List<String> elements, String delimiter) {
        return elements.stream()
                .collect(Collectors.toMap(x -> x.split(Pattern.quote(delimiter))[0],
                        x -> x.split(Pattern.quote(delimiter))[1]));
    }

    /**
     * Expose the implementation in a static method.
     *
     * @param elements  List (of Strings)
     * @param delimiter String
     * @return Map
     */
    public static Map<String, String> getConversion(List<String> elements, String delimiter) {
        return new ListToMap().convert(elements, delimiter);
    }
}