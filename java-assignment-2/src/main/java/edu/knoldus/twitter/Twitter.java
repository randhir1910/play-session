package edu.knoldus.twitter;

import edu.knoldus.constant.Constant;
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
import java.util.stream.Collectors;

public class Twitter {

	private twitter4j.Twitter twitter = new TwitterFactory().getInstance();
	private Query query;

	/**
	 * set twitter instance.
	 *
	 * @param hashTag as Input.
	 */
	public Twitter(String hashTag) {
		Properties properties = new Properties();
		try {
			InputStream input = new FileInputStream("/home/knoldus/java-assignment-2/src/main/"
					+ "resources/config.properties");
			properties.load(input);
			twitter.setOAuthConsumer(properties.getProperty("consumerKey"), properties
					.getProperty("consumerSecret"));
			twitter.setOAuthAccessToken(new AccessToken(properties.getProperty("accessToken")
					, properties.getProperty("accessTokenSecret")));
			query = new Query(hashTag);
			query.setSince("2018-03-01");
			query.setUntil("2018-03-08");
			query.setCount(Constant.HUNDRED);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return get twitter data from timeline.
	 */

	public final CompletableFuture<List<String>> getTweets() {
		return CompletableFuture.supplyAsync(() -> {
			List<String> tweets = null;
			try {
				List<Status> statusList = twitter.search(query).getTweets();
				tweets = statusList.parallelStream().map(tweetsData -> tweetsData.getText()).collect(Collectors.toList());
			} catch (TwitterException e) {
				e.getMessage();
			}
			return tweets;
		});
	}

	/**
	 * @return no of tweets on the basis of hashTag.
	 */
	public final CompletableFuture<Integer> noOfTweets() {
		return CompletableFuture.supplyAsync(() -> {
			Integer tweetsCount = Constant.IZERO;
			try {
				tweetsCount = twitter.search(query).getTweets().size();
			} catch (TwitterException e) {
				e.getMessage();
			}
			return tweetsCount;
		});
	}


	/**
	 * @return average tweets per day of seven days from 1 match 2018 to 8 march.
	 */
	public final CompletableFuture<Double> averageTweetsPerDay() {

		return CompletableFuture.supplyAsync(() -> {

			Double averageTweets = Constant.ZERO;
			try {
				averageTweets = twitter.search(query).getTweets().size() / Constant.SEVEN;
			} catch (TwitterException e) {
				e.getMessage();
			}
			return averageTweets;
		});
	}

	/**
	 * @return average likes of tweets.
	 */
	public final CompletableFuture<Double> averageLikes() {
		return CompletableFuture.supplyAsync(() -> {
			Double averageLike = Constant.ZERO;
			try {

				List<Status> twitterStatus = twitter.search(query).getTweets();
				Double twitterSize = twitterStatus.size() + Constant.ZERO;
				averageLike = twitterStatus.parallelStream().map(tweets -> tweets.getFavoriteCount())
						.reduce((a, b) -> a + b).get() / twitterSize;
			} catch (TwitterException te) {
				te.getMessage();
			}
			return averageLike;
		});
	}

	/**
	 * @return average reTweets.
	 */
	public final CompletableFuture<Double> averageReTweets() {
		return CompletableFuture.supplyAsync(() -> {
			Double totalReTweet = Constant.ZERO;
			try {

				List<Status> twitterStatus = twitter.search(query).getTweets();
				Double twitterSize = twitterStatus.size() + Constant.ZERO;
				totalReTweet = twitterStatus.parallelStream().map(tweets -> tweets.getRetweetCount())
						.reduce((a, b) -> a + b).get() / twitterSize;
			} catch (TwitterException te) {
				te.getMessage();
			}
			return totalReTweet;
		});
	}
}