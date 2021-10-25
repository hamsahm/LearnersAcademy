package service;

import java.util.List;

import model.Classes;
import repository.ClassRepository;

public class ClassesService {

	public List<Classes> retrieveListOfClasses() {
		ClassRepository classRepo = new ClassRepository();

		List<Classes> classes = classRepo.retrieveClassDetails();

		return classes;
	}

}
