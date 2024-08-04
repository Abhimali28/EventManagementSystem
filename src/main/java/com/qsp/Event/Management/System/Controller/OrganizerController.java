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
import org.springframework.web.bind.annotation.RestController;
import com.qsp.Event.Management.System.Dto.Organizer;
import com.qsp.Event.Management.System.Services.OrganizerService;
import com.qsp.Event.Management.System.exceptions.ResourceNotFoundException;
@RestController
@RequestMapping("/organizer")
public class OrganizerController {
	@Autowired
	private OrganizerService osr;
	@PostMapping
	public Organizer createOrgnizer(@RequestBody Organizer organizer) {
		return osr.createOrganizer(organizer); 
	} 
   @GetMapping("/{id}")
	public Optional<Organizer> getOrganizerById(@PathVariable int id) { 
		return osr.getOrganizerById(id);
	}
	@PutMapping("/{id}")
	public Organizer updateOrgannizer(@PathVariable int id, @RequestBody Organizer organizer)throws ResourceNotFoundException
	{
		return osr.updateOrganizer(id, organizer);		
	}
	@DeleteMapping("/{id}")
	public void deleteOrganizer(@PathVariable int id) {
		osr.daleteOrganizer(id);
	}
}