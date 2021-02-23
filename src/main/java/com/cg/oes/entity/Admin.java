package com.cg.oes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="admin_detail")
public class Admin {
	@Id
	private int id;
	@Column(length=20)
	private String name;
	@Column(length=20)
	private String password;

	public Admin() {
		
	}
	/**
	*Admin()
	*description of method: creates admin object
	*parameters: int id, String name, String password
	*returntype: Admin  
	*method Type: contructor
	*authorName: Ruchi
	*version 1.0
	*/

	public Admin(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", password=" + password + "]";
	}
	
}
