package edu.ubb.uma.domain.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.ubb.uma.domain.model.Course;
import edu.ubb.uma.domain.model.Mark;
import edu.ubb.uma.domain.model.Semester;
import edu.ubb.uma.domain.model.User;
import edu.ubb.uma.domain.repo.MarkRepository;
import edu.ubb.uma.domain.repo.RepositoryException;
import edu.ubb.uma.domain.repo.SemesterRepository;
import edu.ubb.uma.domain.repo.UserRepository;
import edu.ubb.uma.domain.service.MockService;
import edu.ubb.uma.domain.service.ServiceException;

@Stateless(mappedName = MockService.BEAN_NAME)
public class MockServiceBean implements MockService{
	
	private static final Logger LOG = LoggerFactory.getLogger(MockService.class);
	
	@EJB
	private UserRepository userRepo;
	
	@EJB
	private MarkRepository markRepo;

	@Override
	public void mockEverything() {
		try {
			User user = new User();
			user.setFullName("Biro Gellert");
			user.setEmail("admin");
			user.setPassWord("admin");
			user.setAdress("Kolozsvar");
			user.setUserName("BGelli");
			
			List<Semester> semesters = new ArrayList<>();
			for(int i=0;i<6;i++){
				Semester sem = new Semester();
				sem.setName("2013-2017  " + (i+1));
				List<Course> courses = new ArrayList<>();
				for(int j=0;j<5;j++){
					Course course = new Course();
					course.setName("Course " + ((10*i)+j));
					course.setCredit(10-j);
					course.setTeacher("Barabas Laszlo");
					courses.add(course);
				}
				sem.setCourses(courses);
				semesters.add(sem);
			}
			user.setSemesters(semesters);
			userRepo.save(user);
			
			mockMarks(user);
			
			
		} catch (RepositoryException e) {
			LOG.error("mockEverything failed", e);
			throw new ServiceException("mockEverything failed", e);
		}
	}
	
	public void mockMarks(User u){
		User user = userRepo.findByEmail(u);
		for(Semester sem : user.getSemesters()){
			for(Course course : sem.getCourses()){
				Mark mark = new Mark();
				mark.setUserId(u.getId());
				mark.setCourseId(course.getId());
				mark.setMark(ThreadLocalRandom.current().nextInt(4, 10 + 1));
				markRepo.save(mark);
			}
		}
	}
}
