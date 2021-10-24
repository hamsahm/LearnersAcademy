package service;

import java.util.List;

import model.Students;
import repository.StudentRepository;

public class StudentsService {

	public List<Students> retrieveListOfStudents() {
		StudentRepository studentRepo = new StudentRepository();

		studentRepo.initializeConnection();
		List<Students> students = studentRepo.retrieveStudentsDetails();

		studentRepo.closeSession();

		return students;
	}

}
