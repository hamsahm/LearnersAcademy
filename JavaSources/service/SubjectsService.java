package service;

import java.util.List;

import model.Subjects;
import repository.SubjectRepository;

public class SubjectsService {

	public List<Subjects> retrieveListOfSubjects() {
		SubjectRepository subjectRepo = new SubjectRepository();

		List<Subjects> subjects = subjectRepo.retrieveSubjectDetails();

		return subjects;
	}

}
