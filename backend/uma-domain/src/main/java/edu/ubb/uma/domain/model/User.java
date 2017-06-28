package edu.ubb.uma.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "findAll", query = "FROM User u")
})
public class User extends BaseEntity {
	
	@Column(unique=true)
	private String userName;
	private String fullName;
	private String passWord;
	private String email;
	private String adress;
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private Role role;
	
	public User(){
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "id: " + id + 
				"; userName: " + userName +
				"; fullName: " + fullName +
				"; email: " + email + 
				"; adress: " + adress;
	}

}
