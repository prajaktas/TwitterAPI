package com.practise.beans;

import java.util.ArrayList;

public class UserData {
	private String name;
	
	private String location;
	
	private String description;
	
	private String screen_name;
	
	private String followers_count;
	
	private String created_date;
	
	private String profilePic_Url;
	
	private String twit;
	
	private String twittedBy;
	
	private String searchName;
	
	ArrayList<twitDetails> twitData = new ArrayList<twitDetails>();
	
	ArrayList<twitDetails> userTwitData = new ArrayList<twitDetails>();
	
	private String apiStatus;
	
	private String message;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getScreen_name() {
		return screen_name;
	}

	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	public String getFollowers_count() {
		return followers_count;
	}

	public void setFollowers_count(String followers_count) {
		this.followers_count = followers_count;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getProfilePic_Url() {
		return profilePic_Url;
	}

	public void setProfilePic_Url(String profilePic_Url) {
		this.profilePic_Url = profilePic_Url;
	}

	public String getTwit() {
		return twit;
	}

	public void setTwit(String twit) {
		this.twit = twit;
	}

	public String getTwittedBy() {
		return twittedBy;
	}

	public void setTwittedBy(String twittedBy) {
		this.twittedBy = twittedBy;
	}

	public ArrayList<twitDetails> getTwitData() {
		return twitData;
	}

	public void setTwitData(ArrayList<twitDetails> twitData) {
		this.twitData = twitData;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public ArrayList<twitDetails> getUserTwitData() {
		return userTwitData;
	}

	public void setUserTwitData(ArrayList<twitDetails> userTwitData) {
		this.userTwitData = userTwitData;
	}

	public String getApiStatus() {
		return apiStatus;
	}

	public void setApiStatus(String apiStatus) {
		this.apiStatus = apiStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
}
