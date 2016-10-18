package org.iaresti.messenger.database;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hamcrest.core.Is;
import org.iaresti.messenger.model.Message;
import org.iaresti.messenger.model.Profile;
import org.junit.After;
import org.junit.Test;
import org.junit.internal.builders.IgnoredBuilder;

public class DatabaseTest {

    @After
    public void clean() {
        Database.getInstance().clearAll();
    }

    @Test
    public void should_be_able_to_get_single_message() {
        Message message = new Message("2","Hola 2", "Igor");
        Database database = Database.getInstance();
        message.setCreated(database.getMessage("2").getCreated());
        assertEquals(message, database.getMessage("2"));
    }

    @Test
    public void should_be_able_to_get_message_by_year() {
        List<Message> messagesDatabase = Database.getInstance().getMessagesForYear(Calendar.YEAR);
        Calendar calendar = Calendar.getInstance();

        for (Message message : messagesDatabase) {
            calendar.setTime(message.getCreated());
            assertEquals(Calendar.YEAR, calendar.get(Calendar.YEAR));
        }
    }

    @Test
    public void should_be_able_to_add_message() {
        Message message = new Message("Prueba", "Moe");
        Database database = Database.getInstance();
        database.addMessage(message);
        assertEquals(message, database.getMessage(message.getId()));
    }

    @Test
    public void should_be_able_to_update_message() {
        Database database = Database.getInstance();
        assertEquals(null, database.getMessage("-1"));
        Message message = new Message("1", "Adios 1", "Igor");
        database.updateMessage(message);
        assertEquals(message, database.getMessage("1"));
    }

    @Test
    public void should_be_able_to_remove_message() {
        Database database = Database.getInstance();
        database.removeMessage("1");
        assertEquals(null, database.getMessage("1"));
    }

    //Acceso de Profiles
    @Test
    public void should_be_able_to_get_all_profiles() {
    	List<Profile> profiles = new ArrayList<Profile>();
    	profiles.add(new Profile("1", "iaresti", "Igor", "Aresti"));
    	profiles.add(new Profile("2", "aferro", "Armando", "Ferro"));
        assertEquals(profiles, Database.getInstance().getAllProfiles());
    }

    @Test
    public void should_be_able_to_get_profile() {
    	Profile profile = new Profile("1","iaresti","Igor","Aresti");
    	assertEquals(profile,Database.getInstance().getProfile("iaresti"));
    }
}
