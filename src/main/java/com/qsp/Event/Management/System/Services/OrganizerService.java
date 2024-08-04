package com.qsp.Event.Management.System.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qsp.Event.Management.System.Dto.Event;
import com.qsp.Event.Management.System.Dto.Organizer;
import com.qsp.Event.Management.System.exceptions.ResourceNotFoundException;
import com.qsp.Event.Management.System.repository.Orgnizerrepo;

@Service
public class OrganizerService {
	@Autowired
	private Orgnizerrepo orp;

	public Organizer createOrganizer(Organizer organizer) {
		return orp.save(organizer);

	}

	public Optional<Organizer> getOrganizerById(int id) {
		return orp.findById(id);

	}

	public Organizer updateOrganizer(int id, Organizer organizer) throws ResourceNotFoundException {
//		if (orp.existsById(id)) {
//			organizer.setId(id);
//			return orp.save(organizer);
		Organizer ev = orp.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Organizer not found with id: " + id));
		ev.setName(organizer.getName());
		ev.setContactInfo(organizer.getContactInfo());
		// }
		return orp.save(organizer);
	}
	public void daleteOrganizer(int id) {
		orp.deleteById(id);
	}
}
