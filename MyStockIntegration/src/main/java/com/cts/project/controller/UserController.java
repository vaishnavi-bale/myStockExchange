package com.cts.project.controller;

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

import com.cts.project.bean.User;
import com.cts.project.dto.UserDTO;
import com.cts.project.repo.UserRepo;
import com.cts.project.services.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	UserService userService;

	@Autowired
	JavaMailSender jms;

//	@GetMapping("/user")
//	public List<User> getUsers() {
//		return userRepo.findAll();
//	}

//	@GetMapping("user/{id}")
//	public User getUserById(@PathVariable int id) {
//		Optional<User> userList = userRepo.findById(id);
//		User user = userList.get();
//		return user;
//	}

//	@PostMapping("/user")
//	public User saveUser(@RequestBody User user) {
//		User newUser = userRepo.save(user);
//		try {
//			SimpleMailMessage sm = new SimpleMailMessage();
//			sm.setFrom("vaishnavi.bale05@gmail.com");
//			sm.setTo("vaishnavi.bale05@gmail.com");
//			sm.setSubject("Verification Mail");
//			sm.setText(" Hello "+newUser.getUserName()+"\n Account created!! \n click on <a href='http://localhost:4200/user/activate?code=" + newUser.getCode()
//					+ "'>Click</a>");
//			jms.send(sm);
//			System.out.println("Sending mail...");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		newUser.setRegisterStatus("ok");
//		return newUser;
//	}

//	@RequestMapping(value="/activate",method=RequestMethod.PUT)
//	public String activate(@RequestBody String email) {
//		String str=email.substring(email.indexOf(":")+2,email.lastIndexOf("\""));
//	    System.out.println("emil ::"+str);
//	    User u=	userDAO.findByEmail(str);
//	    System.out.println("uname :"+u.getUserName());
//	    u.setActive("yes");
//		User us = userDAO.save(u);
//          return "{\"status\":\"ok\"}";
//	}

	@GetMapping("/user/activate/{code}")
	public User getUserByCode(@PathVariable long code) {
		User u=userRepo.findByCode(code);
		return u;
	}
//	@DeleteMapping("/user/{id}")
//	public void deleteUser(@PathVariable int id) {
//		userRepo.deleteById(id);
//	}

//	@PutMapping("/user")
//	public User updateUser(@RequestBody User user) {
//		User userupdate = userRepo.save(user);
//		return userupdate;
//	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO){
		userService.insert(userDTO);
		return new ResponseEntity<UserDTO>(userDTO,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/user")
	public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO){
		userService.update(userDTO);
		return new ResponseEntity<UserDTO>(userDTO,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/user/{id}")
	public void delete(@PathVariable int id){
		userService.deleteById(id);
	}
	
	@GetMapping("/user")
	public List<UserDTO> getUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<UserDTO> getUserWithId(@PathVariable int id){
		UserDTO userDtos=userService.getUserById(id);
		return new ResponseEntity<UserDTO>(userDtos,HttpStatus.CREATED);
	}
}
