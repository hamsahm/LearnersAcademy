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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teachers {

	@Id
	@Column(name = "teacher_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long teacherId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "age")
	private int age;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "teachers_classes", joinColumns = {
			@JoinColumn(name = "teacher_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "class_id", nullable = false, updatable = false) })
	@ElementCollection(targetClass = Classes.class)
	private Set<Classes> classes = new HashSet<Classes>();

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "teachers_subjects", joinColumns = {
			@JoinColumn(name = "teacher_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "subject_id", nullable = false, updatable = false) })
	@ElementCollection(targetClass = Subjects.class)
	private Set<Subjects> subjects = new HashSet<Subjects>();

	public Set<Classes> getClasses() {
		return classes;
	}

	public void setClasses(Set<Classes> classes) {
		this.classes = classes;
	}

	public long getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(long teacherId) {
		this.teacherId = teacherId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
