package com.username.service.api.template;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HealthJsonTemplate {
	public final static String FORMAT_PATTERN = "dd/mm/yyyy HH:mm:ss";
	
	@JsonProperty("date.time")
	private String dateTime;
	@JsonProperty("server.name")
	private String serverName;
	private String version;
	
	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}	
}
