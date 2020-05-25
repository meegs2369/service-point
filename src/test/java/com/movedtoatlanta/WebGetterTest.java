package com.movedtoatlanta;

import com.movedtoatlanta.connectors.network.WebGetter;
import org.junit.Assert;
import org.junit.Test;

/**
 * @project service-point
 * @created 2020-May-25
 */

public class WebGetterTest {
    @Test
    public void testGet() {
        WebGetter getter = new WebGetter("https://about.google.com");
        String result = getter.communicate("https://about.google.com/stories");
        Assert.assertNotNull(result);
        Assert.assertFalse(result.isEmpty());
    }

    @Test
    public void testGet404() {
        WebGetter getter = new WebGetter("https://about.google.com");
        String result = getter.communicate("https://about.google.com/feeb");
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
    }
}
