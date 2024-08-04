package com.qsp.Event.Management.System.Dto;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Venue {
@Id
@GeneratedValue(strategy =GenerationType.IDENTITY)
private int id;
private String Name;
private String location;
private int Capacity;
@OneToOne(mappedBy = "venue")
private Event event;
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
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public int getCapacity() {
	return Capacity;
}
public void setCapacity(int capacity) {
	Capacity = capacity;
}

}
