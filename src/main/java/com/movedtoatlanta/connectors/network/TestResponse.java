package com.movedtoatlanta.connectors.network;

import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

import java.io.InputStream;

/**
 * @project service-point
 * @created 2020-September-09
 */

public class TestResponse {
    private final HttpResponse response;

    public TestResponse(InputStream is, String protocol, int major, int minor, int statusCode, String statusMessage) {
        ProtocolVersion protocolVersion = new ProtocolVersion(protocol, major, minor);
        StatusLine statusLine = new BasicStatusLine(protocolVersion, statusCode, statusMessage);
        response = new BasicHttpResponse(statusLine);
        BasicHttpEntity basicHttpEntity = new BasicHttpEntity();
        basicHttpEntity.setContent(is);
        response.setEntity(basicHttpEntity);
    }

    public HttpResponse getResponse() {
        return response;
    }

}
