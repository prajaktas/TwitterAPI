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
 <form:form method="post" modelAttribute="followers">
	<br>
<p align="left"><a href="homePage.html"><img alt="HOME" src="http://www.petsinneed.org/wp-content/uploads/2011/07/352005-1XkaiF1428427980.png">HOME</a></p>	
	<br>
	<div style="font-family: verdana; padding: 10px; border-radius: 10px; font-size: 12px; text-align:center;">
  		<table>
 	<c:forEach var="follower" items="${followers}">
 		<tr>
 			<td width="30%"><img src="<c:url value="${follower.profilePic_Url}"/>" alt="profile picture"/></td>
 			<td>
 					<strong>NAME: </strong><strong>${follower.name}</strong><br>
        			<strong>LOCATION: </strong><strong>${follower.location}</strong><br>
        			<strong>DESCRIPTION: </strong><strong>${follower.description}</strong><br>
        			<strong>SCREEN NAME: </strong><strong>${follower.screen_name}</strong><br>
        			<strong>CREATED DATE: </strong><strong>${follower.created_date}</strong><br>
 		
 			</td>
 		</tr>
 		<tr><td>&nbsp;</td></tr>
 		<tr><td>&nbsp;</td></tr>
 		</c:forEach>
 		 		</table>
 		
		
	</div>
	</form:form>
</body>
</html>