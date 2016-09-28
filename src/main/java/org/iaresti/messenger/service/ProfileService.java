package org.iaresti.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.iaresti.messenger.database.Database;
import org.iaresti.messenger.model.Profile;

public class ProfileService {
	

	private Database database = Database.getInstance();
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(database.getAllProfiles());
	}
	
	public Profile getProfile(String profileName){
		return database.getProfile(profileName);
	}
	
	public Profile addProfile(Profile profile){
		return database.addProfile(profile);
	}
	
	public Profile updateProfile(Profile profile){
		return database.updateProfile(profile);
	}
	
	public Profile removeProfile(String profileName){
		return database.removeProfile(profileName);
	}

}
