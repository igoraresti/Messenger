package org.iaresti.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.iaresti.messenger.model.Message;
import org.iaresti.messenger.resources.beans.MessageFilterBean;
import org.iaresti.messenger.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService messageService = new MessageService();

	@GET
	public List<Message> getMessage(@BeanParam MessageFilterBean filterBean){
		if(filterBean.getYear() > 0)
			return messageService.getAllMessagesForYear(filterBean.getYear());
		return messageService.getAllMessages();
	}
	
	
	@POST
	public Message addMessage(Message message){
		return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long messageId,Message message){
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long messageId,Message message){
		messageService.removeMessage(messageId);
	}
	
	
	@GET
	@Path("/{messageId}")
	//Jersey realiza la conversion String a Long, no es necesario parsear
	public Message getSingleMessage(@PathParam("messageId") long messageId){
		return messageService.getMessage(messageId);
	}
	
	//Aqui se define un subrecurso, para cualquier tipo de petición a este path trabaja la clase CommentResource
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}
}

/*
 * APUNTES REST
 * 
 * Tipos de parámetros:
 * 	-@PathParam se pone en la url con '/'
 * 	-@Queryparam se pone en la url con '?' seguido de "parametro=valor"
 * 	-@MatrixParam se pone en la url con ';' seguido de "parametro=valor"
 * 	-@HeaderParam se pone en el header de la petición HTTP
 * 	-@CookieParam se pone en las cookies de la petición HTTP
 * 	-@FormParam se utiliza para formularios de html
 * 
 * Para recursos con muchos parámetros se usará:
 * 
 * 	-@BeanParam que mapea una clase tipo Bean
 * 
 * Anotación Context:
 * 	-@context se utiliza para clases como UriInfo o HttpHeaders para acceder a datos de la url y cabecera respectivamente
*/
