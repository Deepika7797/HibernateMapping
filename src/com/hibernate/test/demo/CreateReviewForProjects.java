package com.hibernate.test.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.test.entity.Employee;
import com.hibernate.test.entity.Manager;
import com.hibernate.test.entity.ManagerDetail;
import com.hibernate.test.entity.Project;
import com.hibernate.test.entity.Review;

public class CreateReviewForProjects {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Manager.class).addAnnotatedClass(ManagerDetail.class)
				.addAnnotatedClass(Project.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Employee.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		try
		{
			session.beginTransaction();
//			to delete the review
//			int theId=1;
//			Review review = session.get(Review.class, theId);
//			session.delete(review);
			int tempId =14; 
			Project project = session.get(Project.class, tempId);
			Review review = new Review("Great project to be worked on");
			Review review1 = new Review("Good project but high manual work");
			Review review2 = new Review("Good learning about Automation");
			project.addReview(review);
			project.addReview(review1);
			project.addReview(review2);
			session.save(review);
			session.save(review1);
			session.save(review2);
			session.getTransaction().commit();
			
		}
		finally
		{
			session.close();
			factory.close();	
		}

}
}
