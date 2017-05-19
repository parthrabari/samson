package com.parth.Events;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
	@Autowired
	private EventRepository eventRepository;
	
	public List<Event> findAll() {
		List<Event> events = new ArrayList<>();
		eventRepository.findAll().
			forEach(events::add);
		return  events;
	}
	
	public Event findOne(int id) {
		return eventRepository.findOne(id);
	}	
	
	public void addOne(Event event) {
		eventRepository.save(event);
	}
	
	public void deleteOne(int id) {
		eventRepository.delete(id);;
	}

}
