package com.excelr.service;

import java.util.List;

import com.excelr.entity.Employee;


public interface GroupEmployeeService {
	
	public void addEmployeeToGroup(int group_id,int employee_id);
	public void addEmployeesToGroup(int group_id,List<Integer> employee_ids);
	void removeEmployeeFromGroup(int group_id, int employee_id);
	List<Employee> getEmployeeByGroupId(int group_id);

}
