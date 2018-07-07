<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello Admin!  
</h1>

<P>  Admin  Hello <b><c:out value="${pageContext.request.remoteUser}"/></b></P>
</body>
</html>
