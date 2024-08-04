package com.qsp.Event.Management.System.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.Event.Management.System.Dto.Event;
import com.qsp.Event.Management.System.exceptions.ResourceNotFoundException;
import com.qsp.Event.Management.System.repository.Eventrepo;

import jakarta.persistence.criteria.CriteriaBuilder.In;
@Service
public class EventService {
	@Autowired
private Eventrepo eventrepo;
public Event createEvent(Event  event)
{
	return eventrepo.save(event);
}
public List<Event>getAllEvents()
{
	return eventrepo.findAll();
}
public Event getEventById(int id)
{
	return eventrepo.findById(id).orElse(null);
}
public Event updateEvent(int id,Event event) throws ResourceNotFoundException
{
	 Event ev = eventrepo.findById(id)
             .orElseThrow(() -> new ResourceNotFoundException("Event not found with id: " + id));
     ev.setEventDate(event.getEventDate());
     ev.setEventName(event.getEventName());
     ev.setDescription(event.getDescription());
     ev.setOrganizer(event.getOrganizer());
     ev.setVenue(event.getVenue());

     return eventrepo.save(event);

}
public void deleteEvent(int id)
{
	eventrepo.deleteById(id);
}
public List<Event>getEventByVenue(int venueId)
{
	return eventrepo.findByVenueId(venueId);
}
public List<Event>getEventByOrganizer(int organizerId)
{
	return eventrepo.findByOrganizerId(organizerId);
}
}
