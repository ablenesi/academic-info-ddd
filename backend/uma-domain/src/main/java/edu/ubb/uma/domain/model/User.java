package edu.ubb.uma.domain.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity
@NamedQueries({
	@NamedQuery(name = "findAll", query = "FROM User u")
})
public class User extends BaseEntity {
	
	private String userName;
	private String fullName;
	private String passWord;
	@Column(unique=true)
	private String email;
	private String adress;
	
	@OneToMany(fetch = FetchType.EAGER, cascade={CascadeType.ALL}) @JoinColumn (name="userId")
	private List<Semester> semesters;

	public List<Semester> getSemesters() {
		return semesters;
	}

	public void setSemesters(List<Semester> semesters) {
		this.semesters = semesters;
	}

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

	@Override
	public String toString() {
		return "id: " + id + 
				"; userName: " + userName +
				"; fullName: " + fullName +
				"; email: " + email + 
				"; adress: " + adress;
	}
}