<html>
<body>
<form action="${pageContext.request.contextPath}/testPost" method="POST">
	Test POST: <input type="text" name="test_post"/>
	<input type="submit" value="Submit"/>
</form>
<br/>
<b>Result POST: </b><%= session.getAttribute("someSessionAttrName")%>
</body>
</html>