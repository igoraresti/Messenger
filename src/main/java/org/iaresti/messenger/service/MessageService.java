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
	
	private Database database = Database.getInstance();
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(database.getMessages());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		return new ArrayList<Message>(database.getMessagesForYear(year));
	}
	
	public Message getMessage(String messageId){
		return database.getMessage(messageId);
	}
	
	public Message addMessage(Message message){
		return database.addMessage(message);
	}
	
	public Message updateMessage(Message message){
		return database.updateMessage(message);
	}
	
	public Message removeMessage(String id){
		return database.removeMessage(id);
	}
	

}

