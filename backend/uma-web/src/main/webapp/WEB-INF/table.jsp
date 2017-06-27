<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
         <h1>USERS</h1>
			<ul>
			<c:forEach items="${users}" var="item">			    
			      <li><c:out value = "${item}"/></li>			    
			</c:forEach>
		</ul>
    </body>
</html>