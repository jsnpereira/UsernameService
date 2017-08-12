package com.username.service.database.persistence;

import java.util.List;

import com.username.service.database.entities.Persona;
import com.username.service.databse.client.HibernateUtils;
import com.username.service.utils.LogApp;

public class PersonaManagerImpl implements PersonaManager {
	PersonaDAOImpl dao = new PersonaDAOImpl();
	LogApp logger = new LogApp(this);

	public Persona findPersonaById(String id) {
		try {
			HibernateUtils.beginTransaction();
			Persona persona = dao.findByID(Persona.class, id);
			logger.logInfo("Persona with ID getting the data: "+persona.toString());
			HibernateUtils.commitTransaction();
			return persona;
		} catch (Exception e) {
			logger.logInfo("Error message: "+e.getMessage());
			HibernateUtils.rollbackTransaction();
		} finally {
			HibernateUtils.closeSession();
		}
		return null;
	}

	public Persona getPersona(Persona persona) {
		return null;
	}

	public void savePersona(Persona persona) {
		try {
			HibernateUtils.beginTransaction();
			dao.save(persona);
			HibernateUtils.commitTransaction();
		} catch (Exception e) {
			logger.logInfo("Error message: "+e.getMessage());
			HibernateUtils.rollbackTransaction();
		} finally {
			HibernateUtils.closeSession();
		}
	}

	public void deletePersona(Persona persona) {
		try {
			logger.logInfo("Delete persona: "+persona.toString());
			HibernateUtils.beginTransaction();
			dao.remove(persona);
			HibernateUtils.commitTransaction();
		} catch (Exception e) {
			logger.logInfo("Error message: "+e.getMessage());
			HibernateUtils.rollbackTransaction();
		} finally {
			HibernateUtils.closeSession();
		}

	}

	public List<Persona> getAllPersona() {
		List<Persona> personas = null;
		try {
			logger.logInfo("Get All personas");
			HibernateUtils.beginTransaction();
			personas = dao.findAll(Persona.class);
			HibernateUtils.commitTransaction();
			logger.logInfo("Persona's list size: "+personas.size());
		} catch (Exception e) {
			logger.logInfo("Error message: "+e.getMessage());
			HibernateUtils.rollbackTransaction();
		} finally {
			HibernateUtils.closeSession();
		}
		return personas;
	}

	public boolean checkEmailIsExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}



}
