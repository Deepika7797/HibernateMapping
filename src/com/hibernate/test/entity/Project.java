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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="project")
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="manager_id")
	private Manager manager;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="project_id")
	private List<Review> reviews;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH, CascadeType.REFRESH})
	@JoinTable(
			name="project_employee",
			joinColumns=@JoinColumn(name="project_id"),
			inverseJoinColumns=@JoinColumn(name="employee_id")
			)	
	private List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void addEmployee(Employee newEmployee) {
		
		if (employees == null) {
			employees = new ArrayList<>();
		}
		
		employees.add(newEmployee);
	}
	
	public Project(String title) {
		super();
		this.title = title;
	}
	
	public Project()
	{
		
	}
	public void addReview(Review theReview) {
		
		if (reviews == null) {
			reviews = new ArrayList<>();
		}
		
		reviews.add(theReview);
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", title=" + title + ", manager=" + manager + "]";
	}

	
}
