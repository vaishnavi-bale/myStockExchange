package com.cts.project.userservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	JavaMailSender jms;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public User insert(User user) {
	userRepo.save(user);
		try {
			SimpleMailMessage sm = new SimpleMailMessage();
			sm.setFrom("vaishnavi.bale05@gmail.com");
			sm.setTo(user.getEmail());
			sm.setSubject("Verification Mail");
			sm.setText(" Hello "+user.getUserName()+"\n Account created!! \n click on <a href='http://localhost:4200/user/activate?code=" + user.getCode()
					+ "'>Click</a>");
			jms.send(sm);
			logger.info("Sending email...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		user.setRegisterStatus("ok");
		return user;
	
	}

	@Override
	public User update(User user) {
		return userRepo.save(user);
	}

	@Override
	public void deleteById(int id) {
		userRepo.deleteById(id);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
		
	}

	@Override
	public User getUserById(int id) {
		Optional<User> user=userRepo.findById(id);
		return user.orElse(null);
	}

	@Override
	public User getUserByCodes(long code) {
		User user=userRepo.findByCode(code);
		return user;
	}

	@Override
	public UserDTO getByUsernameAndPassword(String userName, String password) {
		User user=userRepo.findByUserNameAndPassword(userName, password);
		UserDTO userDTO=new UserDTO();
		BeanUtils.copyProperties(user, userDTO);
		return userDTO;
	}

	@Override
	public User getUserByUserName(String userName) {
		User user=userRepo.findByUserName(userName);
		return user;
	}

//	@Override
//	public List<User> getAllUsers() {
//		List<User> user=userRepo.findAll();
//		List<User> users_=null;
//		BeanUtils.copyProperties(user, users_);
//		return users_;
//	}

	
	
}
