package com.movedtoatlanta;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ListToMap {
	private ListToMap() {

	}

	public static Map<String, String> convert(List<String> elements, String delimiter) {
		return elements.stream()
					   .collect(Collectors.toMap(x -> x.split(Pattern.quote(delimiter))[0],
												 x -> x.split(Pattern.quote(delimiter))[1]));
	}
}