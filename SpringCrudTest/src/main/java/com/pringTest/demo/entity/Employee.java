package com.pringTest.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {
   
    @Id
    @GeneratedValue
	private int eid;
	private String eName;
	private String address;
	private String email;
	
	
	public Employee() {
		super();
		
	}
	public Employee(String eName, String address, String email) {
		super();
		this.eName = eName;
		this.address = address;
		this.email = email;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
