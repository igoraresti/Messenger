package org.iaresti.messenger.database;

import org.iaresti.messenger.model.Comment;
import org.iaresti.messenger.model.Message;
import org.iaresti.messenger.model.Profile;

import java.util.*;

public class Database {

    private static Map<String, Message> messages = new HashMap<>();
    private static Map<String, Profile> profiles = new HashMap<>();
    private static Map<String, Comment> comments = new HashMap<>();

    private Database() {
        messages.put("1", new Message("1", "Hola 1", "Igor"));
        comments.put("1", new Comment("1", "Buena API", "Moe"));
        messages.get("1").setComments(comments);
        messages.put("2", new Message("2", "Hola 2", "Igor"));
        profiles.put("iaresti", new Profile("1", "iaresti", "Igor", "Aresti"));
        profiles.put("aferro", new Profile("2", "aferro", "Armando", "Ferro"));
    }

    private static class SingletonHolder {
        private static final Database INSTANCE = new Database();
    }

    public static Database getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //Acceso a Message
    public List<Message> getMessages() {
        return new ArrayList<Message>(messages.values());
    }

    public List<Message> getMessagesForYear(int year) {
        List<Message> messagesForYear = new ArrayList<Message>();
        Calendar calendar = Calendar.getInstance();
        for (Message message : messages.values()) {
            calendar.setTime(message.getCreated());
            if (calendar.get(Calendar.YEAR) == year)
                messagesForYear.add(message);
        }
        return messagesForYear;
    }

    public Message getMessage(String messageId) {
        return messages.get(messageId);
    }

    public Message addMessage(Message message) {
        final String id = message.getId() == null ? UUID.randomUUID().toString() : message.getId();
        message.setId(id);
        messages.put(id, message);
        return message;
    }

    public Message updateMessage(Message message) {
        if (message.getId().isEmpty()) {
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(String id) {
        return messages.remove(id);
    }

    //Acceso a Comments
    public List<Comment> getAllComments(String messageId) {
        return new ArrayList<Comment>(messages.get(messageId).getComments().values());
    }

    //Acceso de Profiles
    public List<Profile> getAllProfiles() {
        return new ArrayList<Profile>(profiles.values());
    }

    public Profile getProfile(String profileName) {
        return profiles.get(profileName);
    }

    public Profile addProfile(Profile profile) {
        final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        profile.setId(uuid);
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile updateProfile(Profile profile) {
        if (profile.getProfileName().isEmpty()) {
            return null;
        }
        profiles.put(profile.getProfileName(), profile);
        return profile;
    }

    public Profile removeProfile(String profileName) {
        return profiles.remove(profileName);
    }

}