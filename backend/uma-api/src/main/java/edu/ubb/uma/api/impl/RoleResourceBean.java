package edu.ubb.uma.api.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.uma.api.ApiException;
import edu.ubb.uma.api.RoleResource;
import edu.ubb.uma.api.adapter.RoleAdapter;
import edu.ubb.uma.api.dto.RoleDTO;
import edu.ubb.uma.backend.model.Role;
import edu.ubb.uma.backend.repo.impl.UserRepositoryImpl;
import edu.ubb.uma.backend.service.RoleService;
import edu.ubb.uma.backend.service.ServiceException;


@Stateless(mappedName = RoleResource.BEAN_NAME)
@Path("/roles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RoleResourceBean implements RoleResource {

	private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);

	@EJB
	RoleService roleService;

	@Override
	@GET
	@Path("/{id}")
	public Response findById(@PathParam(value = "id") Long id) throws ApiException {
		LOG.info("findById called");
		try {
			Role role = roleService.findById(id);
			return Response.ok(RoleAdapter.fromRole(role)).build();
		} catch (ServiceException e) {
			LOG.error("findById failed", e);
			throw new ApiException("findById failed", e);
		}
	}

	@Override
	@GET
	public Response findAll() throws ApiException {
		LOG.info("findAll called");
		try {
			List<Role> roles = roleService.findAll();			
			return Response.ok(new GenericEntity<List<RoleDTO>>(RoleAdapter.fromList(roles)) {}).build();
		} catch (ServiceException e) {
			LOG.error("findAll failed", e);
			throw new ApiException("findAll failed", e);
		}
	}

	@Override
	@POST
	public Response save(RoleDTO role) throws ApiException {
		LOG.info("save called");
		try {
			roleService.save(RoleAdapter.toRole(role));
			return Response.ok().build();
		} catch (ServiceException e) {
			LOG.error("save failed", e);
			throw new ApiException("save failed", e);
		}
	}

	@Override
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam(value = "id")Long id) throws ApiException {
		LOG.info("delete called");
		try{			
			roleService.delete(id);
			return Response.ok().build();
		} catch (ServiceException e) {
			LOG.error("delete failed", e);
			throw new ApiException("delete failed", e);
		}		
	}
	
	@Override
	@POST
	@Path("/{id}")
	public Response update(@PathParam(value = "id") Long id, RoleDTO role) throws ApiException {
		LOG.info("update called");
		try {
			roleService.update(RoleAdapter.toRole(role));
			return Response.ok().build();
		} catch (ServiceException e) {
			LOG.error("save failed", e);
			throw new ApiException("save failed", e);
		}		
	}
}
