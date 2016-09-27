package org.iaresti.messenger.resources;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatusResourceTest extends IntegrationTest {

    @Test
    public void should_get_status() {
        String responseMsg = target.path("status").request().get(String.class);
        assertEquals("Messenger up and running !", responseMsg);
    }
}