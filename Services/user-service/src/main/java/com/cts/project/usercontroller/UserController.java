package com.cts.project.usercontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.userservice.User;
import com.cts.project.userservice.UserRepo;
import com.cts.project.userservice.UserService;


@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserService userService;

	@Autowired
	JavaMailSender jms;

	@GetMapping("/user/activate/{code}")
	public User getUserByCode(@PathVariable long code) {
		User u=userService.getUserByCodes(code);
		return u;
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public ResponseEntity<User> save(@RequestBody User user){
		userService.insert(user);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> update(@RequestBody User user){
		userService.update(user);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable int id){
		userService.deleteById(id);
	}
	
	@GetMapping("/user")
	public ResponseEntity<?> getUsers() {
		List<User> userList=userService.getAllUsers();
		if(userList.size()>0) {
			return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No Users in the list", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUserWithId(@PathVariable int id){
		User user=userService.getUserById(id);
		return new ResponseEntity<User>(user,HttpStatus.CREATED);
	}
}
