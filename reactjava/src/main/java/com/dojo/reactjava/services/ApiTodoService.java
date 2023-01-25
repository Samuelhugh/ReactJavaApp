package com.dojo.reactjava.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dojo.reactjava.models.Event;
import com.dojo.reactjava.repositories.ApiEventRepository;

@Service
public class ApiEventService {
	@Autowired
	private ApiEventRepository eventRepository;
	
	public Event create(Event event) {
		return this.eventRepository.save(event);
	}
	
	public List<Event> allEvents() {
		return this.eventRepository.findAll();
	}
	
	public Event getOneEvent(Long id) {
		return this.eventRepository.findById(id).orElse(null);
	}
	
	public Event update(Event event) {
		return this.eventRepository.save(event);
	}
	
	public void delete(Long id) {
		this.eventRepository.deleteById(id);
	}
	
}