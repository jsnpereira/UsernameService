package com.username.service.database.persistence;

import javax.persistence.Query;
import com.username.service.database.entities.Persona;
import com.username.service.databse.client.HibernateUtils;

public class PersonaDAOImpl extends EntityManagerImpl<Persona, String> implements PersonaDAO {

	public Persona findByName(String firstName, String lastName) {
		String sql = "SELECT p FROM p WHERE p.first_name = :first_name and p.last_name = :last_name";
		Query query = HibernateUtils.getSession().createQuery(sql).setParameter("first_name", firstName).setParameter("last_name", lastName);
		return findOne(query);
	}

	public boolean checkExistEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

}
