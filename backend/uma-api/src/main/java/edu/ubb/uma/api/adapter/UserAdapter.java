package edu.ubb.uma.api.adapter;

import java.util.ArrayList;
import java.util.List;

import edu.ubb.uma.api.dto.UserDTO;
import edu.ubb.uma.domain.model.Role;
import edu.ubb.uma.domain.model.User;

public class UserAdapter {
	
	public static User toUser(UserDTO userDTO){
		if(userDTO ==null){
			return null;
		}
		User user  =  new User();
		user.setAdress(userDTO.getAdress());
		user.setEmail(userDTO.getEmail());
		user.setFullName(userDTO.getFullName());
		user.setId(userDTO.getId());
		user.setPassWord(userDTO.getPassWord());
		if(user.getRole()!=null){
			Role role = new Role();			
			role.setRole(userDTO.getRole());
			user.setRole(role);
		}
		user.setUserName(userDTO.getUserName());
		return user;
	}
	
	public static UserDTO fromUser(User user){
		if(user == null){
			return null;
		}
		UserDTO userDTO = new UserDTO();
		userDTO.setAdress(user.getAdress());
		userDTO.setEmail(user.getEmail());
		userDTO.setFullName(user.getFullName());
		userDTO.setId(user.getId());
		userDTO.setPassWord(user.getPassWord());		
		if(user.getRole()!=null){
			userDTO.setRole(user.getRole().getRole());
		}
		userDTO.setUserName(user.getUserName());
		return userDTO;
	}

	public static List<UserDTO> fromList(List<User> users){
		if(users==null || users.size()==0){
			return new ArrayList<>();
		}
		List<UserDTO> userDTOs =  new ArrayList<>(users.size());
		for(User user : users){
			userDTOs.add(fromUser(user));
		}			
		return userDTOs;
	}
	
}
