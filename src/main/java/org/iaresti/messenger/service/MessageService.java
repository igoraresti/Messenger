package org.iaresti.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.iaresti.messenger.database.Database;
import org.iaresti.messenger.model.*;

public class MessageService {
	
	private Map<String, Message> messages = Database.getMessages();
	private Map<String,Comment> comments = new HashMap<>();
	
	public MessageService(){
		messages.put("1", new Message("1", "Hola 1", "Igor")) ;
		comments.put("1", new Comment("1","Buena API","Moe"));
		messages.get("1").setComments(comments);
		messages.put("2", new Message("2", "Hola 2", "Igor")) ;
	}
	
	/*
	public List<Message> getAllMessages(){
		Message m1 = new Message(1L, "Hola 1", "Igor");
		Message m2 = new Message(2L, "Hola 2", "Igor");
		List<Message> list = new ArrayList<>();
		list.add(m1);
		list.add(m2);
		return list;
	}
	*/
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List <Message> messagesForYear = new ArrayList<>();
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
	

}

