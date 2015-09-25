package com.practise.service;

import java.io.IOException;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import com.practise.beans.UserData;

@Service
public class GetTwitterData_API {
	/* application authentication tokens */
	String AccessToken = "3531925812-3JLHgJLVyJOSOvwrtprfvN4wBm2OAiyzQwXoqlp";
	String AccessSecret = "9gS2VjjfB7wFMxIMvdXaBSmPKcvdagh9K98i0ys39CP0e";
	String ConsumerKey = "AxI6LtrInafg185gXG1iYFw9d";
	String ConsumerSecret = "CVwtjVzT1AIEdcZiJOoK403xiPTXTfPD38abEfXEOWQkPVvGE9";
	
	/*Method to retrieve followers details*/
	public String getFollowersDetails() throws ClientProtocolException, IOException, OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ParseException{
		
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
		
		consumer.setTokenWithSecret(AccessToken, AccessSecret);
        HttpGet APIrequest = new HttpGet("https://api.twitter.com/1.1/followers/list.json");
        consumer.sign(APIrequest);
        
        HttpClient client = new DefaultHttpClient();
        HttpResponse APIresponse = client.execute(APIrequest);
        
        int statusCode = APIresponse.getStatusLine().getStatusCode();
        System.out.println(statusCode + ":" + APIresponse.getStatusLine().getReasonPhrase());
        String jsonStr = IOUtils.toString(APIresponse.getEntity().getContent());
        System.out.println("RESPONSE:   "+jsonStr);
        
		return jsonStr;
	}

	/*Method to retrieve friends details*/
	public String getFriendsList() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException {
OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
		
		consumer.setTokenWithSecret(AccessToken, AccessSecret);
        HttpGet APIrequest = new HttpGet("https://api.twitter.com/1.1/friends/list.json");
        consumer.sign(APIrequest);
        
        HttpClient client = new DefaultHttpClient();
        HttpResponse APIresponse = client.execute(APIrequest);
        
        int statusCode = APIresponse.getStatusLine().getStatusCode();
        System.out.println(statusCode + ":" + APIresponse.getStatusLine().getReasonPhrase());
        String jsonStr = IOUtils.toString(APIresponse.getEntity().getContent());
        System.out.println("RESPONSE:   "+jsonStr);
        
		return jsonStr;
	}
	
	/*Method to retrieve user's details*/
	public String getUserData() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
				
				consumer.setTokenWithSecret(AccessToken, AccessSecret);
		        HttpGet APIrequest = new HttpGet("https://api.twitter.com/1.1/users/lookup.json?screen_name=shrutibidnur");
		        consumer.sign(APIrequest);
		        
		        HttpClient client = new DefaultHttpClient();
		        HttpResponse APIresponse = client.execute(APIrequest);
		        
		        int statusCode = APIresponse.getStatusLine().getStatusCode();
		        System.out.println(statusCode + ":" + APIresponse.getStatusLine().getReasonPhrase());
		        String jsonStr = IOUtils.toString(APIresponse.getEntity().getContent());
		        System.out.println("RESPONSE:   "+jsonStr);
		        
