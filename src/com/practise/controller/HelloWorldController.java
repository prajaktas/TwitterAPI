package com.practise.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practise.beans.UserData;
import com.practise.beans.twitDetails;
import com.practise.service.GetTwitterData_API;

/*
 * author: E-SPECTRUM
 * 
 */

@Controller
public class HelloWorldController {

	@Autowired
	GetTwitterData_API getTwitterData;

	@RequestMapping("/welcome")
	public String helloWorld(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("userForm") UserData user, BindingResult result, Model model) throws OAuthCommunicationException, ClientProtocolException, IOException, ParseException, OAuthMessageSignerException, OAuthExpectationFailedException {

		String jsonStr = getTwitterData.getFollowersDetails();

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(jsonStr);
		JSONObject jsonObject = (JSONObject) obj;
		JSONObject jsonFollowerDetailsObject = (JSONObject) obj;


		List<UserData> followers = new ArrayList<UserData>();
		JSONArray users = (JSONArray) jsonObject.get("users");
		Iterator<JSONObject> iterator = users.iterator();
		while (iterator.hasNext()) {
			UserData follower = new UserData();
			jsonFollowerDetailsObject = iterator.next();
			follower.setName(jsonFollowerDetailsObject.get("name").toString());
			follower.setLocation(jsonFollowerDetailsObject.get("location").toString());
			follower.setDescription(jsonFollowerDetailsObject.get("description").toString());
			follower.setScreen_name(jsonFollowerDetailsObject.get("screen_name").toString());
			follower.setFollowers_count(jsonFollowerDetailsObject.get("followers_count").toString());
			follower.setCreated_date(jsonFollowerDetailsObject.get("created_at").toString());
			follower.setProfilePic_Url(jsonFollowerDetailsObject.get("profile_image_url").toString());
			System.out.println(follower.getName());
			System.out.println(follower.getProfilePic_Url());
			followers.add(follower);
		}      

		model.addAttribute("followers",followers);
		return "followersPage";
	}

