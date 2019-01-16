package com.movedtoatlanta;

import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

import sun.security.pkcs11.wrapper.Functions;

public class RandomStringGeneratorTest {
	@Test
	public void testRandomStringCaps(){
		String randomCaps = RandomStringGenerator.generateRandomAlphaNumericString(true, 16);
		Assert.assertTrue(Pattern.matches("^[A-Z,0-9]{16}$", randomCaps));
	}
	@Test
	public void testRandomString(){
		String randomCaps = RandomStringGenerator.generateRandomAlphaNumericString(false,16);
		Assert.assertTrue(Pattern.matches("^[\\w]{16}$",randomCaps));
	}

}
