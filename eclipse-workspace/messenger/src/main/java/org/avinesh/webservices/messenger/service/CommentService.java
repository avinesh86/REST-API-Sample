package org.avinesh.webservices.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;


import org.avinesh.webservices.messenger.database.DatabaseClass;
import org.avinesh.webservices.messenger.model.Comment;
import org.avinesh.webservices.messenger.model.Message;

public class CommentService {

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public List<Comment> getAllComments(long messageId){
		Map<Long, Comment> comments = messages.get(messageId).getAllComments();
		return new ArrayList<Comment>(comments.values());
	}
	
	public Comment getComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getAllComments();
		return comments.get(commentId);
	}
	
	public Comment addComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getAllComments();
		comment.setId(comments.size() + 1);
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment) {
		Map<Long, Comment> comments = messages.get(messageId).getAllComments();
		if(comment.getId()<=0) {
			return null;
		}
		
		comments.put(comment.getId(), comment);
		return comment;
	}
	
	public Comment removeComment(long messageId, long commentId) {
		Map<Long, Comment> comments = messages.get(messageId).getAllComments();
		return comments.remove(commentId);
	}
}
