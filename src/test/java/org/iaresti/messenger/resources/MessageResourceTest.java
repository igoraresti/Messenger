package org.iaresti.messenger.resources;

import org.iaresti.messenger.model.Message;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class MessageResourceTest extends IntegrationTest {

    @Test
    public void should_create_message() {
        Message message = new Message("one", "hola caracola", "Paco");
        Entity<Message> userEntity = Entity.entity(message, MediaType.APPLICATION_JSON_TYPE);
        Response response = target.path("messages").request().post(userEntity);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }
}