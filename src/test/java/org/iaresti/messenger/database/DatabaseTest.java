package org.iaresti.messenger.database;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.iaresti.messenger.model.Message;
import org.junit.Test;

import junit.framework.Assert;

public class DatabaseTest {
	
	@Test
	public void databaseGetMessageTest(){
		Message messageDatabase = Database.getInstance().getMessage("1");
		Assert.assertEquals("Hola 1",messageDatabase.getMessage());
	}
	
	@Test
	public void databaseGetMessageForYearTest(){
		List<Message> messagesDatabase = Database.getInstance().getMessagesForYear(Calendar.YEAR);
		Calendar calendar = Calendar.getInstance();
		
		for(Message message: messagesDatabase){
			calendar.setTime(message.getCreated());
			Assert.assertEquals(Calendar.YEAR, calendar.get(Calendar.YEAR));
		}
	}
	
	@Test
	public void databaseAddMessageTest(){
		Message message = new Message("Prueba","Moe");
		Database database = Database.getInstance();
		database.addMessage(message);
		Assert.assertEquals(message, database.getMessage(message.getId()));
	}
	
	@Test
	public void databaseUpdateMessage(){
		Database database = Database.getInstance();
		Assert.assertEquals(null, database.getMessage("-1"));
		Message message = new Message("1", "Adios 1", "Igor");
		database.updateMessage(message);
		Assert.assertEquals("Adios 1", database.getMessage("1").getMessage());
	}
	
	@Test
	public void removeMessage(){
		Database database = Database.getInstance();
		database.removeMessage("1");
		Assert.assertEquals(null, database.getMessage("1"));
	}

}
