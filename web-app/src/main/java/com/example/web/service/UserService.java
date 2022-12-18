package com.example.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web.entity.User;
import com.example.web.repository.UserRepository;

/**
 * ユーザー情報 Service
 */
@Service
public class UserService {

	/**
	 * ユーザー情報 Repository
	 */
	@Autowired
	UserRepository userRepository;

	public List<User> searchAll() {
		return userRepository.findAll();
	}

	public User search(Long id) {
		return userRepository.findById(id).get();
	}
	
	public User createUser(User user) {
		Date now = new Date();
		user.setCreateDate(now);
		user.setUpdateDate(now);
		return userRepository.save(user);
	}
}