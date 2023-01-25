package com.dojo.reactjava.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dojo.reactjava.models.Event;

@Repository
public interface ApiEventRepository extends CrudRepository<Event, Long> {
	
	List<Event> findAll();
	
}