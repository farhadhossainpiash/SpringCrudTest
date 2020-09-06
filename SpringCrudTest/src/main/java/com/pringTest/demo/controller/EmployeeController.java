package com.pringTest.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pringTest.demo.entity.Employee;
import com.pringTest.demo.service.EmployeeService;

@RestController
public class EmployeeController {
   @Autowired 
   EmployeeService employeeService;
   
   @RequestMapping(value = "/employees", method = RequestMethod.POST)
	public ResponseEntity<Object> createEmployee(@RequestBody Employee employee)
	{
		System.out.println("Inside createEmployee method of SpringBootDemo Application");
		employee = employeeService.saveEmployee(employee);
		return new ResponseEntity<>(
				"Employee is created successfully with Id = " + employee.getId(),
				HttpStatus.CREATED);
	}
   
   // Get all employees
  	@GetMapping("/employeeList")  	
  	public ResponseEntity<List<Employee>> getEmployees(){
  		return new ResponseEntity<>(employeeService.getEmployees(),HttpStatus.FOUND);
  	}
  	
  //Delete employee
  	
  	@DeleteMapping("/deleteEmployee/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id)
	{
			employeeService.deleteEmployee(id);
			return new ResponseEntity<>("Employee is deleted successsfully", HttpStatus.OK);
	}
  	
  //Get employee by Id
  	@GetMapping("/employeeById/{id}")
  	public ResponseEntity<Employee> getEmployee(@PathVariable int id){
  		return new ResponseEntity<>(employeeService.getEmployee(id),HttpStatus.FOUND);
  	}
	
}
