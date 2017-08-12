package com.username.service.test.junit.database;

import static org.junit.Assert.*;

import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.username.service.database.entities.Persona;
import com.username.service.database.persistence.PersonaManagerImpl;
import com.username.service.test.utils.DataUtils;
import com.username.service.test.utils.LogApp;

public class PersistencePersonaEntity {
	LogApp logger = new LogApp(PersistencePersonaEntity.class);

	@Test
	public void addPersonaInDatabase() {
		UUID id = UUID.randomUUID();
		Persona persona = new Persona();
		
		persona.setId(id.toString());
		persona.setFirstName(DataUtils.getValueString(15));
		persona.setLastName(DataUtils.getValueString(25));
		persona.setEmail(DataUtils.getEmailUtils("user_", "@company.com"));
		persona.setStatus("active");
		persona.setVerified(true);
		PersonaManagerImpl dao = new PersonaManagerImpl();
		dao.savePersona(persona);
		
		Persona saveP = dao.findPersonaById(persona.getId());
		assertTrue("Persona received from database", saveP != null);
		assertTrue("Persona entity was added in database", saveP.equals(persona));
	}
	
	@Test
	public void getAllPersona() {
		PersonaManagerImpl dao = new PersonaManagerImpl();
		
		List<Persona> list = dao.getAllPersona();
		
		assertTrue("List isn't null", !list.isEmpty());
		assertTrue("List showing an size is: "+list.size(), list.size() > 0);
	}
	
	@Test
	public void deleteAnPersona(){
		UUID id = UUID.randomUUID();
		Persona persona = new Persona();
		
		persona.setId(id.toString());
		persona.setFirstName(DataUtils.getValueString(15));
		persona.setLastName(DataUtils.getValueString(25));
		persona.setEmail(DataUtils.getEmailUtils("user_", "@company.com"));
		persona.setStatus("active");
		persona.setVerified(true);
		PersonaManagerImpl dao = new PersonaManagerImpl();
		dao.savePersona(persona);
		
		Persona p = dao.findPersonaById(persona.getId());
		assertTrue("Check persona was saved in database", p != null );
		
		dao.deletePersona(p);
		
		p = dao.findPersonaById(persona.getId());
		assertTrue("Check an persona was deleted", p == null);
	}
	
	@Test 
	public void getPersonaID() {
		UUID id = UUID.randomUUID();
		Persona persona = new Persona();
		
		persona.setId(id.toString());
		persona.setFirstName(DataUtils.getValueString(15));
		persona.setLastName(DataUtils.getValueString(25));
		persona.setEmail(DataUtils.getEmailUtils("user_", "@company.com"));
		persona.setStatus("active");
		persona.setVerified(true);
		PersonaManagerImpl dao = new PersonaManagerImpl();
		dao.savePersona(persona);
		
		Persona p = dao.findPersonaById(persona.getId());
		
		assertTrue("Check Get an persona with ID", persona.equals(p) );
		
	}
}
