package org.studyeasy;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("Hibernate.cfg.xml").addAnnotatedClass(user.class)
				.buildSessionFactory();
		
		Session session=factory.getCurrentSession();
		try {
			user use=new user("RAJAT", "KUKREJA");
			session.beginTransaction();
			session.save(use);
			System.out.println("Row Added successfully");
			session.getTransaction().commit();
		} finally {
			session.close();
			factory.close();
		}

	}
}
