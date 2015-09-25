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
<form:form method="post" modelAttribute="userData" >
	<br>
<p align="left"><a href="homePage.html"><img alt="HOME" src="http://www.petsinneed.org/wp-content/uploads/2011/07/352005-1XkaiF1428427980.png">HOME</a></p>
<h2>

<c:out value="${userData.apiStatus}"/>

</h2>	
	</form:form>
</body>
</html>