package com.movedtoatlanta;

import javax.inject.Provider;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NumberSelector implements Provider<Integer> {
    private List<Integer> conversion;

    public NumberSelector(int[] intArr) {
        Arrays.sort(intArr);
        conversion = Arrays.stream(intArr).boxed().collect(Collectors.toList());
    }

    @Override
    public Integer get() {
        int selection = 1;
        for (Integer i : conversion) {
            if (i > 0 && !conversion.contains(i + 1)) {
                selection = i + 1;
                break;
            }
        }
        return selection;
    }
}