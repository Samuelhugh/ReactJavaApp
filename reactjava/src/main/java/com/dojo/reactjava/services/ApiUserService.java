package com.dojo.reactjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.reactjava.models.User;
import com.dojo.reactjava.repositories.ApiUserRepository;

@Service
public class ApiUserService {
	@Autowired
	private ApiUserRepository userRepository;
	
	
	public User create(User user) {
		return this.userRepository.save(user);
	}
	
	public List<User> allUser() {
		return this.userRepository.findAll();
	}
	
	public User getUser(Long id) {
		return this.userRepository.findById(id).orElse(null);
	}
	
	public User update(User user) {
		return this.userRepository.save(user);
	}
	
	public void delete(Long id) {
		this.userRepository.deleteById(id);
	}

}
