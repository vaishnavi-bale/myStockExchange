package com.cts.project.daoImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.project.bean.User;
import com.cts.project.dao.UserDAO;

@RestController
@CrossOrigin(origins = "*")
public class UserDAOImpl {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	JavaMailSender jms;
	
	@GetMapping("/user")
	public List<User> getUsers() {
		return userDAO.findAll();
	}
	@GetMapping("user/{id}")
	public User getUserById(@PathVariable int id) {
		Optional<User> userList = userDAO.findById(id);
		User user = userList.get();
		return user;
	}
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		User newUser = userDAO.save(user);
		try {
			SimpleMailMessage sm=new SimpleMailMessage();
			sm.setFrom("vaishnavi.bale05@gmail.com");
			sm.setTo("vaishnavi.bale05@gmail.com");
			sm.setSubject("Testing mail");
			sm.setText("This is the testing mail...");
			jms.send(sm);
			System.out.println("Sending mail...");
		}catch(Exception e) {e.printStackTrace();}
		newUser.setRegisterStatus("ok");
		return newUser;
	}
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable int id) {
		userDAO.deleteById(id);
	}
	@PutMapping("/user")
	public User updateUser(@RequestBody User user) {
		User userupdate = userDAO.save(user);
		return userupdate;
	}
}
