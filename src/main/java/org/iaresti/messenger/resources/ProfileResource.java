package org.iaresti.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.iaresti.messenger.model.Profile;
import org.iaresti.messenger.service.ProfileService;

@Path("/profiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService profileService = new ProfileService();
	
	@GET
	public List<Profile> getProfile(){
		return profileService.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile Profile){
		return profileService.addProfile(Profile);
	}
	
	@PUT
	@Path("/{ProfileName}")
	public Profile updateProfile(@PathParam("ProfileName") String profileName,Profile Profile){
		Profile.setProfileName(profileName);
		return profileService.updateProfile(Profile);
	}
	
	@DELETE
	@Path("/{ProfileName}")
	public void deleteProfile(@PathParam("ProfileName") String profileName,Profile Profile){
		profileService.removeProfile(profileName);
	}
	
	@Path("/{ProfileName}")
	@GET
	//Jersey realiza la conversion String a Long, no es necesario parsear
	public Profile getSingleProfile(@PathParam("ProfileName") String profileName){
		return profileService.getProfile(profileName);
	}

}
