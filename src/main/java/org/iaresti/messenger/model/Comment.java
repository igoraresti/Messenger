package org.iaresti.messenger.model;

import java.util.Date;

public class Comment {
	
	private String id;
	private String message;
	private Date created;
	private String author;
	
	public Comment()
	{
		
	}
	public Comment(String string, String message, String author) {
		this.id = string;
		this.message = message;
		this.author = author;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	

}
