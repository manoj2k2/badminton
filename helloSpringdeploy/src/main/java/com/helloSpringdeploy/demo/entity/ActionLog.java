package com.helloSpringdeploy.demo.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ActionLog {
	 @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	   private Integer id;
	  public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getDateOn() {
		return DateOn;
	}
	public void setDateOn(Date dateOn) {
		DateOn = dateOn;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	private String name;
	  private String comment;
	  private Date DateOn;
	  private Float balance = 0f;
}