				return jsonStr;
		}

	/*Method to retrieve user tweets details*/
	public String getUserTwits() throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
		
		consumer.setTokenWithSecret(AccessToken, AccessSecret);
        HttpGet APIrequest = new HttpGet("https://api.twitter.com/1.1/statuses/mentions_timeline.json");
        consumer.sign(APIrequest);
        
        HttpClient client = new DefaultHttpClient();
        HttpResponse APIresponse = client.execute(APIrequest);
        
        int statusCode = APIresponse.getStatusLine().getStatusCode();
        System.out.println(statusCode + ":" + APIresponse.getStatusLine().getReasonPhrase());
        String jsonStr = IOUtils.toString(APIresponse.getEntity().getContent());
        System.out.println("RESPONSE:   "+jsonStr);
        
		return jsonStr;
	}

	/*Method to search for user and retrieve user's details*/
	public String getViewUserData(String searchName) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
		
		consumer.setTokenWithSecret(AccessToken, AccessSecret);
		HttpGet APIrequest = new HttpGet("https://api.twitter.com/1.1/users/show.json?screen_name="+searchName);
		consumer.sign(APIrequest);
        
        HttpClient client = new DefaultHttpClient();
        HttpResponse APIresponse = client.execute(APIrequest);
        
        int statusCode = APIresponse.getStatusLine().getStatusCode();
        System.out.println(statusCode + ":" + APIresponse.getStatusLine().getReasonPhrase());
        String jsonStr = IOUtils.toString(APIresponse.getEntity().getContent());
        System.out.println("RESPONSE:   "+jsonStr);
        
		
		return jsonStr;
	}

	/*Method to retrieve timeline of user*/
	public String getUserTimeline(String screenName) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
		
		consumer.setTokenWithSecret(AccessToken, AccessSecret);
		HttpGet APIrequest = new HttpGet("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name="+screenName);
		consumer.sign(APIrequest);
        
        HttpClient client = new DefaultHttpClient();
        HttpResponse APIresponse = client.execute(APIrequest);
        
        int statusCode = APIresponse.getStatusLine().getStatusCode();
        System.out.println(statusCode + ":" + APIresponse.getStatusLine().getReasonPhrase());
        String jsonStr = IOUtils.toString(APIresponse.getEntity().getContent());
        System.out.println("RESPONSE:   "+jsonStr);
        
		
		return jsonStr;
	}

	/*Method to tweet*/
	public String updateTweet(String twit) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException {
OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
		
		consumer.setTokenWithSecret(AccessToken, AccessSecret);
		String updatedTweet = replace(twit);
		HttpPost APIrequest = new HttpPost("https://api.twitter.com/1.1/statuses/update.json?status="+updatedTweet);
		consumer.sign(APIrequest);
        
        HttpClient client = new DefaultHttpClient();
        HttpResponse APIresponse = client.execute(APIrequest);
        
        int statusCode = APIresponse.getStatusLine().getStatusCode();
        System.out.println(statusCode + ":" + APIresponse.getStatusLine().getReasonPhrase());
        String jsonStr = IOUtils.toString(APIresponse.getEntity().getContent());
        System.out.println("RESPONSE:   "+jsonStr);
        UserData userData = new UserData();
        if(statusCode == 200){
			userData.setApiStatus("SUCCESS");
		}
        else{
			userData.setApiStatus(APIresponse.getStatusLine().getReasonPhrase());	
		}
		
		return userData.getApiStatus();
	}
	
	/*Method to convert space in a input string with %20 to be sent in url */
	public String replace(String str){ 
		String[] words = str.split(" "); 
		StringBuffer sentence = new StringBuffer(); 
		for(String w: words) { 
			sentence.append("%20"); 
			sentence.append(w); 
			} 
		return sentence.toString(); 
		}

	/*Method to send message to friend*/
	public String sendMessage(UserData userData) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(ConsumerKey, ConsumerSecret);
		
		consumer.setTokenWithSecret(AccessToken, AccessSecret);
		String msg_to_send = replace(userData.getMessage());
		HttpPost APIrequest = new HttpPost("https://api.twitter.com/1.1/direct_messages/new.json?screen_name="+userData.getScreen_name()+"&text="+msg_to_send);
		consumer.sign(APIrequest);
        
        HttpClient client = new DefaultHttpClient();
        HttpResponse APIresponse = client.execute(APIrequest);
        
        int statusCode = APIresponse.getStatusLine().getStatusCode();
        System.out.println(statusCode + ":" + APIresponse.getStatusLine().getReasonPhrase());
        String jsonStr = IOUtils.toString(APIresponse.getEntity().getContent());
        System.out.println("RESPONSE:   "+jsonStr);
        UserData userData1 = new UserData();
        if(statusCode == 200){
			userData1.setApiStatus("SUCCESS");
		}
        else{
			userData1.setApiStatus(APIresponse.getStatusLine().getReasonPhrase());	
		}
		
		return userData1.getApiStatus();
	}

}
