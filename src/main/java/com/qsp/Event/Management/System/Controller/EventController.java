package com.qsp.Event.Management.System.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.qsp.Event.Management.System.Dto.Event;
import com.qsp.Event.Management.System.Services.EventService;
import com.qsp.Event.Management.System.exceptions.ResourceNotFoundException;
@RestController
@RequestMapping("/event")
public class EventController { 
	@Autowired
	EventService evs;
	@PostMapping()
	public Event createevent(@RequestBody Event event) {
		return evs.createEvent(event);
	} 
	@GetMapping 
	public List<Event> getAllEvent() {
		return evs.getAllEvents();
	}
	@GetMapping("id/{id}")
	public ResponseEntity<Event> getEventById(@PathVariable int id) {
		Event event = evs.getEventById(id);
		return event != null ? ResponseEntity.ok(event) : ResponseEntity.notFound().build();
	}
	@PutMapping("/{id}")
	public ResponseEntity<Event> updateEvent(@PathVariable int id, @RequestBody Event event) throws ResourceNotFoundException {
		Event updateEvent = evs.updateEvent(id, event);
		  return new ResponseEntity<>(updateEvent, HttpStatus.OK);	
	} 
	@DeleteMapping("id/{id}")
	public ResponseEntity<Void> deleteEvent(@PathVariable int id) {
		evs.deleteEvent(id);
		return ResponseEntity.noContent().build();
	}
	@GetMapping("venueId/{venueId}")
	public ResponseEntity<List<Event>> getEventByVenue(@PathVariable int venueId) {
		return ResponseEntity.ok(evs.getEventByVenue(venueId));
	 }
	@GetMapping("organizerId/{organizerId}")
	public ResponseEntity<List<Event>> getEventByOrganizer(@PathVariable("organizerId") int organizerId) {
		return ResponseEntity.ok(evs.getEventByOrganizer(organizerId));
	}
}
