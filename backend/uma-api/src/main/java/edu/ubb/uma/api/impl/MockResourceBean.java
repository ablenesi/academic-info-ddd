package edu.ubb.uma.api.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.uma.api.ApiException;
import edu.ubb.uma.api.MockResource;
import edu.ubb.uma.domain.service.MockService;
import edu.ubb.uma.domain.service.ServiceException;

@Stateless(mappedName = MockResource.BEAN_NAME)
@Path("/mock")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class MockResourceBean implements MockResource {
	
	private static final Logger LOG = LoggerFactory.getLogger(MockResource.class);
	
	@EJB
	MockService mockService;

	@Override
	@GET
	public Response mockEverything() throws ApiException {
		LOG.info("mock called");
		try {
			mockService.mockEverything();
			return Response.ok().build();
		} catch (ServiceException e) {
			LOG.error("mock failed", e);
			throw new ApiException("mock failed", e);
		}
	}
}
