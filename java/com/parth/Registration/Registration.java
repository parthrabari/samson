package com.parth.Registration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.parth.Events.Event;
import com.parth.User.Users;

@Entity	
public class Registration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Users users;
	
	@ManyToOne
	private Event event;
	
	private int tikcnt;
	
	public Registration() {
		// TODO Auto-generated constructor stub
	}

	public Registration(Users users, Event event, int tikcnt) {
		super();
		this.users = users;
		this.event = event;
		this.tikcnt = tikcnt;
	}

	
	public int getId() {
		return id;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public int getTikcnt() {
		return tikcnt;
	}

	public void setTikcnt(int tikcnt) {
		this.tikcnt = tikcnt;
	}
	
	
}
