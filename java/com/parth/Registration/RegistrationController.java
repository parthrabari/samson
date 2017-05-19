package com.parth.Registration;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins = "*")
@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@RequestMapping("api/regs")
	public List<Registration> all(){
		return service.getAll();
	}
	
	@RequestMapping("/api/regs/{id}")
	public Registration getOne(@PathVariable int id){
		return service.getOne(id);
	}
	
	@RequestMapping(value="/api/register", method=RequestMethod.POST)
	public ResponseEntity<Void> addReg(@RequestBody RegJson json) {
		
		int eid =  json.getEid();
		int id  =  json.getId();
		int tikcnt = json.getTikcnt();
	
		Registration registration = service.addOne(eid,id,tikcnt);
		
		final URI location = ServletUriComponentsBuilder.
				fromCurrentServletMapping().path("/api/regs/{id}").build()
				.expand(registration.getId()).toUri();
		
		final HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		headers.setAccessControlAllowOrigin("*");
		
		final ResponseEntity<Void> entity = new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		
		return entity;
	}
	
	@RequestMapping(value="/api/register/{regid}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delReg(@PathVariable int regid) {
	
		service.delOne(regid);
		
		final ResponseEntity<Void> entity = new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		
		return entity;
	}

}
