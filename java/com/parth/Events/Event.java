package com.parth.Events;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eid;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}
	
	public Event(int id,String name, Date date, String location, String type) {
		super();
		this.eid =id;
		this.name = name;
		this.date = date;
		this.location = location;
		this.type = type;
	}
	private String name;
	@Temporal(TemporalType.DATE)
	private Date date;
	private String location;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return eid;
	}

	

}
