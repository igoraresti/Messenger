package org.iaresti.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.iaresti.messenger.database.Database;
import org.iaresti.messenger.model.Comment;
import org.iaresti.messenger.model.Message;

public class CommentService {
	
	private Map<String, Message> messages = Database.getMessages();
	
	public List<Comment> getAllComments(String messageId){
		Map<String,Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	

}
