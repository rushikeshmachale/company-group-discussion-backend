package com.excelr.service.impl;

import java.util.List;
import java.util.Optional;

import com.excelr.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.entity.Messages;
import com.excelr.entity.MyGroup;
import com.excelr.repository.MessageRepository;
import com.excelr.repository.MyGroupRepository;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	MessageRepository messageRepository;
	
	@Autowired
	MyGroupRepository myGroupRepository;

	
	
	@Override
	public Messages getMessageById(int id) {
		Optional<Messages> optionalMessage = messageRepository.findById(id);
		Messages message1 = null;
		
		if(optionalMessage.isPresent()) {
			message1=optionalMessage.get();
		}
		
		return message1;
	}

	@Override
	public String deleteMessageById(int id) {
		String msg="";
		if(messageRepository.existsById(id)) {
			messageRepository.deleteById(id);
			msg="message deleted";
		}else {
			msg="message id not found to delete";
		}
		return msg;
	}

	@Override
	public String updateMessageById(int id, Messages message) {
		
		String msg = "";
		
		if(messageRepository.existsById(id)) {
			Messages message2 = messageRepository.findById(id).get();
			message2.setId(message.getId());
			message2.setEmployee(message.getEmployee());
			message2.setGroup(message.getGroup());
			message2.setText(message.getText());
			message2.setLocalDateTime(message.getLocalDateTime());
			
			messageRepository.save(message2);
			msg="message successfully updated";
		}else {
			msg="no id found to update";
		}
	 return msg;	
		
	}


//	@Override
//	public List<Messages> getAllMessagesByGroupId(int groupid) {
//		MyGroup group = myGroupRepository.findById(groupid).get();
//		if(group!=null) {
//			return group.getMessages();
//		}
//		return null;
//	}

	@Override
	public Messages addMessage(Messages message) {
		Messages messages = messageRepository.save(message);
		return messages;
	}

}
