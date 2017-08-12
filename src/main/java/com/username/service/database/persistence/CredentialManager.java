package com.username.service.database.persistence;

import java.util.List;
import com.username.service.database.entities.Credential;

public interface CredentialManager {
	public Credential findCredentialById(String id);
	public Credential getCredential(Credential credential);
	public void saveCredential(Credential credential);
	public void deleteCredential(Credential credential);
	public List<Credential> getAllCredential();
}
