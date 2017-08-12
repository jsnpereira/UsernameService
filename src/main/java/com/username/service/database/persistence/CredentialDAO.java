package com.username.service.database.persistence;

import java.io.Serializable;

import com.username.service.database.entities.Credential;

public interface CredentialDAO extends EntityManager<Credential, Serializable> {
	public Credential getCredentialByPrincipal(String principal);
}
