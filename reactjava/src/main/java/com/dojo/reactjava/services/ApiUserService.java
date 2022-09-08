package com.dojo.reactjava.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.reactjava.repositories.ApiUserRepository;

@Service
public class ApiUserService {
	@Autowired
	private ApiUserRepository userRepository;

}