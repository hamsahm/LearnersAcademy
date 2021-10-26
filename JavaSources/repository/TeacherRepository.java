package repository;

import java.util.List;

import org.hibernate.Session;

import model.Teachers;
import util.HibernateUtil;

public class TeacherRepository {

	public List<Teachers> retrieveTeacherDetails() {

		HibernateUtil util = new HibernateUtil();

		Session session = util.initializeConnection();

		String hibernateQuery = "select s from Teachers s";
		List<Teachers> teachers = session.createQuery(hibernateQuery, Teachers.class).getResultList();

		util.closeSession();
		return teachers;
	}

}
