package org.iaresti.messenger.service;

import java.util.List;

import org.iaresti.messenger.database.Database;
import org.iaresti.messenger.model.Comment;
import org.iaresti.messenger.model.Message;

public class CommentService {
	
	private Database database = Database.getInstance();
	
	public List<Comment> getAllComments(String messageId){
		return database.getAllComments(messageId);
	}
}
