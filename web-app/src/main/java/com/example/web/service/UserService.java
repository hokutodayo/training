package com.example.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.web.entity.User;
import com.example.web.repository.UserRepository;

import jakarta.persistence.OptimisticLockException;

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

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	@Transactional
	public User updateUser(User user) throws OptimisticLockException {
		// 排他制御（更新チェック）
		User currentUser = userRepository.findOneForUpdate(user.getId());

		if (currentUser.getUpdateDate().getTime() == user.getUpdateDate().getTime()) {
			Date now = new Date();
			user.setUpdateDate(now);
			return userRepository.save(user);
		} else {
			throw new OptimisticLockException(user);
		}
	}
}