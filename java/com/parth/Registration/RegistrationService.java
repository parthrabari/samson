package com.parth.Registration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parth.Events.Event;
import com.parth.Events.EventRepository;
import com.parth.User.UserRepository;
import com.parth.User.Users;

@Service
public class RegistrationService {

	@Autowired
	private RegistrationRepository repository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Registration> getAll(){
		List<Registration> regs = new ArrayList<>();
		
		repository.findAll().forEach(regs::add);
		
		return regs;
	}
	
	public Registration addOne(int eid, int id,int tikcnt){
		Registration registration = new Registration();
		
		Event event = null;
		event = eventRepository.findOne(eid);
		
		Users user = null;
		user = userRepository.findOne(id);
		
		registration.setEvent(event);
		registration.setTikcnt(tikcnt);
		registration.setUsers(user);
		try{
			repository.save(registration);
			return registration;
		}
		catch(Exception e){
			return null;
		}		
	}

	public Registration getOne(int id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

	public void delOne(int regid) {
		// TODO Auto-generated method stub
		repository.delete(regid);
	}
}
