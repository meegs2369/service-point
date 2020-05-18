package com.movedtoatlanta;

import com.movedtoatlanta.selectors.NumberSelector;
import org.junit.Assert;
import org.junit.Test;

public class NumberSelectorTest {

    @Test
    public void test1() {
        int[] intArr = {1, 2, 5, 3, 9, 93, -1, -4};
        int val = new NumberSelector(intArr).getAsInt();
        Assert.assertEquals(4, val);
    }

    @Test
    public void test7() {
        int[] intArr = {1, 2, 3};
        int val = new NumberSelector(intArr).getAsInt();
        Assert.assertEquals(4, val);
    }

    @Test
    public void test2() {
        int[] intArr = {0, 2, -5, 3, 9, 93, -1, -4, 1};
        int val = new NumberSelector(intArr).getAsInt();
        Assert.assertEquals(4, val);
    }

    @Test
    public void test3() {
        int[] intArr = {1, 9, 5, 3, 9, 93, -1, -4};
        int val = new NumberSelector(intArr).getAsInt();
        Assert.assertEquals(2, val);
    }

    @Test
    public void test4() {
        int[] intArr = {-109, 1, 2, -5, 7, 3, 80, 93, 4, -1, -4};
        int val = new NumberSelector(intArr).getAsInt();
        Assert.assertEquals(5, val);
    }

    @Test
    public void test5() {
        int[] intArr = {-1, -3};
        int val = new NumberSelector(intArr).getAsInt();
        Assert.assertEquals(1, val);
    }

    @Test
    public void test6() {
        int[] intArr = {1, 4, 1, 5, 6};
        int val = new NumberSelector(intArr).getAsInt();
        Assert.assertEquals(2, val);
    }

    @Test
    public void test8() {
        int[] intArr = {2};
        int val = new NumberSelector(intArr).getAsInt();
        Assert.assertEquals(1, val);
    }

    @Test
    public void test9() {
        int[] intArr = {-1, -6, -205, 1, 6, 0, 6, 20, 54, 9603, 12049, 999, 3, 3, 3, 2, 1000000, 74, 89, -98, 125, 4, -999, 4, 8, 16, 25, 47, 87, 35, 914, 258, -9854};
        int val = new NumberSelector(intArr).getAsInt();
        Assert.assertEquals(5, val);
    }
}
