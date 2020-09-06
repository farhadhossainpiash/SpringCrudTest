package com.pringTest.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pringTest.demo.entity.Employee;
import com.pringTest.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
  @Autowired
  EmployeeRepository employeeRepository;
  
  public Employee saveEmployee(Employee employee) {
	  
	  return employeeRepository.save(employee);
  }
  
  public List<Employee> saveEmployees(List<Employee> employees) {
	  
	  return employeeRepository.saveAll(employees);
  }
  
  public void deleteEmployee(int id) {
	 // after delete can not find the data by delete id
	  // for this reason return void
	  employeeRepository.deleteById(id);
	  }
  
  public Employee getEmployee(int id) {
	  
	  return employeeRepository.findById(id).orElse(null);
  }
  
 public List<Employee> getEmployees() {
	  
	  return employeeRepository.findAll();
  }
 
 public Employee updateEmployee (Employee employee) {
	 Employee existingEmployee = employeeRepository.findById(employee.getId()).orElse(null);
	 existingEmployee.setName(employee.getName());
	 existingEmployee.setEmail(employee.getEmail());
	 existingEmployee.setAddress(employee.getAddress());
	
	 return employeeRepository.save(existingEmployee);
 }

}
