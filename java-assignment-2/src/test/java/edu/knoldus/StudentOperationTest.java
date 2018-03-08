package edu.knoldus;

import edu.knoldus.constant.Constant;
import edu.knoldus.model.ClassRoom;
import edu.knoldus.model.Student;
import edu.knoldus.service.StudentOperation;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

/**
 * student class test cases.
 */
public class StudentOperationTest {
	
	private static List<String> subject = Arrays.asList("maths", "science", "physics");
	private static final Student studentFirst = new Student("randhir", Constant.TEN, Optional.of(subject));
	private static final Student studentSecond = new Student("ravi", Constant.ELEVEN, Optional.ofNullable(null));
	private static final List<Student> studentsList = Arrays.asList(studentFirst, studentSecond);
	/**
	 * classRoom reference create.
	 */
	private static ClassRoom classRoom;
	
	/**
	 * classRoom Instance initialization.
	 */
	@BeforeClass
	public static void setUp() {
		classRoom = new ClassRoom(Constant.HUNDREDONE, Optional.of(studentsList));
	}
	
	/**
	 * all test cases of classRoom.
	 */
	@Test
	public void addTest() {
		List<ClassRoom> classRoomList = new ArrayList<>();
		classRoomList.add(classRoom);
		List<Student> studentListTest = StudentOperation.studentWithNoSubject(classRoomList);
		List<List<String>> expectedSubject = Arrays.asList(Arrays.asList("maths", "science", "physics"));
		List<List<String>> getSubject = StudentOperation.getSubject(Constant.HUNDREDONE, Arrays.asList(classRoom));
		List<String> getSayHello = StudentOperation.sayHelloStudent(classRoomList);
		List<String> expectedSayHello = Arrays.asList("hello randhir", "hello ravi");
		assertEquals(studentListTest, Arrays.asList(studentSecond));
		assertEquals(expectedSubject, getSubject);
		assertEquals(expectedSayHello, getSayHello);
		
	}
}
