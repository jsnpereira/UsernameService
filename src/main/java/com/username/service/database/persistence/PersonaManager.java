package com.username.service.database.persistence;

import java.util.List;

import com.username.service.database.entities.Persona;

public interface PersonaManager {
	public Persona findPersonaById(String id);
	public Persona getPersona(Persona persona);
	public void savePersona(Persona persona);
	public void deletePersona(Persona persona);
	public List<Persona> getAllPersona();
	public boolean checkEmailIsExist(String email);
}
