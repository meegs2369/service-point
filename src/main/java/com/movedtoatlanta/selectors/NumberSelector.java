package com.movedtoatlanta.selectors;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;

/**
 * Implementation of Provider to provide the first non zero number in an array.
 */
public class NumberSelector implements IntSupplier {

    private final List<Integer> conversion;

    public NumberSelector(int[] intArr) {
        Arrays.sort(intArr);
        conversion = Arrays.stream(intArr)
                           .boxed()
                           .collect(Collectors.toList());
        conversion.removeIf(i -> i < 1);
    }

    /**
     * @return Integer
     */
    @Override
    public int getAsInt() {
        int selection = 1;
        if (!conversion.isEmpty()) {
            if (conversion.size() > 1) {
                selection = selection + conversion.stream()
                                                  .filter(i -> !conversion.contains(i + 1))
                                                  .findFirst()
                                                  .orElse(0);
            } else {
                selection = conversion.get(0) == 1 ? conversion.get(0) : selection;
            }
        }
        return selection;
    }
}