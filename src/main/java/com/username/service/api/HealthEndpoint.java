package com.username.service.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.username.service.api.template.HealthJsonTemplate;
import com.username.service.models.HealthModel;

@Path("/health")
public class HealthEndpoint {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public HealthJsonTemplate getHealth() {
		return HealthModel.checkHealth();
	}
	
}
