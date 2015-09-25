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
<form:form method="post" modelAttribute="userData" action="sendMessage.html">
<br>
<p align="left"><a href="homePage.html"><img alt="HOME" src="http://www.petsinneed.org/wp-content/uploads/2011/07/352005-1XkaiF1428427980.png">HOME</a></p>
<h2>Send Message</h2>
<table align="center">
<tr>
<td>TO: </td>
<td><form:textarea path="screen_name" rows="1" cols="70" placeholder="Enter Recepients Screen Name"/></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td></tr>
<tr>
<td>Message: </td>
<td><form:textarea path="message" rows="6" cols="70" placeholder="Please Enter Your Message"/></td>
</tr>
<tr><td>&nbsp;</td></tr>
<tr><td>&nbsp;</td></tr>
<tr>
<td colspan="2"><INPUT TYPE="SUBMIT" NAME="submit" VALUE="SEND MESSAGE" width="40%"></td>
</tr>


</table>

	</form:form>
</body>
</html>