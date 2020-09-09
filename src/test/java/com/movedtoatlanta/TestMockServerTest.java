package com.movedtoatlanta;

import com.movedtoatlanta.connectors.network.TestMockServer;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.*;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.HttpResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.mockserver.model.HttpRequest.request;

/**
 * @project service-point
 * @created 2020-September-09
 */

public class TestMockServerTest {
    private static TestMockServer testServer;
    private ClientAndServer mockServer;

    @BeforeClass
    public static void setServer(){
        testServer = new TestMockServer();
    }

    @AfterClass
    public static void closeServer(){
        testServer.shutdownTestMockServer();
    }

    @Before
    public void setUp(){
        mockServer=testServer.startMockServer(1090);
    }
    @After
    public void tearDown(){
        mockServer.stop();
    }
    @Test
    public void getResponse(){
        String content = "Are you mocking me?";
        HttpResponse httpResponse = new HttpResponse();
        httpResponse.withStatusCode(200);
        httpResponse.withBody(content);
        mockServer.when(request().withMethod("GET").withPath("/")).respond(httpResponse);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet("http://localhost:1090/");
        CloseableHttpResponse response;
        try{
            response= client.execute(get);
            int status= response.getStatusLine().getStatusCode();
            HttpEntity entity= response.getEntity();
            String message = IOUtils.toString(entity.getContent(), StandardCharsets.UTF_8);
            Assert.assertEquals(content,message);
        }catch(IOException e){
            Assert.fail(e.getMessage());
        }
    }
}
