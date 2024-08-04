package com.qsp.Event.Management.System.Dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Organizer {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
private int id;
private String Name;
private String ContactInfo;
@OneToMany(mappedBy = "organizer" , cascade = CascadeType.ALL, orphanRemoval = true)
private List<Event>event;
public int getId() {
	
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getContactInfo() {
	return ContactInfo;
}
public void setContactInfo(String contactInfo) {
	ContactInfo = contactInfo;
}

}
