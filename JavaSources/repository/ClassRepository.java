package repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import model.Classes;

public class ClassRepository {
Session session;
	
	public void initializeConnection() {
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
				.configure("hibernates.cfg.xml").build();
		Metadata metaData = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
		SessionFactory sessionFactory = metaData.getSessionFactoryBuilder().build();
		this.session = sessionFactory.openSession();
		System.out.println("Hibernate Session opened!");
	}
	
	public List<Classes> retrieveClassDetails() {

		String hibernateQuery = "select c from Classes c";
		List<Classes> classes = session.createQuery(hibernateQuery, Classes.class).getResultList();
		
		return classes;
	}
	

	public void closeSession() {
		System.out.println("Hibernate Session closed!");
		session.close();
	}

}
