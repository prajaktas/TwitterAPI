<html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>Twitter Application</title>
<style type="text/css">
body {
	background-image: url('http://image.tianjimedia.com/uploadImages/2013/072/43U4S56378BI.png');
}
</style>
</head>


<body>

 <form:form method="post" modelAttribute="userData" action="viewUser.html">
 	<p align="right">Search User: <form:input path="searchName" /> <INPUT TYPE="SUBMIT" NAME="submit" VALUE="SEARCH"></p>
	<br>
	<p align="left"><a href="homePage.html"><img alt="HOME" src="http://www.petsinneed.org/wp-content/uploads/2011/07/352005-1XkaiF1428427980.png">HOME</a></p>
	<br>
	<p align="left"><strong>Wel-Come <c:out value="${userData.name}"/> </strong></p>
	<div align="left">
	<form:textarea path="twit" rows="4" cols="50" placeholder="Please Enter Your Tweet"/><br>
	<input align="right" type="submit" id="TweetID" name="submit" value="TWEET" />
	</div>
	<div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align:center;">
	<br>
	<br>
	
	<table width="100%" border="1">
	<tr>
		<td width="35%"><a href="welcome.html">Followers List</a></td>
		<td width="35%"><a href="getFriendsList.html">Friends List</a></td>
		<td width="30%"><a href="viewMessagePage.html">Send Message</a></td>
	</tr>
	</table>
  		<table>
 		<tr>
 			<td width="30%"><img src="<c:url value="${userData.profilePic_Url}"/>" alt="profile picture"/></td>
 			<td>
 					<strong>NAME: </strong><strong>${userData.name}</strong><br>
        			<strong>LOCATION: </strong><strong>${userData.location}</strong><br>
        			<strong>DESCRIPTION: </strong><strong>${userData.description}</strong><br>
        			<strong>SCREEN NAME: </strong><strong>${userData.screen_name}</strong><br>
        			<strong>CREATED DATE: </strong><strong>${userData.created_date}</strong><br>
 		
 			</td>
 		</tr>
 		<tr><td>&nbsp;</td></tr>
 		<tr><td>&nbsp;</td></tr>
 		 		</table>
 		<br><br>
 		
 		<h2><c:out value="${userData.name}"/>'s Tweets</h2>
 		<table width="100%">
 			<tr>
 				<td width="60%"><b>MESSAGE</b></td>
 				<td width="40%"><b>TIME</b></td>
 			</tr>
 			<c:forEach var="userTwitData" items="${userData.userTwitData}">
 			<tr>
 			<td width="40%">
 				${userTwitData.twitMsg}
 			</td>
 			<td width="40%">
 				${userTwitData.time}
 			</td>
 			</tr>
 		
 			</c:forEach>
 		</table>
 		<br><br>
 		
 		<h2>Tweets that mention you</h2>
 		<table width="100%">
 			<tr>
 				<td width="40%"><b>MESSAGE</b></td>
 				<td width="20%"><b>TWITTED BY</b></td>
 				<td width="40%"><b>TIME</b></td>
 			</tr>
 			<c:forEach var="twitData" items="${userData.twitData}">
 			<tr>
 			<td width="40%">
 				${twitData.twitMsg}
 			</td>
 			<td width="20%">
 				${twitData.twitBy}
 			</td>
 			<td width="40%">
 				${twitData.time}
 			</td>
 			</tr>
 		
 			</c:forEach>
 		</table>
	</div>
	</form:form>
</body>
</html>