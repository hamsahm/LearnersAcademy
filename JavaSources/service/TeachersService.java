package service;

import java.util.List;

import model.Teachers;
import repository.TeacherRepository;


public class TeachersService {
	

	public List<Teachers> retrieveListOfSubjects() {
		TeacherRepository teacherRepo = new TeacherRepository();

		teacherRepo.initializeConnection();
		List<Teachers> teachers = teacherRepo.retrieveTeacherDetails();
		
		System.out.println("teachers"+teachers);
		teacherRepo.closeSession();

		return teachers;
	}

}
