package edu.ubb.uma.api.adapter;

import java.util.ArrayList;
import java.util.List;

import edu.ubb.uma.api.dto.RoleDTO;
import edu.ubb.uma.backend.model.Role;

public class RoleAdapter {
	
	public static Role toRole(RoleDTO roleDTO){
		if(roleDTO == null){
			return null;
		}
		Role role = new Role();
		role.setDescription(roleDTO.getDescription());
		role.setId(roleDTO.getId());
		role.setRole(roleDTO.getRole());
		return role;
	}
	
	public static RoleDTO fromRole(Role role){
		if(role == null){
			return null;
		}
		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setDescription(role.getDescription());
		roleDTO.setId(role.getId());
		roleDTO.setRole(role.getRole());
		return roleDTO;
	}
	
	public static List<RoleDTO> fromList(List<Role> roles){
		if(roles==null || roles.size()==0){
			return new ArrayList<>();
		}
		List<RoleDTO> roleDTOs =  new ArrayList<>(roles.size());
		for(Role role : roles){
			roleDTOs.add(fromRole(role));
		}			
		return roleDTOs;
	}
	
}
