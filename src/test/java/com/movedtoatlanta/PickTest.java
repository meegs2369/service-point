package com.movedtoatlanta;

import org.junit.Assert;
import org.junit.Test;

public class PickTest {

    @Test
    public void test1() {
        int[] intArr = {1, 2, 5, 3, 9, 93, -1, -4};
        int val = new Pick(intArr).get();
        Assert.assertEquals(4, val);
    }

    @Test
    public void test7() {
        int[] intArr = {1, 2, 3};
        int val = new Pick(intArr).get();
        Assert.assertEquals(4, val);
    }

    @Test
    public void test2() {
        int[] intArr = {0, 2, -5, 3, 9, 93, -1, -4, 1};
        int val = new Pick(intArr).get();
        Assert.assertEquals(4, val);
    }

    @Test
    public void test3() {
        int[] intArr = {1, 9, 5, 3, 9, 93, -1, -4};
        int val = new Pick(intArr).get();
        Assert.assertEquals(2, val);
    }

    @Test
    public void test4() {
        int[] intArr = {-109, 1, 2, -5, 7, 3, 80, 93, 4, -1, -4};
        int val = new Pick(intArr).get();
        Assert.assertEquals(5, val);
    }

    @Test
    public void test5() {
        int[] intArr = {-1, -3};
        int val = new Pick(intArr).get();
        Assert.assertEquals(1, val);
    }

    @Test
    public void test6() {
        int[] intArr = {1, 4, 1, 5, 6};
        int val = new Pick(intArr).get();
        Assert.assertEquals(2, val);
    }
}
