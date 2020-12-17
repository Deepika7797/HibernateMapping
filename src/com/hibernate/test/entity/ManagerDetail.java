package com.hibernate.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="manager_detail")
public class ManagerDetail {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="years_of_experience")
	private int yearsOfExperience;
	
	@Column(name="hobby")
	private String hobby;
	
	@OneToOne(mappedBy="managerDetail",cascade=CascadeType.ALL)
	private Manager manager;

	public ManagerDetail(int yearsOfExperience, String hobby) {
		super();
		this.yearsOfExperience = yearsOfExperience;
		this.hobby = hobby;
	}
	
	public ManagerDetail()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "ManagerDetail [id=" + id + ", yearsOfExperience=" + yearsOfExperience + ", hobby=" + hobby
				+ ", manager=" + manager + "]";
	}
	
	

}
