package edu.knoldus.twitter;

import twitter4j.Query;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;

public class Twitter {

	private twitter4j.Twitter twitter = new TwitterFactory().getInstance();
	private Query query;

	public Twitter(String hashTag) {
		Properties properties = new Properties();
		try {
			InputStream input = new FileInputStream("/home/knoldus/java-assignment-2/src/main/resources/config.properties");
			properties.load(input);
			twitter.setOAuthConsumer(properties.getProperty("consumerKey"), properties.getProperty("consumerSecret"));
			twitter.setOAuthAccessToken(new AccessToken(properties.getProperty("accessToken"), properties.getProperty("accessTokenSecret")));
			query = new Query(hashTag);
			query.setCount(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//get total number of tweets from hashTag
	public CompletableFuture<Integer> noOfTweets() {
		return CompletableFuture.supplyAsync(() -> {
			Integer tweetsCount = 0;
			try {
				//System.out.println(twitter.search(query).getTweets());
				tweetsCount = twitter.search(query).getTweets().size();
			} catch (TwitterException e) {
				e.getMessage();
			}
			return tweetsCount;
		}).thenApply(x -> {
			System.out.println("total tweets" + x);
			return x;
		});
	}


	//average tweets per day
	public CompletableFuture<Double> averageTweetsPerDay() {

		return CompletableFuture.supplyAsync(() -> {

			Double averageTweets = 0.0;
			try {
				averageTweets = twitter.search(query).getTweets().size() / 7.0;
			} catch (TwitterException e) {
				e.getMessage();
			}
			return averageTweets;
		}).thenApply(x -> {
			System.out.println("average tweets per day" + x);
			return x;
		});
	}

	//Average Like Count
	public CompletableFuture<Double> averageLikes() {
		return CompletableFuture.supplyAsync(() -> {
			Double averageLike = 0.0;
			try {

				List<Status> twitterStatus = twitter.search(query).getTweets();
				Double twitterSize = twitterStatus.size() + 0.0;
				averageLike = twitterStatus.parallelStream().map(tweets -> tweets.getFavoriteCount()).reduce((a, b) -> a + b).get()/twitterSize;
			} catch (TwitterException te) {
				te.getMessage();
			}
			return averageLike;
		}).thenApply(x -> {
			System.out.println("average likes" + x);
			return x;
		});
	}

	//Average ReTweetCount
	public CompletableFuture<Double> averageReTweets() {
		return CompletableFuture.supplyAsync(() -> {
			Double totalReTweet = 0.0;
			try {

				List<Status> twitterStatus = twitter.search(query).getTweets();
				Double twitterSize = twitterStatus.size() + 0.0;
				totalReTweet = twitterStatus.parallelStream().map(tweets -> tweets.getRetweetCount()).reduce((a, b) -> a + b).get() / twitterSize;
			} catch (TwitterException te) {
				te.getMessage();
			}
			return totalReTweet;
		}).thenApply(x -> {
			System.out.println("Average reTweets " + x);
			return x;
		});
	}
}