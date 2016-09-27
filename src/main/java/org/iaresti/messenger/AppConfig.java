package org.iaresti.messenger;

import org.glassfish.jersey.server.ResourceConfig;

public class AppConfig extends ResourceConfig {
    public AppConfig() {
        packages("org.iaresti.messenger.resources");
    }
}
