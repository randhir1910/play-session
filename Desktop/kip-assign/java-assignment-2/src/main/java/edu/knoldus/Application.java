package edu.knoldus;

import edu.knoldus.constant.Constant;
import edu.knoldus.model.ClassRoom;
import edu.knoldus.model.Student;
import edu.knoldus.service.StudentOperation;
import edu.knoldus.twitter.Twitter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public final class Application {
	
	public static void main(String[] args) {
		
		List<String> subject = Arrays.asList("maths", "science", "physics");
		
		Student student1 = new Student("randhir", Constant.TEN, Optional.of(subject));
		Student student2 = new Student("ravi", Constant.ELEVEN, Optional.ofNullable(null));
		List<Student> studentList = Arrays.asList(student1, student2);
		ClassRoom classRoom1 = new ClassRoom(Constant.HUNDREDONE, Optional.of(studentList));
		
		System.out.println(StudentOperation.sayHelloStudent(Arrays.asList(classRoom1)));
		System.out.println(StudentOperation.studentWithNoSubject(Arrays.asList(classRoom1)));
		System.out.println(StudentOperation.getSubject(Constant.HUNDREDONE, Arrays.asList(classRoom1)));
		
		Twitter twitter = new Twitter("#cricket");
		twitter.getTweets().thenAccept(tweets -> System.out.println("total tweets " + tweets));
		twitter.noOfTweets().thenAccept(noOfTweets -> System.out.println("no of tweets " + noOfTweets));
		twitter.averageTweetsPerDay().thenAccept(averageTweets -> System.out.println("average tweets " + averageTweets));
		twitter.averageLikes().thenAccept(averageLikes -> System.out.println("average likes " + averageLikes));
		twitter.averageReTweets().thenAccept(averageReTweets -> System.out.println("average reTweets " + averageReTweets));
		try {
			Thread.sleep(Constant.TENTHOUSAND);
		} catch (InterruptedException ie) {
			ie.getMessage();
		}
		
	}
}
