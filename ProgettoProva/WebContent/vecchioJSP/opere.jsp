<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Museo Delle Belle Arti</title>
<link rel="stylesheet" href="opere.css">
</head>
<body>
	<h1>Museo delle Belle Arti:</h1>
	<ul>
		<c:forEach var="opera" items="${opera}">
			<li><a href="opera?id=${quadro.id}">${opera.titolo}</a>
				<form action="opera" method="POST">
					<input type="hidden" value="${opera.id }" name="id"/>
					<input type="button" name="command" value="rimuovi" />
				</form>
			</li>
		</c:forEach>
	</ul>
</body>
</html>