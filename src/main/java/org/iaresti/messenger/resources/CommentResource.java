package org.iaresti.messenger.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.iaresti.messenger.model.Comment;
import org.iaresti.messenger.service.CommentService;

@Path("/")
public class CommentResource {
	
	private CommentService commentService = new CommentService();
	
	@GET
	public String getComment(){
		return "Se ha creado el subresource";
	}
	
	@GET
	@Path("/{commentId}")
	public List<Comment> getCommentById(@PathParam("messageId") String messageId,@PathParam("commentId") long commentId){
		return commentService.getAllComments(messageId);
	}

}
