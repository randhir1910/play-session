package edu.knoldus.service;

import edu.knoldus.model.ClassRoom;
import edu.knoldus.model.Student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentOperation {
	
	/**
	 * @param classRoomList list of classroom of student.
	 * @return student with no subject.
	 */
	public static List<Student> studentWithNoSubject(final List<ClassRoom> classRoomList) {
		return classRoomList.stream()
				.filter(classRoom -> classRoom.getStudentList()
						.isPresent()).flatMap(classRoomWithStudent
						-> classRoomWithStudent
						.getStudentList().get().stream()
						.filter(student -> !student.getSubjectList()
								.isPresent()))
				.collect(Collectors.toList());
	}
	
	/**
	 * @param classRoomList list of classroom of student.
	 * @return students name with hello.
	 */
	public static List<String> sayHelloStudent(final List<ClassRoom> classRoomList) {
		
		return classRoomList.stream()
				.filter(classRoom -> classRoom.getStudentList().isPresent())
				.flatMap(classWithStudent -> classWithStudent.getStudentList().get()
						.stream().map(student -> "hello " + student.getName()))
				.collect(Collectors.toList());
	}
	
	/**
	 * @param id            of classroom .
	 * @param classRoomList list of classroom of student.
	 * @return subjects that is associate with classRoom.
	 */
	public static List<List<String>> getSubject(final Integer id, final List<ClassRoom> classRoomList) {
		return classRoomList.stream()
				.filter(classRoom -> classRoom.getStudentList().isPresent()
						&& classRoom.getRoomId() == id)
				.flatMap(classWithStudent -> classWithStudent.getStudentList().get()
						.stream().filter(student -> student.getSubjectList().isPresent()).
								map(student -> student.getSubjectList().get())).collect(Collectors.toList());
	}
}