package edu.knoldus.model;

import java.util.List;
import java.util.Optional;

public class ClassRoom {
	
	
	private Integer roomId;
	private Optional<List<Student>> studentList;
	
	/**
	 * @param roomIdParam  of classroom.
	 * @param studentParam of student.
	 */
	public ClassRoom(final Integer roomIdParam, final Optional<List<Student>> studentParam) {
		this.roomId = roomIdParam;
		this.studentList = studentParam;
	}
	
	public Integer getRoomId() {
		return roomId;
	}
	
	public Optional<List<Student>> getStudentList() {
		return studentList;
	}
	
	@Override
	public String toString() {
		return roomId + " " + studentList;
	}
	
}
