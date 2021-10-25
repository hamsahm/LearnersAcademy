package repository;

import java.util.List;

import org.hibernate.Session;

import model.Teachers;
import util.HibernateUtil;

public class TeacherRepository {
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

	public List<Teachers> retrieveTeacherDetails() {

		HibernateUtil util = new HibernateUtil();

		Session session = util.initializeConnection();

		String hibernateQuery = "select s from Teachers s";
		List<Teachers> teachers = session.createQuery(hibernateQuery, Teachers.class).getResultList();

		util.closeSession();
		return teachers;
	}

	/*
	 * public void closeSession() { System.out.println("Hibernate Session closed!");
	 * session.close(); }
	 */

}
