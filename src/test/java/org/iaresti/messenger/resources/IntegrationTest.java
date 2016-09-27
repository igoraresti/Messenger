package org.iaresti.messenger.resources;

import org.glassfish.grizzly.http.server.HttpServer;
import org.iaresti.messenger.Server;
import org.junit.After;
import org.junit.Before;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class IntegrationTest {
    protected HttpServer server;
    protected WebTarget target;

    @Before
    public void setUp() throws Exception {
        server = Server.startServer();
        Client c = ClientBuilder.newClient();
        target = c.target(Server.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.shutdown();
    }

}
