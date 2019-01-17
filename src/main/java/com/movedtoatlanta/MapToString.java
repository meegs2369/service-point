package com.movedtoatlanta;

import java.util.Map;
import java.util.stream.Collectors;

public class MapToString {

	private MapToString() {

	}

	public static String convert(Map<String, String> stringMap, String keyValueDelimiter,
											String elemDelimiter) {
		return (elemDelimiter != null && !elemDelimiter.isEmpty()) ? construct(stringMap, keyValueDelimiter,
																			   elemDelimiter)
																   : construct(stringMap, keyValueDelimiter, " ");

	}

	private static String construct(Map<String, String> stringMap, String keyValueDelimiter, String elemDelimiter) {
		return stringMap.entrySet()
						.stream()
						.map(x -> MapToString.buildSet(x, keyValueDelimiter))
						.collect(Collectors.joining(elemDelimiter));

	}

	private static String buildSet(Map.Entry<String, String> entry, String delimiter) {
		return delimiter != null ? entry.getKey() + delimiter + entry.getValue() : entry.toString();
	}
}
