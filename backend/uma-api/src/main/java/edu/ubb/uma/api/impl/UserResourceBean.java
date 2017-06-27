package edu.ubb.uma.api.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.uma.api.ApiException;
import edu.ubb.uma.api.JWTTokenNeeded;
import edu.ubb.uma.api.UserResource;
import edu.ubb.uma.api.adapter.UserAdapter;
import edu.ubb.uma.api.dto.UserDTO;
import edu.ubb.uma.api.util.KeyGenerator;
import edu.ubb.uma.api.util.SimpleKeyGenerator;
import edu.ubb.uma.backend.model.User;
import edu.ubb.uma.backend.repo.impl.UserRepositoryImpl;
import edu.ubb.uma.backend.service.ServiceException;
import edu.ubb.uma.backend.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.Key;
import javax.ws.rs.core.UriInfo;
import java.time.ZoneId;

import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

@Stateless(mappedName = UserResource.BEAN_NAME)
@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class UserResourceBean implements UserResource {

	private static final Logger LOG = LoggerFactory.getLogger(UserRepositoryImpl.class);

	@EJB
	UserService userService;

	@Context
	private UriInfo uriInfo;
	
	private KeyGenerator keyGenerator = new SimpleKeyGenerator();

	@Override
	@GET
	@Path("/{id}")
	@JWTTokenNeeded
	public Response findById(@PathParam(value = "id") Long id) throws ApiException {
		LOG.info("findById called");
		try {
			User user = userService.findById(id);
			return Response.ok(UserAdapter.fromUser(user)).build();
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
			List<User> users = userService.findAll();
			return Response.ok(new GenericEntity<List<UserDTO>>(UserAdapter.fromList(users)) {
			}).build();
		} catch (ServiceException e) {
			LOG.error("findAll failed", e);
			throw new ApiException("findAll failed", e);
		}
	}

	@Override
	@POST
	public Response save(UserDTO user) throws ApiException {
		LOG.info("save called");
		try {
			userService.save(UserAdapter.toUser(user));
			return Response.ok().build();
		} catch (ServiceException e) {
			LOG.error("save failed", e);
			throw new ApiException("save failed", e);
		}
	}

	@Override
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam(value = "id") Long id) throws ApiException {
		LOG.info("delete called");
		try {
			userService.delete(id);
			return Response.ok().build();
		} catch (ServiceException e) {
			LOG.error("delete failed", e);
			throw new ApiException("delete failed", e);
		}
	}

	@Override
	@POST
	@Path("/{id}")
	public Response update(@PathParam(value = "id") Long id, UserDTO user) throws ApiException {
		LOG.info("update called");
		try {
			userService.update(UserAdapter.toUser(user));
			return Response.ok().build();
		} catch (ServiceException e) {
			LOG.error("save failed", e);
			throw new ApiException("save failed", e);
		}
	}

	@POST
	@Path("/login")
	@Override
	public Response login(UserDTO user) throws ApiException {
		try {
			// Authenticate the user using the credentials provided
			LOG.info("login called" + user.getEmail() + user.getPassWord());
			
			if(userService.authenticate(UserAdapter.toUser(user))){
				LOG.info("login succes");
				// Issue a token for the user
				String token = issueToken(user.getEmail());
	
				// Return the token on the response
				return Response.ok().header(AUTHORIZATION, "Token " + token).build();
			}
			else{
				LOG.info("login failed");
				return Response.status(UNAUTHORIZED).build();
			}

		} catch (Exception e) {
			return Response.status(UNAUTHORIZED).build();
		}

	}

	private String issueToken(String login) {
		Key key = keyGenerator.generateKey();
		String jwtToken = Jwts.builder().setSubject(login).setIssuer(uriInfo.getAbsolutePath().toString())
				.setIssuedAt(new Date()).setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
				.signWith(SignatureAlgorithm.HS512, key).compact();
		return jwtToken;
	}

	private Date toDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

}
