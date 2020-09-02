package com.pringTest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pringTest.demo.entity.Employee;
import com.pringTest.demo.service.EmployeeService;

@RestController
public class EmployeeController {
   @Autowired 
   EmployeeService employeeService;
	
   // Get all employees
	@GetMapping("/employeeList")
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}
	//Get employee by Id
	@GetMapping("/employeeById/{id}")
	public Employee getEmployee(@PathVariable int id){
		return employeeService.getEmployee(id);
	}
	//Save employee
   @PostMapping("/addEmployee")
   public Employee saveEmployee(@RequestBody Employee employee) {
	   return employeeService.saveEmployee(employee);
   } 
   
 //Save all employees
   @PostMapping("/addEmployees")
   public List<Employee> saveAllEmployee(@RequestBody List<Employee> employees) {
	   return employeeService.saveEmployees(employees);
   } 
	// Update employee
	@PutMapping("/updateEmployee")
	 public Employee updateEmployee(@RequestBody Employee employee) {
		   return employeeService.updateEmployee(employee);
	   } 
	//Delete employee
	@DeleteMapping("/deleteEmployee/{id}")
	 public String deleteEmployee(@PathVariable int id)	{
		 return employeeService.deleteEmployee(id);
	 }
	
}
