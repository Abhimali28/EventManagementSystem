package com.qsp.Event.Management.System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qsp.Event.Management.System.Dto.Event;

public interface Eventrepo extends JpaRepository<Event ,Integer> {

	List<Event> findByVenueId(int venueId);

	List<Event> findByOrganizerId(int organizerId);
    
}
