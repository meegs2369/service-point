package com.movedtoatlanta.validators;

import java.util.stream.IntStream;

/**
 * Static class to check for a palindrome (spelled the same forward and backward).
 */
public class Palindrome {

    private Palindrome() {
    }

    /**
     * @param text String
     * @return boolean
     */
    public static boolean isPalindrome(String text) {
        String temp = text.replaceAll("\\s+", "").toLowerCase();
        return IntStream.range(0, temp.length() / 2)
                .noneMatch(i -> temp.charAt(i) != temp.charAt(temp.length() - i - 1));
    }
}