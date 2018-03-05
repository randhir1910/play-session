package edu.knoldus;

import edu.knoldus.model.ClassRoom;
import edu.knoldus.model.Student;
import edu.knoldus.twitter.Twitter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class Application {

	public static void main(String[] args) {

		Twitter twitter = new Twitter("#Pari");
		System.out.println(twitter.noOfTweets());
		System.out.println(twitter.averageTweetsPerDay());
		System.out.println(twitter.averageLikes());
		System.out.println(twitter.averageReTweets());
		try {
			Thread.sleep(30000);
		}catch (InterruptedException e)
		{
			e.getMessage();
		}

	}
}
