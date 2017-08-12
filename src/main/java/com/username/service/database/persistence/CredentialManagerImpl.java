package com.username.service.database.persistence;

import java.util.List;

import com.username.service.database.entities.Credential;
import com.username.service.databse.client.HibernateUtils;
import com.username.service.utils.LogApp;

public class CredentialManagerImpl implements CredentialManager {
	LogApp logger = new LogApp(this);
	CredentialDAOImpl dao = new CredentialDAOImpl();

	public Credential findCredentialById(String id) {
		try {
			logger.logInfo("Find the credential");
			HibernateUtils.beginTransaction();
			Credential c = dao.findByID(Credential.class, id);
			HibernateUtils.commitTransaction();
			logger.logInfo("Finding the credential is: "+c.toString());
			return c;
		} catch (Exception e) {
			HibernateUtils.rollbackTransaction();
		} finally {
			HibernateUtils.closeSession();
		}
		return null;
	}

	public Credential getCredential(Credential credential) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveCredential(Credential credential) {
		try {
			logger.logInfo("Saving the data: " + credential.toString());
			HibernateUtils.beginTransaction();
			dao.save(credential);
			HibernateUtils.commitTransaction();
		} catch (Exception e) {
			logger.logInfo("Error message: " + e.getMessage());
			HibernateUtils.rollbackTransaction();
		} finally {
			HibernateUtils.closeSession();
		}
	}

	public void deleteCredential(Credential credential) {
		try {
			logger.logInfo("Delete an credential: "+credential.getId());
			HibernateUtils.beginTransaction();
			dao.remove(credential);
			HibernateUtils.commitTransaction();
		} catch (Exception e) {
			HibernateUtils.rollbackTransaction();
			logger.logInfo("Error message: "+e.getMessage());
		} finally {
			HibernateUtils.closeSession();
		}

	}

	public List<Credential> getAllCredential() {

		try {
			logger.logInfo("Get All Credential");
			HibernateUtils.beginTransaction();
			List<Credential> list = dao.findAll(Credential.class);
			HibernateUtils.commitTransaction();
			logger.logInfo("Getting " + list.size() + " credentials");
			return list;
		} catch (Exception e) {
			HibernateUtils.rollbackTransaction();
			logger.logInfo("Error message: " + e.getMessage());
		} finally {
			HibernateUtils.closeSession();
		}
		return null;
	}

}
