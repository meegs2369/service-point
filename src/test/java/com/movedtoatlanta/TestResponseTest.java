package com.movedtoatlanta;

import com.movedtoatlanta.connectors.network.TestResponse;
import com.movedtoatlanta.converters.StreamReader;
import org.apache.http.HttpResponse;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * @project service-point
 * @created 2020-September-09
 */

public class TestResponseTest implements StreamReader {
    @Test
    public void getResponse() {
        try {
            InputStream is = new ByteArrayInputStream("this is a test".getBytes());
            HttpResponse response = new TestResponse(is, "HTTP", 1, 1, 200, "OK").getResponse();
            String responseString = getResponse(response.getEntity()
                                                        .getContent());
            Assert.assertEquals(200, response.getStatusLine()
                                             .getStatusCode());
            Assert.assertEquals("OK", response.getStatusLine()
                                              .getReasonPhrase());
            Assert.assertEquals("this is a test", responseString);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
