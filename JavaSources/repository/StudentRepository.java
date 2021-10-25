package repository;

import java.util.List;

import org.hibernate.Session;

import model.Students;
import util.HibernateUtil;

public class StudentRepository {
	/*
	 * Session session;
	 * 
	 * public void initializeConnection() { StandardServiceRegistry
	 * standardServiceRegistry = new StandardServiceRegistryBuilder()
	 * .configure("hibernates.cfg.xml").build(); Metadata metaData = new
	 * MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
	 * SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
	 * this.session = sessionFactory.openSession();
	 * System.out.println("Hibernate Session opened!"); }
	 */
	public List<Students> retrieveStudentsDetails() {

		HibernateUtil util = new HibernateUtil();

		Session session = util.initializeConnection();

		String hibernateQuery = "select s from Students s";
		List<Students> students = session.createQuery(hibernateQuery, Students.class).getResultList();
		
		util.closeSession();
		return students;
	}

	/*
	 * public void closeSession() { System.out.println("Hibernate Session closed!");
	 * session.close(); }
	 */
}
