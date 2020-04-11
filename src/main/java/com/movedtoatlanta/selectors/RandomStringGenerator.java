package com.movedtoatlanta.selectors;

import java.util.Random;
import java.util.function.IntPredicate;

/**
 * Generator for pseudo-random Strings.
 */
public class RandomStringGenerator {

    private RandomStringGenerator() {

    }

    /**
     * Method to generate the string.
     *
     * @param capsOnly boolean
     * @param length   int
     * @return String
     */
    public static String generateRandomAlphaNumericString(boolean capsOnly, int length) {
        String alphaNumericString;
        IntPredicate inRange;
        if (capsOnly) {
            inRange = i -> (i < 58 || i > 64);
            alphaNumericString = generate(90, length, inRange);
        } else {
            inRange = i -> (i < 58 || i > 64) && (i < 90 || i > 97);
            alphaNumericString = generate(122, length, inRange);
        }
        return alphaNumericString;
    }

    private static String generate(int upper, int length, IntPredicate inRange) {
        return new Random().ints(48, upper)
                .filter(inRange)
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }
}
