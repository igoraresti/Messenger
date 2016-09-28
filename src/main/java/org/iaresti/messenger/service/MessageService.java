package org.iaresti.messenger.service;

import org.iaresti.messenger.database.Database;
import org.iaresti.messenger.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageService {

    private Database database = Database.getInstance();

    public List<Message> getAllMessages() {
        return new ArrayList<>(database.getMessages());
    }

    public List<Message> getAllMessagesForYear(int year) {
        return new ArrayList<>(database.getMessagesForYear(year));
    }

    public Message getMessage(String messageId) {
        return database.getMessage(messageId);
    }

    public Message addMessage(Message message) {
        return database.addMessage(message);
    }

    public Message updateMessage(Message message) {
        return database.updateMessage(message);
    }

    public Message removeMessage(String id) {
        return database.removeMessage(id);
    }


}

