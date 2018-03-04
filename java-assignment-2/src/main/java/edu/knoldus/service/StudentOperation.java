package edu.knoldus.service;

import edu.knoldus.model.ClassRoom;
import edu.knoldus.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentOperation {

	public List<Student> studentWithNoSubject(List<ClassRoom> classRoomList) {
		return classRoomList.stream()
				.filter(classRoom -> classRoom.getStudentList().isPresent()).flatMap(classRoomWithStudent -> classRoomWithStudent.getStudentList().get().stream()
						.filter(student -> !student.getSubjectList().isPresent())).collect(Collectors.toList());
	}

	public List<String> sayHelloStudent(List<ClassRoom> classRoomList) {

		return classRoomList.stream()
				.filter(classRoom -> classRoom.getStudentList().isPresent())
				.flatMap(classWithStudent -> classWithStudent.getStudentList().get()
						.stream().map(student -> "hello" + student.getName())).collect(Collectors.toList());
	}

	public Optional<List<String>> getSubject(Integer id, List<ClassRoom> classRoomList) {
		return classRoomList.stream()
				.filter(classRoom -> classRoom.getStudentList().isPresent() && classRoom.getRoomId() == id)
				.flatMap(classWithStudent -> classWithStudent.getStudentList().get()
						.stream().filter(student -> student.getSubjectList().isPresent())
						.map(student -> student.getSubjectList()))
				.collect(Collectors.toList());

	}
}
