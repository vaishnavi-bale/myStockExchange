package com.cts.project.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cts.project.bean.User;
import com.cts.project.dto.UserDTO;
import com.cts.project.repo.UserRepo;
import com.cts.project.services.UserService;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	JavaMailSender jms;

	@Override
	public UserDTO insert(UserDTO userDTO) {
	    User user=new User();
	    BeanUtils.copyProperties(userDTO,user);
	    userRepo.save(user);
	    try {
			SimpleMailMessage sm = new SimpleMailMessage();
			sm.setFrom("vaishnavi.bale05@gmail.com");
			sm.setTo(userDTO.getEmail());
			sm.setSubject("Verification Mail");
			sm.setText(" Hello "+userDTO.getUserName()+"\n Account created!! \n click on <a href='http://localhost:4200/user/activate?code=" + userDTO.getCode()
					+ "'>Click</a>");
			jms.send(sm);
			System.out.println("Sending mail...");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDTO;
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		User user=new User();
		BeanUtils.copyProperties(userDTO, user);
		userRepo.save(user);
		return userDTO;
	}

	@Override
	public void deleteById(int id) {
		userRepo.deleteById(id);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> user=userRepo.findAll();
		List<UserDTO> users_dto=new ArrayList<UserDTO>();
		for(User u: user) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(u, userDTO);
			users_dto.add(userDTO);
		}	
		return users_dto;
	}

	@Override
	public UserDTO getUserById(int id) {
		Optional<User> user=userRepo.findById(id);
		UserDTO userDto= new UserDTO();
		BeanUtils.copyProperties(user.orElse(new User()),userDto);
		return userDto;
	}

//	@Override
//	public List<UserDTO> getAllUsers() {
//		List<User> user=userRepo.findAll();
//		List<UserDTO> users_dto=null;
//		BeanUtils.copyProperties(user, users_dto);
//		return users_dto;
//	}

	
	
}
