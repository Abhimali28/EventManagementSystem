package com.qsp.Event.Management.System.Controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.qsp.Event.Management.System.Dto.Venue;
import com.qsp.Event.Management.System.Services.VenueService;
@RestController
@RequestMapping("/api/venues")
public class VenueController {
	@Autowired 
	private VenueService venueservice;
	@PostMapping("/pm")//ok
	public ResponseEntity<Venue> createVenue(@RequestBody Venue venue) {
		return ResponseEntity.ok(venueservice.createVenue(venue));
	}   
	@GetMapping("/{id}")   //ok
	public ResponseEntity<Venue> getVenueById(@PathVariable int id) {  
		Venue venue = venueservice.getVenueById(id);
		return venue != null ? ResponseEntity.ok(venue) : ResponseEntity.notFound().build();
	 }   
	@PutMapping("/{id}")//not
	public ResponseEntity<Object> updateVenue(@PathVariable int id, @RequestBody Venue venue) {
		Optional<Venue> ov = venueservice.findById(id);
		if (ov.isPresent()) { 
			Venue venue2 = ov.get();
			venue2.setName(venue.getName());
			venue2.setLocation(venue.getLocation());
			venue2.setCapacity(venue.getCapacity());
			return ResponseEntity.ok(venueservice.save(venue));
		} else {
			return ResponseEntity.notFound().build();
		}
	} 
	@DeleteMapping("/{id}") 
	public ResponseEntity<Void> deleteVenue(@PathVariable int id) {
		venueservice.deleteVenue(id);
		return ResponseEntity.noContent().build();
	}
}