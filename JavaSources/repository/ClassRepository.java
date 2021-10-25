package repository;

import java.util.List;

import org.hibernate.Session;

import model.Classes;
import util.HibernateUtil;

public class ClassRepository {

	public List<Classes> retrieveClassDetails() {
		HibernateUtil util = new HibernateUtil();
		
		Session session = util.initializeConnection();
		
		String hibernateQuery = "select c from Classes c";
		List<Classes> classes = session.createQuery(hibernateQuery, Classes.class).getResultList();
		
		util.closeSession();
		return classes;
	}
	
	
}
