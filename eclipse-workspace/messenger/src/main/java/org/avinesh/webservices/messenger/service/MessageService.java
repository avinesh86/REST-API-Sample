package org.avinesh.webservices.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.avinesh.webservices.messenger.database.DatabaseClass;
import org.avinesh.webservices.messenger.model.Message;
import org.avinesh.webservices.messenger.model.Profile;

public class MessageService {
	

	private Map<Long, Message> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1L, new Message(1L, "Hello world!", "Avinesh"));
		messages.put(2L, new Message(2L, "Hello JErsey!", "Avinesh"));
		
	}
	
	public List<Message> getMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message: messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(cal.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getMessagesPaginated(int start, int size){
		List<Message> messagesPaginated = new ArrayList<Message>(messages.values());
		if((start + size) > messages.size())
			return new ArrayList<Message>();
		
		return messagesPaginated.subList(start, start + size);
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId()<=0) {
			return null;
		}
		
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
}
