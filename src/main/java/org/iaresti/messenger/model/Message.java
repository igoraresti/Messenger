package org.iaresti.messenger.model;

import javax.ws.rs.client.Entity;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@XmlRootElement
public class Message {

    private long id;
    private String message;
    private Date created;
    private String author;
    private Map<Long, Comment> comments = new HashMap<>();

    public Message() {

    }

    public Message(long id, String message, String author) {
        super();
        this.id = id;
        this.message = message;
        this.created = new Date();
        this.author = author;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, created, author);
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.deepEquals(this, obj);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @XmlTransient
    public Map<Long, Comment> getComments() {
        return comments;
    }

    public void setComments(Map<Long, Comment> comments) {
        this.comments = comments;
    }


}
