package com.cts.project.userservice;

import java.util.List;

public interface UserService {

	public User insert(User user);
	
	public User update(User user);
	
	public void deleteById(int id);
	
	public List<User> getAllUsers();
	
	public User getUserById(int id);
	
	public User getUserByCodes(long code);
}
