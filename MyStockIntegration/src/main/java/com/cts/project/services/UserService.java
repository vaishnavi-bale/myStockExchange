package com.cts.project.services;

import java.util.List;

import com.cts.project.dto.UserDTO;

public interface UserService {

	public UserDTO insert(UserDTO userDTO);
	
	public UserDTO update(UserDTO userDTO);
	
	public void deleteById(int id);
	
	public List<UserDTO> getAllUsers();
	
	public UserDTO getUserById(int id);
}
