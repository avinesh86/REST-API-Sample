package org.avinesh.webservices.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.avinesh.webservices.messenger.database.DatabaseClass;
import org.avinesh.webservices.messenger.model.Message;
import org.avinesh.webservices.messenger.model.Profile;

public class ProfileService {
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService() {
		profiles.put("Avinesh", new Profile(1L, "Avinesh", "Hello world!", "Munasinghe"));
		profiles.put("Navin", new Profile(2L, "Navin", "Hello Jersey!", "Avinesh"));
		
	}
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeMessage(String profileName) {
		return profiles.remove(profileName);
	}
}
