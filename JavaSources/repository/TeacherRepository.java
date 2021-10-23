package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import model.Teachers;

public class TeacherRepository {
	Session session;

	public void initializeConnection() {
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
				.configure("hibernates.cfg.xml").build();
		Metadata metaData = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
		this.session = sessionFactory.openSession();
		System.out.println("Hibernate Session opened!");
	}

	public List<Teachers> retrieveTeacherDetails() {

		String hibernateQuery = "select s from Teachers s";
		List<Teachers> teachers = session.createQuery(hibernateQuery, Teachers.class).getResultList();

		System.out.println("teachers in repository"+teachers);
		return teachers;
	}

	public void closeSession() {
		System.out.println("Hibernate Session closed!");
		session.close();
	}

}
