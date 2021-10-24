package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.Students;

public class StudentRepository {
	
	Session session;

	public void initializeConnection() {
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
				.configure("hibernates.cfg.xml").build();
		Metadata metaData = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
		this.session = sessionFactory.openSession();
		System.out.println("Hibernate Session opened!");
	}

	public List<Students> retrieveStudentsDetails() {

		String hibernateQuery = "select s from Students s";
		List<Students> students = session.createQuery(hibernateQuery, Students.class).getResultList();

		return students;
	}

	public void closeSession() {
		System.out.println("Hibernate Session closed!");
		session.close();
	}


}
