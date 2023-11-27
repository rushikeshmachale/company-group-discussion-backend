package com.excelr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.entity.Employee;
import com.excelr.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController  {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/login")
	public ResponseEntity<String> validateLogin(@RequestParam String username,@RequestParam String password){
		
		boolean isValidLogin = employeeService.validateLogin(username, password);
		
		if(isValidLogin) {
			
			String role = employeeService.getRoleByUsername(username, password);
			return ResponseEntity.ok(role);
		}
		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
		}
		
	}
	
	
	@GetMapping
	public ResponseEntity<List<Employee>> getAllEmps(){
		
		return new ResponseEntity<List<Employee>>(employeeService.gelAllEmps(),HttpStatus.OK);
	}

}
