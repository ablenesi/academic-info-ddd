package edu.ubb.uma.api.impl;

import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.uma.api.ApiException;
import edu.ubb.uma.api.SemesterResource;

public class SemesterResourceBean implements SemesterResource{

	private static final Logger LOG = LoggerFactory.getLogger(SemesterResourceBean.class);
	
	@Override
	public Response findByUser() throws ApiException {
		// TODO Auto-generated method stub
		return null;
	}

}
