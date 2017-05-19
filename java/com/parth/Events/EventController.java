package com.parth.Events;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorViewResolver;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class EventController {
	
	@Autowired
	private EventService eventservice;
	
	@Bean
	ErrorViewResolver supportPathBasedLocationStrategyWithoutHashes() {
	    return new ErrorViewResolver() {
	        @Override
	        public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
	            return status == HttpStatus.NOT_FOUND
	                    ? new ModelAndView("index.html", Collections.<String, Object>emptyMap(), HttpStatus.OK)
	                    : null;
	        }
	    };
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping("/api/events")
	public List<Event> all(){
		return eventservice.findAll();		
	}
	
	@RequestMapping("/api/events/{id}")
	public Event one(@PathVariable int id){
		return eventservice.findOne(id);		
	}
	
	@RequestMapping(value = "/api/addevents", method=RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Event event){
		eventservice.addOne(event);		
		
		final URI location = ServletUriComponentsBuilder.
				fromCurrentServletMapping().path("/api/events/{id}").build()
				.expand(event.getId()).toUri();
		
		final HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		
		final ResponseEntity<Void> entity = new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		
		return entity; 
 	}
	
	@RequestMapping(value = "/api/events/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> save(@PathVariable int id){
		try{
			eventservice.deleteOne(id);		
			return ResponseEntity.accepted().build();
		}
		catch(ResourceNotFoundException e){
			return ResponseEntity.notFound().build();
		}
		
 	}

	
	
}
