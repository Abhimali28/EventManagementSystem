package com.qsp.Event.Management.System.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.Event.Management.System.Dto.Venue;
import com.qsp.Event.Management.System.repository.Venuerepo;

@Service
public class VenueService {
@Autowired
private Venuerepo vrp;
 public Venue createVenue(Venue venue)
 {
	 return vrp.save(venue);
 }
 public  Venue getVenueById(int id)
 {
	 return vrp.findById(id).orElse(null);
	 
 }
 public Venue updateVenue(int id,Venue venue)
 {
	 if(vrp.existsById(id))
	 {
		 venue.setId(id);
		 return vrp.save(venue);
	 }
	 return null;
 }
 public void deleteVenue(int id)
 {
	 vrp.deleteById(id);
 }
public Optional<Venue> findById(int id) {
	// TODO Auto-generated method stub
	return null;
}
public Object save(Venue venue) {
	// TODO Auto-generated method stub
	return null;
}
}
