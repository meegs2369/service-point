package com.movedtoatlanta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Pick {
	private Pick() {
	}

	public static int pick(int[] ints) {
		List<Integer> intList = new ArrayList<>();
		for (int i :ints) {
			intList.add(i);
		}
		return findLowest(intList);
	}
	private static int findLowest(List<Integer> intList) {
		Collections.sort(intList);
		Integer high = intList.get(intList.size() - 1);
		int toplimit = high + 1;
		int val = IntStream.range(0, toplimit)
						   .filter(i -> (!intList.contains(i) && i > 0))
						   .findFirst()
						   .orElse(-1);
		if (val == -1) {
			if (intList.get(0) < 0) {
				val = 1;
			} else {
				val = toplimit;
			}
		}
		return val;
	}
}