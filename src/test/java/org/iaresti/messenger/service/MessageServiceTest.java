package org.iaresti.messenger.service;

import org.iaresti.messenger.model.Message;
import org.junit.Test;

import static org.junit.Assert.*;

public class MessageServiceTest {

    private MessageService service = new MessageService();

    @Test
    public void can_create() {

        Message message = new Message("id", "foo", "bar");
        service.addMessage(message);

        Message existingMessage = service.getMessage("id");

        assertNotNull(existingMessage);
    }
}