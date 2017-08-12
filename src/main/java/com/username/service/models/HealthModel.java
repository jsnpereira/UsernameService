package com.username.service.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.username.service.api.template.HealthJsonTemplate;



public class HealthModel {
	
	public static HealthJsonTemplate checkHealth() {
		HealthJsonTemplate health = new HealthJsonTemplate();
		health.setServerName("Username service API");
		health.setVersion("0.1");
		health.setDateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern(HealthJsonTemplate.FORMAT_PATTERN)));
		return health;
	}

}
