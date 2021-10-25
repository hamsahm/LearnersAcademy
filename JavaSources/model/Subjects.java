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
@Table(name = "subjects")
public class Subjects {

	@Id
	@Column(name = "subject_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subjectId;

	@Column(name = "subject_name")
	private String subjectName;

	@Column(name = "subject_code")
	private String subjectCode;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "classes_subjects", joinColumns = {
			@JoinColumn(name = "subject_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "class_id", nullable = false, updatable = false) })
	@ElementCollection(targetClass = Classes.class)
	private Set<Classes> classes = new HashSet<Classes>();
	
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "teachers_subjects", joinColumns = {
			@JoinColumn(name = "subject_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "teacher_id", nullable = false, updatable = false) })
	@ElementCollection(targetClass = Subjects.class)
	private Set<Teachers> teachers = new HashSet<Teachers>();

	public Set<Classes> getClasses() {
		return this.classes;
	}

	public void setClasses(Set<Classes> classes) {
		this.classes = classes;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

}
