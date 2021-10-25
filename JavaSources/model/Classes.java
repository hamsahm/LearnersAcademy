package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "classes")
public class Classes {

	@Id
	@Column(name = "class_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long classId;

	@Column(name = "class_name")
	private String className;

	@Column(name = "section")
	private String section;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "classes_subjects", joinColumns = {
			@JoinColumn(name = "class_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "subject_id", nullable = false, updatable = false) })
	@ElementCollection(targetClass = Subjects.class)
	private Set<Subjects> subjects = new HashSet<Subjects>();
		
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "students_classes", joinColumns = {
			@JoinColumn(name = "class_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "student_id", nullable = false, updatable = false) })
	@ElementCollection(targetClass = Students.class)
	private Set<Students> students = new HashSet<Students>();
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "teachers_classes", joinColumns = {
			@JoinColumn(name = "class_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "teacher_id", nullable = false, updatable = false) })
	@ElementCollection(targetClass = Teachers.class)
	private Set<Teachers> teachers = new HashSet<Teachers>();
	
	public Set<Teachers> getTeachers() {
		return teachers;
	}

	public void setTeachers(Set<Teachers> teachers) {
		this.teachers = teachers;
	}

	public Set<Students> getStudents() {
		return this.students;
	}

	public void setStudents(Set<Students> students) {
		this.students = students;
	}

	public long getClassId() {
		return classId;
	}

	public void setClassId(long classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public void setSubjects(Set<Subjects> subjects) {
		this.subjects = subjects;
	}

	public Set<Subjects> getSubjects() {
		return this.subjects;
	}

}
