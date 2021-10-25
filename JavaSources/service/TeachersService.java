package service;

import java.util.List;

import model.Teachers;
import repository.TeacherRepository;

public class TeachersService {

	public List<Teachers> retrieveListOfSubjects() {
		TeacherRepository teacherRepo = new TeacherRepository();

		List<Teachers> teachers = teacherRepo.retrieveTeacherDetails();

		return teachers;
	}

}
