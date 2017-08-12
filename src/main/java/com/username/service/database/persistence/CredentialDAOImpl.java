package com.username.service.database.persistence;

import com.username.service.database.entities.Credential;
import com.username.service.utils.LogApp;

public class CredentialDAOImpl extends EntityManagerImpl<Credential, String> implements CredentialDAO {
	LogApp logger = new LogApp(this);
	
	public Credential getCredentialByPrincipal(String principal) {
		// TODO Auto-generated method stub
		return null;
	}

}
