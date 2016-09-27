package org.iaresti.messenger;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

public class Server {

    public static final String BASE_URI = "http://localhost:9998/";

    public static HttpServer startServer() {
        URI baseUri = UriBuilder.fromUri(BASE_URI).build();
        ResourceConfig config = new AppConfig();
        return GrizzlyHttpServerFactory.createHttpServer(baseUri, config);
    }

    public static void main(String[] args) throws IOException {
        HttpServer server = startServer();

        System.out.println(String.format("Servidor UP !! %s\n Pulsa enter para parar...", BASE_URI));
        System.in.read();
        server.shutdownNow();
    }
}
