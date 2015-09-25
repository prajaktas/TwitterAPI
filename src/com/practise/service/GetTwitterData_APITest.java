package com.practise.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

public class GetTwitterData_APITest {
	String AccessToken = "3531925812-3JLHgJLVyJOSOvwrtprfvN4wBm2OAiyzQwXoqlp";
	String AccessSecret = "9gS2VjjfB7wFMxIMvdXaBSmPKcvdagh9K98i0ys39CP0e";
	String ConsumerKey = "AxI6LtrInafg185gXG1iYFw9d";
	String ConsumerSecret = "CVwtjVzT1AIEdcZiJOoK403xiPTXTfPD38abEfXEOWQkPVvGE9";
	int statusExpected = 200;
	@Test
	public void testGetFollowersDetails() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException {
		
		
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
		
		consumer.setTokenWithSecret(AccessToken, AccessSecret);
        HttpGet APIrequest = new HttpGet("https://api.twitter.com/1.1/followers/list.json");
        consumer.sign(APIrequest);
        
        HttpClient client = new DefaultHttpClient();
        HttpResponse APIresponse = client.execute(APIrequest);
        
        int statusCode = APIresponse.getStatusLine().getStatusCode();
        
		assertEquals(statusExpected, statusCode);
		
		//fail("Not yet implemented");
	}

	@Test
	public void testGetFriendsList() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException {
		
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
		
		consumer.setTokenWithSecret(AccessToken, AccessSecret);
        HttpGet APIrequest = new HttpGet("https://api.twitter.com/1.1/friends/list.json");
        consumer.sign(APIrequest);
        
        HttpClient client = new DefaultHttpClient();
        HttpResponse APIresponse = client.execute(APIrequest);
        
        int statusCode = APIresponse.getStatusLine().getStatusCode();
        
        assertEquals(statusExpected, statusCode);
	}
	@Test
	public void testGetUserData() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
				
				consumer.setTokenWithSecret(AccessToken, AccessSecret);
		        HttpGet APIrequest = new HttpGet("https://api.twitter.com/1.1/users/lookup.json?screen_name=shrutibidnur");
		        consumer.sign(APIrequest);
		        
		        HttpClient client = new DefaultHttpClient();
		        HttpResponse APIresponse = client.execute(APIrequest);
		        
		        int statusCode = APIresponse.getStatusLine().getStatusCode();
		        assertEquals(statusExpected, statusCode);
			}
	@Test
	public void testGetUserTwits() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
		
		consumer.setTokenWithSecret(AccessToken, AccessSecret);
        HttpGet APIrequest = new HttpGet("https://api.twitter.com/1.1/statuses/mentions_timeline.json");
        consumer.sign(APIrequest);
        
        HttpClient client = new DefaultHttpClient();
        HttpResponse APIresponse = client.execute(APIrequest);
        
        int statusCode = APIresponse.getStatusLine().getStatusCode();
        assertEquals(statusExpected, statusCode);
	}
	@Test
	public void testGetViewUserData() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
		
		consumer.setTokenWithSecret(AccessToken, AccessSecret);
		/*hard coding user name */
		String searchName = "prajaktas29";
		HttpGet APIrequest = new HttpGet("https://api.twitter.com/1.1/users/show.json?screen_name="+searchName);
		consumer.sign(APIrequest);
        
        HttpClient client = new DefaultHttpClient();
        HttpResponse APIresponse = client.execute(APIrequest);
        
        int statusCode = APIresponse.getStatusLine().getStatusCode();
        assertEquals(statusExpected, statusCode);
	}
	@Test
	public void testGetUserTimeline() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
		/*hard coding user name */
		String screenName = "prajaktas29";
		consumer.setTokenWithSecret(AccessToken, AccessSecret);
		HttpGet APIrequest = new HttpGet("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name="+screenName);
		consumer.sign(APIrequest);
        
        HttpClient client = new DefaultHttpClient();
        HttpResponse APIresponse = client.execute(APIrequest);
        
        int statusCode = APIresponse.getStatusLine().getStatusCode();
        assertEquals(statusExpected, statusCode);
	}
	@Test
	public void testSendMessage() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
		
		consumer.setTokenWithSecret(AccessToken, AccessSecret);
		String userName = "prajaktas29";
		String msg_to_send = "testMsg"+ Math.random();
		HttpPost APIrequest = new HttpPost("https://api.twitter.com/1.1/direct_messages/new.json?screen_name="+userName+"&text="+msg_to_send);
		consumer.sign(APIrequest);
        
        HttpClient client = new DefaultHttpClient();
        HttpResponse APIresponse = client.execute(APIrequest);
        
        int statusCode = APIresponse.getStatusLine().getStatusCode();
        assertEquals(statusExpected, statusCode);
	}
	@Test
	public void testUpdateTweet() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException {
OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
		
		consumer.setTokenWithSecret(AccessToken, AccessSecret);
		String updatedTweet = "testTweet"+ Math.random();
		HttpPost APIrequest = new HttpPost("https://api.twitter.com/1.1/statuses/update.json?status="+updatedTweet);
		consumer.sign(APIrequest);
        
        HttpClient client = new DefaultHttpClient();
        HttpResponse APIresponse = client.execute(APIrequest);
        
        int statusCode = APIresponse.getStatusLine().getStatusCode();
        assertEquals(statusExpected, statusCode);
	}

}		