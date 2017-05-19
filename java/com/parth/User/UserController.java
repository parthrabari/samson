package com.parth.User;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;

	@RequestMapping("/api/users")
	public List<Users> all(){
		return userservice.allusers();
	}
	
	@RequestMapping("/api/users/{id}")
	public Users getOne(@PathVariable int id){
		return userservice.getOne(id);
	}
	
	@RequestMapping(value="/api/addusers", method=RequestMethod.POST)
	public ResponseEntity<Void> addUser(@RequestBody Users user) {
	
		userservice.addOne(user);
		final URI location = ServletUriComponentsBuilder.
				fromCurrentServletMapping().path("/api/users/{id}").build()
				.expand(user.getId()).toUri();
		
		final HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		
		final ResponseEntity<Void> entity = new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		
		return entity;
	}
	
	@RequestMapping(value = "/api/users/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> save(@PathVariable int id){
		try{
			userservice.deleteOne(id);		
			return ResponseEntity.accepted().build();
		}
		catch(ResourceNotFoundException e){
			return ResponseEntity.notFound().build();
		}
		
 	}


}
