package com.dojo.reactjava.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dojo.reactjava.models.Event;
import com.dojo.reactjava.repositories.ApiEventRepository;
import com.dojo.reactjava.services.ApiEventService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/events")
public class ApiEventController {
	@Autowired
	private ApiEventRepository eventRepository;
	@Autowired
	private ApiEventService eventService;
	
	// Try validations
	@PostMapping("/create")
	public Event createEvent(@RequestBody Event event) {
		return this.eventService.create(event);
	}
	
	@GetMapping("")
	public List<Event> getAll(@ModelAttribute("events") Event event) {
		return this.eventService.allEvents();
	}
	
	@GetMapping("/info/{id}")
	public Event getOne(@PathVariable("id") Long id) {
		return this.eventService.getOneEvent(id);
	}
	
	@PutMapping("/edit/{id}")
	public Event update(@PathVariable("id") Long id, @RequestBody Event deserializedEvent) {
		Event eventFromFrontEndToUpdate = this.eventService.getOneEvent(id);
		eventFromFrontEndToUpdate.setEventName(deserializedEvent.getEventName());
		eventFromFrontEndToUpdate.setNumberAttending(deserializedEvent.getNumberAttending());
		return this.eventRepository.save(eventFromFrontEndToUpdate);
	}
	
	@DeleteMapping("/delete/{id}")
//	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		this.eventService.delete(id);
		return null;
	}
	
}