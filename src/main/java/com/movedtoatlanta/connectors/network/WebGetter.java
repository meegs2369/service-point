package com.movedtoatlanta.connectors.network;

import com.movedtoatlanta.connectors.network.interfaces.Communicator;
import com.movedtoatlanta.connectors.network.interfaces.PathValidator;
import org.apache.commons.validator.routines.UrlValidator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @project service-point
 * @created 2020-May-25
 * Implementation of Communicator and PathValidator that, if a response from a web resource is a 200, returns the
 * response as a string. Otherwise, the return status code and content are displayed in the Log.
 */

public class WebGetter implements Communicator, PathValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebGetter.class);
    private final String baseUrl;

    public WebGetter(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private String makeGet(String stringURL) {
        String[] schemes = {"http", "https"};
        String content = "";
        String validString = validate(stringURL, baseUrl);
        UrlValidator urlValidator = new UrlValidator(schemes);
        if (urlValidator.isValid(stringURL)) {
            try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
                HttpGet getRequest = new HttpGet(validString);
                LOGGER.info("making GET request");
                HttpResponse response = httpclient.execute(getRequest);
                if (response.getStatusLine()
                            .getStatusCode() == 200) {
                    HttpEntity entity = response.getEntity();
                    content = EntityUtils.toString(entity);
                } else {
                    HttpEntity entity = response.getEntity();
                    String message = EntityUtils.toString(entity);
                    LOGGER.error("the requested repository returned a {} status \n with the message: {}", response.getStatusLine()
                                                                                                                  .getStatusCode(), message);
                }
            } catch (IOException e) {
                LOGGER.error("call failed with response: \n {}", e.getMessage());
                content = "";
            }
        }
        return content;
    }

    @Override
    public String communicate(String endpoint) {
        return makeGet(endpoint);
    }
}
