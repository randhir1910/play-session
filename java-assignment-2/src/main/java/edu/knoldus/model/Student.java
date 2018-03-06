package edu.knoldus.model;

import java.util.List;
import java.util.Optional;

public class Student {

	public String getName() {
		return name;
	}

	/**
	 * @return get Student List.
	 */
	public final Optional<List<String>> getSubjectList() {
		return subjectList;
	}

	private String name;
	private int rollNumber;
	private Optional<List<String>> subjectList;

	public Student(final String nameParam, final Integer rollNoParam, final Optional<List<String>> subjectParam) {
		this.name = nameParam;
		this.rollNumber = rollNoParam;
		this.subjectList = subjectParam;
	}

	@Override
	public String toString() {
		return name + " " + rollNumber + " " + subjectList;
	}

	/**
	 *
	 * @param object of student.
	 * @return compare equality of object.
	 */
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		if (!Student.class.isAssignableFrom(object.getClass())) {
			return false;
		}
		final Student other = (Student) object;
		if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
			return false;
		}
		if (this.getSubjectList() != other.getSubjectList()) {
			return false;
		}

		if (this.rollNumber != other.rollNumber) {
			return false;
		}
		return true;
	}
}
