package com.cts.project.userservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>{
   public User findByEmail(String email);
   
   public User findByCode(long code);
   
   public User findByUserNameAndPassword(String userName,String password);
   
   public User findByUserName(String userName);
}
