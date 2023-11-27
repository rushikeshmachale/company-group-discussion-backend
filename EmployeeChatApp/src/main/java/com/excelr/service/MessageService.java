package com.excelr.service;

import java.util.List;

import com.excelr.entity.Messages;

public interface MessageService {

	Messages addMessage(Messages message);
	List<Messages> getAllMessages();
	Messages getMessageById(int id);
	String deleteMessageById(int id);
	String updateMessageById(int id, Messages message);
}
