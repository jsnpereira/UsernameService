package com.username.service.database.persistence;

import java.io.Serializable;

import com.username.service.database.entities.Persona;

public interface PersonaDAO extends EntityManager<Persona,Serializable> {
	public Persona findByName(String firstName, String lastName);
	public boolean checkExistEmail(String email);

}
