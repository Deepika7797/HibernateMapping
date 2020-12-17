package com.hibernate.test.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.test.entity.Employee;
import com.hibernate.test.entity.Manager;
import com.hibernate.test.entity.ManagerDetail;
import com.hibernate.test.entity.Project;
import com.hibernate.test.entity.Review;

public class CreateLinkBetweenManagerAndProject {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Manager.class).addAnnotatedClass(ManagerDetail.class)
				.addAnnotatedClass(Project.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try
		{
			session.beginTransaction();
			//delete
//			int tempId2 =13; 
//			Project pro = session.get(Project.class, tempId2);
//			session.delete(pro);
			int tempId1 =1;
			int tempId2 =2; 
			Manager manager1 = session.get(Manager.class, tempId1);
			Manager manager2 = session.get(Manager.class, tempId2);
			Project project1 = new Project("Mortgage");
			Project project2 = new Project("Retail");
			Project project3 = new Project("Banking");
			Project project4 = new Project("Marketing");
			manager1.addProjects(project2);
			manager1.addProjects(project4);
			manager2.addProjects(project1);
			manager2.addProjects(project3);
			session.save(project1);
			session.save(project2);
			session.save(project3);
			session.save(project4);
			session.getTransaction().commit();		
		}
		finally
		{
			session.close();
			factory.close();
		}
	}

}
