package com.movedtoatlanta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Pick {
	private Pick(){
	}

	public static int pick(int[] ints) {
		List<Integer> intList = new ArrayList<>();
		for (int i = 0; i < ints.length; i++) {
			intList.add(ints[i]);
		}
		return findLowest(intList);
	}

	private static int findLowest(List<Integer> intList) {
		Collections.sort(intList);
		return IntStream.range(0, intList.get(intList.size() - 1))
						.filter(i -> (!intList.contains(i) && i > 0))
						.findFirst()
						.orElse(1);

	}
}