	@RequestMapping("/getFriendsList")
	public String getFriendsList(HttpServletRequest request,
			HttpServletResponse response, @ModelAttribute("userForm") UserData user, BindingResult result, Model model) throws OAuthCommunicationException, ClientProtocolException, IOException, ParseException, OAuthMessageSignerException, OAuthExpectationFailedException {

		String jsonStr = getTwitterData.getFriendsList();

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(jsonStr);
		JSONObject jsonObject = (JSONObject) obj;
		JSONObject jsonFollowerDetailsObject = (JSONObject) obj;


		List<UserData> followers = new ArrayList<UserData>();
		JSONArray users = (JSONArray) jsonObject.get("users");
		Iterator<JSONObject> iterator = users.iterator();
		while (iterator.hasNext()) {
			UserData follower = new UserData();
			jsonFollowerDetailsObject = iterator.next();
			follower.setName(jsonFollowerDetailsObject.get("name").toString());
			follower.setLocation(jsonFollowerDetailsObject.get("location").toString());
			follower.setDescription(jsonFollowerDetailsObject.get("description").toString());
			follower.setScreen_name(jsonFollowerDetailsObject.get("screen_name").toString());
			follower.setFollowers_count(jsonFollowerDetailsObject.get("followers_count").toString());
			follower.setCreated_date(jsonFollowerDetailsObject.get("created_at").toString());
			follower.setProfilePic_Url(jsonFollowerDetailsObject.get("profile_image_url").toString());
			System.out.println(follower.getName());
			System.out.println(follower.getProfilePic_Url());
			followers.add(follower);
		}      

		model.addAttribute("followers",followers);
		return "followersPage";
	}
	@RequestMapping("/getProfileData")
	public String getProfileDetails(HttpServletRequest request,HttpServletResponse response,
			@ModelAttribute("userForm") UserData user, BindingResult result, Model model) 
			throws OAuthCommunicationException, ClientProtocolException, IOException,
			ParseException, OAuthMessageSignerException, OAuthExpectationFailedException {

		String jsonStr = getTwitterData.getUserData();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(jsonStr);
		JSONArray jsonArrayObject = (JSONArray) obj;
		UserData userData = new UserData();
		for (int i =0;i<jsonArrayObject.size() ; i++){
			JSONObject jsonUserDetailsObject = (JSONObject) jsonArrayObject.get(i);
			userData.setName(jsonUserDetailsObject.get("name").toString());
			userData.setLocation(jsonUserDetailsObject.get("location").toString());
			userData.setDescription(jsonUserDetailsObject.get("description").toString());
			userData.setScreen_name(jsonUserDetailsObject.get("screen_name").toString());
			userData.setFollowers_count(jsonUserDetailsObject.get("followers_count").toString());
			userData.setCreated_date(jsonUserDetailsObject.get("created_at").toString());
			userData.setProfilePic_Url(jsonUserDetailsObject.get("profile_image_url").toString());
			System.out.println(userData.getName());
			System.out.println(userData.getProfilePic_Url());

		}
		
		String jsonStr1 = getTwitterData.getUserTwits();
		parser = new JSONParser();
		obj = parser.parse(jsonStr1);
			
		jsonArrayObject = (JSONArray) obj;
		ArrayList<twitDetails> twitDataList = new ArrayList<twitDetails>();
		Iterator<JSONObject> iterator = jsonArrayObject.iterator();
		while (iterator.hasNext()) {
			twitDetails twitData = new twitDetails();
        	JSONObject jsonObject = (JSONObject)iterator.next();
        	twitData.setTwitMsg(jsonObject.get("text").toString());
        	twitData.setTime(jsonObject.get("created_at").toString());  
			JSONObject twitUserData = (JSONObject)jsonObject.get("user");
			twitData.setTwitBy(twitUserData.get("name").toString());
    	   	System.out.println(" by "+twitUserData.get("name"));
    	   	twitDataList.add(twitData);
	
        }
		
		userData.setTwitData(twitDataList);
		String jsonStr2 = getTwitterData.getUserTimeline(userData.getScreen_name());
		parser = new JSONParser();
		obj = parser.parse(jsonStr2);
			
		jsonArrayObject = (JSONArray) obj;
		ArrayList<twitDetails> twitList = new ArrayList<twitDetails>();
		Iterator<JSONObject> twitIterator = jsonArrayObject.iterator();
		while (twitIterator.hasNext()) {
			twitDetails twitData = new twitDetails();
        	JSONObject jsonObject = (JSONObject)twitIterator.next();
        	twitData.setTwitMsg(jsonObject.get("text").toString());
        	twitData.setTime(jsonObject.get("created_at").toString());  			
        	twitList.add(twitData);
        }
		
		userData.setUserTwitData(twitList);
		model.addAttribute("userData",userData);
		return "userDetails";
	}
	
	
	@RequestMapping(value="/viewUser", method=RequestMethod.POST, params="submit=SEARCH")
	public String viewUserDetails(@ModelAttribute("userData")
    UserData userData, BindingResult result, Model model) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException, ParseException{
		System.out.println(userData.getSearchName());
		
		String jsonStr = getTwitterData.getViewUserData(userData.getSearchName());
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(jsonStr);
		
		JSONArray jsonArrayObject = new JSONArray();
		jsonArrayObject.add(obj);
		UserData RequestedUserData = new UserData();
		for (int i =0;i<jsonArrayObject.size() ; i++){
			JSONObject jsonUserDetailsObject = (JSONObject) jsonArrayObject.get(i);
			RequestedUserData.setName(jsonUserDetailsObject.get("name").toString());
			RequestedUserData.setLocation(jsonUserDetailsObject.get("location").toString());
			RequestedUserData.setDescription(jsonUserDetailsObject.get("description").toString());
			RequestedUserData.setScreen_name(jsonUserDetailsObject.get("screen_name").toString());
			RequestedUserData.setFollowers_count(jsonUserDetailsObject.get("followers_count").toString());
			RequestedUserData.setCreated_date(jsonUserDetailsObject.get("created_at").toString());
			RequestedUserData.setProfilePic_Url(jsonUserDetailsObject.get("profile_image_url").toString());
			System.out.println(RequestedUserData.getName());
			System.out.println(RequestedUserData.getProfilePic_Url());

		}
		
		String jsonStr2 = getTwitterData.getUserTimeline(RequestedUserData.getScreen_name());
		parser = new JSONParser();
		obj = parser.parse(jsonStr2);
			
		jsonArrayObject = (JSONArray) obj;
		ArrayList<twitDetails> twitList = new ArrayList<twitDetails>();
		Iterator<JSONObject> twitIterator = jsonArrayObject.iterator();
		while (twitIterator.hasNext()) {
			twitDetails twitData = new twitDetails();
        	JSONObject jsonObject = (JSONObject)twitIterator.next();
        	twitData.setTwitMsg(jsonObject.get("text").toString());
        	twitData.setTime(jsonObject.get("created_at").toString());  
			
        	twitList.add(twitData);
	
        }
		
		RequestedUserData.setUserTwitData(twitList);
		
		model.addAttribute("userData",RequestedUserData);
		return "userDetails";
		
	}

	@RequestMapping("/homePage")
	public String getHomePage(){
		return "redirect:/getProfileData.html";

	}
	
	@RequestMapping(value="/viewUser", method=RequestMethod.POST, params="submit=TWEET")
	public String updateTweet(@ModelAttribute("userData")
    UserData userData, BindingResult result, Model model) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException, ParseException{
		System.out.println(userData.getTwit());
		
		String updateTweetStatus = getTwitterData.updateTweet(userData.getTwit());
		
		userData.setApiStatus(updateTweetStatus);
		
		model.addAttribute("userData", userData);
		return "showStatusPage";
		
	}
	
	@RequestMapping(value="/viewMessagePage")
	public String viewMessagePage(@ModelAttribute("userData")
    UserData userData, BindingResult result, Model model) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException, ParseException{
		
		return "sendMessagePage";
		
	}
	
	@RequestMapping(value="/sendMessage")
	public String sendMessage(@ModelAttribute("userData")
    UserData userData, BindingResult result, Model model) throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException, ClientProtocolException, IOException, ParseException{
		System.out.println(userData.getMessage());
		System.out.println(userData.getScreen_name());
		
		String updateTweetStatus = getTwitterData.sendMessage(userData);
		userData.setApiStatus(updateTweetStatus);
		
		model.addAttribute("userData", userData);

		
		return "showStatusPage";
		
	}
	
}

