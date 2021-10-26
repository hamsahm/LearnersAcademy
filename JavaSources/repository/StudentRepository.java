package repository;

import java.util.List;

import org.hibernate.Session;

import model.Students;
import util.HibernateUtil;

public class StudentRepository {
	public List<Students> retrieveStudentsDetails() {

		HibernateUtil util = new HibernateUtil();

		Session session = util.initializeConnection();

		String hibernateQuery = "select s from Students s";
		List<Students> students = session.createQuery(hibernateQuery, Students.class).getResultList();

		util.closeSession();
		return students;
	}

}
