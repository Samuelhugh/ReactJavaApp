package com.dojo.reactjava.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.reactjava.models.User;

@Repository
public interface ApiUserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	
}
