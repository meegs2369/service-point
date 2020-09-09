package com.movedtoatlanta.connectors.network;

import org.mockserver.integration.ClientAndServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @project service-point
 * @created 2020-September-09
 */

public class TestMockServer {
    private static final Logger LOGGER= LoggerFactory.getLogger(TestMockServer.class);
    private static final String PROXY_HOST = "http.proxyHost";
    private static final String PROXY_PORT = "http.proxyPort";
    private final ClientAndServer proxy;


    public TestMockServer(){
        LOGGER.info("Instantiating proxy server with port: {}",4080);
        this.proxy = ClientAndServer.startClientAndServer(4080);
        System.setProperty(PROXY_HOST, "127.0.0.1");
        System.setProperty(PROXY_PORT,this.proxy.getLocalPort().toString());
    }

    public ClientAndServer startMockServer(Integer localPort){
        return this.reload(localPort);
    }

    private ClientAndServer reload(Integer localPort) {
        ClientAndServer mock = ClientAndServer.startClientAndServer(localPort);
        this.proxy.reset();
        return mock;
    }


    public void shutdownTestMockServer(){
        LOGGER.info("Stopping Proxy");
        this.proxy.stop();
        LOGGER.info("Releasing system");
        System.clearProperty(PROXY_HOST);
        System.clearProperty(PROXY_PORT);
    }
}
