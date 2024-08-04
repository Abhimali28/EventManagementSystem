package com.qsp.Event.Management.System.Dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
//@JsonInclude(value=Include.NON_NULL)
public class Event {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
private int id;
private String EventName;
private String EventDate;
private String Description;
@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name = "organizer_id")
private Organizer organizer;
@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name = "venue_id" )
private Venue venue;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEventName() {
	return EventName;
}
public void setEventName(String eventName) {
	EventName = eventName;
}
public String getEventDate() {
	return EventDate;
}
public void setEventDate(String eventDate) {
	EventDate = eventDate;
}
public String getDescription() {
	return Description;
}
public void setDescription(String description) {
	Description = description;
}
public Organizer getOrganizer() {
	return organizer;
}
public void setOrganizer(Organizer organizer) {
	this.organizer = organizer;
}
public Venue getVenue() {
	return venue;
}
public void setVenue(Venue venue) {
	this.venue = venue;
}
}