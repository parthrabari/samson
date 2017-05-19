package com.parth.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<Users> allusers() {
		List<Users> users = new ArrayList<>();
		List<Users> reusers= new ArrayList<>();
		
		userRepository.findAll().forEach(users::add);
		for(Users x :users){
			Users users2 = new Users();
			
			users2.setId(x.getId());
			users2.setName(x.getName());
			users2.setEmail(x.getEmail());
			users2.setIcard(x.getIcard());
			users2.setMobile(x.getMobile());
			
			users2.setRole(x.getRole());
			reusers.add(users2);
		}
		return reusers;
	}
	
	public Users getOne(int id) {
	
		return userRepository.findOne(id);
	}
	
	public void addOne(Users user){
		userRepository.save(user);
	}
	
	public void deleteOne(int id) {
		userRepository.delete(id);;
	}

	
}
