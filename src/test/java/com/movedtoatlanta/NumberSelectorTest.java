package com.movedtoatlanta;

import com.movedtoatlanta.selectors.NumberSelector;
import org.junit.Assert;
import org.junit.Test;

public class NumberSelectorTest {

    @Test
    public void testMixed() {
        int[] intArr = {1, 2, 5, 3, 9, 93, -1, -4};
        int val = new NumberSelector(intArr).getAsInt();
        Assert.assertEquals(4, val);
    }

    @Test
    public void testNeg() {
        int[] intArr = {-1, -3};
        int val = new NumberSelector(intArr).getAsInt();
        Assert.assertEquals(1, val);
    }

    @Test
    public void testPos() {
        int[] intArr = {1, 4, 1, 5, 6};
        int val = new NumberSelector(intArr).getAsInt();
        Assert.assertEquals(2, val);
    }

    @Test
    public void testSingle() {
        int[] intArr = {2};
        int val = new NumberSelector(intArr).getAsInt();
        Assert.assertEquals(1, val);
    }

    @Test
    public void testExtreme() {
        int[] intArr = {-1, -6, -205, 1, 6, 0, 6, 20, 54, 9603, 12049, 999, 3, 3, 3, 2, 1000000, 74, 89, -98, 125, 4, -999, 4, 8, 16, 25, 47, 87, 35, 914, -999, 258, -9854};
        int val = new NumberSelector(intArr).getAsInt();
        Assert.assertEquals(5, val);
    }
}
