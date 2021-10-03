package com.sportyShoes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.sportyShoes.model.User;
import com.sportyShoes.service.userRepository;

@RestController
@RequestMapping("/User")
public class UserController 
{
	@Autowired
	userRepository repo;
	
	@RequestMapping("/getAllUser")
	public List<User> getUser() 
	{
		List<User> users = new ArrayList<User>();
		repo.findAll().forEach(users::add);
		return users;
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/addUser")
	public String addUser(@RequestBody User user)
	{
		 repo.save(user);
		 return "User is added";
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/editPass/{email}/{oldpass}/{newpass}")
	public String editPassword(@PathVariable String email,@PathVariable String oldpass,@PathVariable String newpass)
	{
		 User user = repo.findByEmail(email);
		 if(user.getPassword().equals(oldpass))
			 user.setPassword(newpass);
		 else
			 return "Password is not changed";
		 repo.save(user);
		 return "Password is changed";
	}
}
