package com.hibernate.test.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="manager")
public class Manager {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;

	@Column(name="email")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="manager_detail_id")
	private ManagerDetail managerDetail;
	
	@OneToMany(mappedBy="manager")
	private List<Project> projects;
	
	public void addProjects(Project newProject)
	{
		if(projects==null)
		{
			projects = new ArrayList<>();
		}
		projects.add(newProject);
		newProject.setManager(this);
	}
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", managerDetail=" + managerDetail + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ManagerDetail getManagerDetail() {
		return managerDetail;
	}

	public void setManagerDetail(ManagerDetail managerDetail) {
		this.managerDetail = managerDetail;
	}
	
	public Manager()
	{
		
	}

	public Manager(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


}
