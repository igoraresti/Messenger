package org.iaresti.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.iaresti.messenger.database.Database;
import org.iaresti.messenger.model.Profile;

public class ProfileService {
	/*
private Map<String, Profile> profiles = Database.getProfiles();
	
	public ProfileService(){
		profiles.put("iaresti", new Profile(1L, "iaresti", "Igor", "Aresti")) ;
		profiles.put("aferro", new Profile(2L, "aferro", "Armando", "Ferro"));
	}
	
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}
*/
}
