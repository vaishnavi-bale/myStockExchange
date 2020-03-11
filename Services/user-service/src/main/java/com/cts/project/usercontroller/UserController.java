package com.cts.project.usercontroller;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.cts.project.userservice.UserDTO;
import com.cts.project.userservice.UserRepo;
import com.cts.project.userservice.UserService;


@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserService userService;

	@Autowired
	JavaMailSender jms;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping(value="/login")
  	public ResponseEntity<?> login(HttpServletRequest request)
  	{
  		String authorize=request.getHeader("Authorization");
  		logger.info("Login with token -->{}",authorize);
  		String username=null;
  		String password=null;
  		if(authorize!= null && authorize.startsWith("Basic")) {
  			String base64Credentials = authorize.substring("Basic".length()).trim();
  			byte[] credDecoded=Base64.getDecoder().decode(base64Credentials);
  			String credentials = new String(credDecoded,StandardCharsets.UTF_8);
  			username=credentials.split(":")[0];
  			password=credentials.split(":")[1];
  		}	
  			try {
				UserDTO user=userService.getByUsernameAndPassword(username, password);
				logger.info("Logged in username --> {}",username);
				return new ResponseEntity<UserDTO>(user, HttpStatus.OK);
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
				logger.info("Unauthorized Access :Stack Trace --> {}",e.getStackTrace().toString());
				return new ResponseEntity<String>("No User Found", HttpStatus.NOT_FOUND);
			}
  		}

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
		if(user!=null) {
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
		}
		
	}
//	@GetMapping("/user/{userName}")
//	public ResponseEntity<?> getUserWithUserName(@PathVariable String userName){
//		User user=userService.getUserByUserName(userName);
//		return new ResponseEntity<User>(user,HttpStatus.CREATED);	
//	}
}
