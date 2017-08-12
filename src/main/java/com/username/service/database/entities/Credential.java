package com.username.service.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "credential")
public class Credential {
	private String Id;
	private String principal;
	private String credential;
	private boolean changed;
	private int attempt;
	private int numberAttempt;
	private Persona persona;

	@Id
	@Column(name = "id")
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	@Column(name = "principal")
	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	@Column(name = "credential")
	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}	

	@Column(name ="changed")
	public boolean isChanged() {
		return changed;
	}

	public void setChanged(boolean changed) {
		this.changed = changed;
	}

	@Column(name = "attempt")
	public int getAttempt() {
		return attempt;
	}

	public void setAttempt(int attempt) {
		this.attempt = attempt;
	}

	@Column(name = "number_attempt")
	public int getNumberAttempt() {
		return numberAttempt;
	}

	public void setNumberAttempt(int numberAttempt) {
		this.numberAttempt = numberAttempt;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "persona")
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Credential [Id=" + Id + ", principal=" + principal + ", credential=" + credential + ", change=" + changed
				+ ", attempt=" + attempt + ", numberAttempt=" + numberAttempt + ", persona=" + persona.getId() + "]";
	}
	
	
}
