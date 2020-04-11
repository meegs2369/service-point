package com.movedtoatlanta;

import com.movedtoatlanta.selectors.RandomStringGenerator;
import org.junit.Assert;
import org.junit.Test;

import java.util.regex.Pattern;

public class RandomStringGeneratorTest {
    @Test
    public void testRandomStringCaps() {
        String randomCaps = RandomStringGenerator.generateRandomAlphaNumericString(true, 16);
        Assert.assertTrue(Pattern.matches("^[A-Z,0-9]{16}$", randomCaps));
    }

    @Test
    public void testRandomString() {
        String randomCaps = RandomStringGenerator.generateRandomAlphaNumericString(false, 16);
        Assert.assertTrue(Pattern.matches("^[\\w]{16}$", randomCaps));
    }

}
