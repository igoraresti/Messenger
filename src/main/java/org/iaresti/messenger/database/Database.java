package org.iaresti.messenger.database;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.iaresti.messenger.model.*;

public class Database {
	
	private static Map<String, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	private static Map<String, Comment> comments = new HashMap<>();
	
	private Database(){
		messages.put("1", new Message("1", "Hola 1", "Igor")) ;
		comments.put("1", new Comment("1","Buena API","Moe"));
		messages.get("1").setComments(comments);
		messages.put("2", new Message("2", "Hola 2", "Igor"));
	}
	
	private static class SingletonHolder { 
	    private static final Database INSTANCE = new Database();
	}
	
	public static Database getInstance() {
	    return SingletonHolder.INSTANCE;
	}
	
	public ArrayList<Message> getMessages() {
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getMessagesForYear(int year){
		List <Message> messagesForYear = new ArrayList<Message>();
		Calendar calendar = Calendar.getInstance();
		for(Message message : messages.values()){
			calendar.setTime(message.getCreated());
			if(calendar.get(Calendar.YEAR) == year)
				messagesForYear.add(message);
		}
		return messagesForYear;
	}
	
	public Message getMessage(String messageId){
		return messages.get(messageId);
	}
	
	public Message addMessage(Message message){
		final String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		message.setId(uuid);
		messages.put(uuid, message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId().isEmpty()){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(String id){
		return messages.remove(id);
	}
	
	public List<Comment> getAllComments(String messageId){
		return new ArrayList<Comment>(messages.get(messageId).getComments().values());
	}
	public Map<String, Profile> getProfiles() {
		return profiles;
	}
}