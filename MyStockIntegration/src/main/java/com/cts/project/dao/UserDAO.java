package com.cts.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.project.bean.User;

public interface UserDAO extends JpaRepository<User, Integer>{

}
