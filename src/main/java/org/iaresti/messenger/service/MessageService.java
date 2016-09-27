package org.iaresti.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.iaresti.messenger.database.Database;
import org.iaresti.messenger.model.*;

public class MessageService {
	
	private Map<Long, Message> messages = Database.getMessages();
	private Map<Long,Comment> comments = new HashMap<>();
	
	public MessageService(){
		messages.put(1L, new Message(1, "Hola 1", "Igor")) ;
		comments.put(1L, new Comment(1,"Buena API","Moe"));
		messages.get(1L).setComments(comments);
		messages.put(2L, new Message(2, "Hola 2", "Igor")) ;
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
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id){
		return messages.remove(id);
	}
	

}

