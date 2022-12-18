package com.example.web.service;

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
}