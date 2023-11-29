package com.excelr.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Messages;

import com.excelr.service.MessageService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class MessageController {

	@Autowired
	MessageService messageService;
	
	@PostMapping("/message")
	public ResponseEntity<Messages> addMessage(@RequestBody Messages message)
	{
		return new ResponseEntity<Messages>(messageService.addMessage(message), HttpStatus.OK);
		
	}
	
	@GetMapping("/message")
	public ResponseEntity<List<Messages>> getAllMessages(){
		return new ResponseEntity<List<Messages>>(messageService.getAllMessages(),HttpStatus.OK);
		
	}
	@GetMapping("/message/{id}")
	public ResponseEntity<Messages> getMessageById(@PathVariable int id)
	{
		return new ResponseEntity<Messages>(messageService.getMessageById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/message/{id}")
	public ResponseEntity<String> deleteMessage(@PathVariable int id)
	{
		return new ResponseEntity<String>(messageService.deleteMessageById(id), HttpStatus.OK);
	}
	 
	@PutMapping("/message/{id}")
	public ResponseEntity<String> updateMessage(@PathVariable int id, @RequestBody Messages message)
	{
		return new ResponseEntity<String>(messageService.updateMessageById(id, message), HttpStatus.OK);
	}
	
	
	
	
}

