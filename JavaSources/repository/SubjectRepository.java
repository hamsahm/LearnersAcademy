package repository;

import java.util.List;

import org.hibernate.Session;

import model.Subjects;
import util.HibernateUtil;

public class SubjectRepository {

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

	public List<Subjects> retrieveSubjectDetails() {

		HibernateUtil util = new HibernateUtil();

		Session session = util.initializeConnection();

		String hibernateQuery = "select s from Subjects s";
		List<Subjects> subjects = session.createQuery(hibernateQuery, Subjects.class).getResultList();

		util.closeSession();
		return subjects;
	}

	/*
	 * public void closeSession() { System.out.println("Hibernate Session closed!");
	 * session.close(); }
	 */
}
