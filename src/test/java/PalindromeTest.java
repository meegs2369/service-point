import org.junit.Assert;
import org.junit.Test;

public class PalindromeTest {
	@Test
	public void testGood() {
		Assert.assertTrue(Palindrome.isPalindrome("Arrerra"));
	}

	@Test
	public void testBad() {
		Assert.assertTrue(!Palindrome.isPalindrome("kombucha"));
	}
}
