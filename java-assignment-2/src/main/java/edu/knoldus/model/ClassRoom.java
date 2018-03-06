package edu.knoldus.model;

import java.util.List;
import java.util.Optional;

/**
 * classRoom of student.
 */
public class ClassRoom {

	/**
	 * @return getRoom Id.
	 */
	public final Integer getRoomId() {
		return roomId;
	}

	/**
	 * @return studentList.
	 */
	public final Optional<List<Student>> getStudentList() {
		return studentList;
	}

	private Integer roomId;
	private Optional<List<Student>> studentList;

	/**
	 * @param roomId of classroom.
	 * @param list   of student.
	 */
	public ClassRoom(final Integer roomIdParameter, final Optional<List<Student>> studentParameter) {
		this.roomId = roomIdParameter;
		this.studentList = studentParameter;
	}

	@Override
	public String toString() {
		return roomId + " " + studentList;
	}

}
