package edu.ubb.uma.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.uma.backend.model.User;
import edu.ubb.uma.backend.service.ServiceException;
import edu.ubb.uma.backend.service.UserService;

@WebServlet(urlPatterns = "/")
public class UmaServlet extends HttpServlet {

	private static final Logger LOG = LoggerFactory.getLogger(UmaServlet.class);
	private static final long serialVersionUID = 1L;

	@EJB
	UserService userService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.info("GET tecieved");
		
		List<String> userNames = new ArrayList<>();
		
		for(User user: userService.findAll()){
			userNames.add(user.getUserName());
		}
		
		req.setAttribute("users", userNames);
	    req.getRequestDispatcher("/WEB-INF/table.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.info("POST tecieved");
		
		User user = new User();
		user.setUserName("UserName test" + System.currentTimeMillis());
		user.setFullName("FullName test" + System.currentTimeMillis());
		user.setPassWord("pwd".getBytes());
		try {
			userService.save(user);
			resp.getWriter().write("User created");
		} catch (ServiceException e) {
			resp.getWriter().write("Sace failed" + e);
			resp.setStatus(500);
		}
	}

}
