package com.dojo.reactjava.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.reactjava.models.User;

@Repository
public interface ApiUserRepository extends CrudRepository<User, Long> {

	
}
