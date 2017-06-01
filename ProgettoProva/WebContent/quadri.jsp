<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Museo Delle Belle Arti</title>
<link rel="stylesheet" href="prova.css">
</head>
<body>
	<h1>Museo delle Belle Arti:</h1>
	<ul>
		<c:forEach var="quadro" items="${quadro}">
			<li><a href="quadro?id=${quadro.id}">${quadro.name}</a>
				<form action="quadro" method="post">
					<input type="hidden" value="${quadro.id }" name="id"/>
					<input type="button" name="command" value="rimuovi" />
				</form>
			</li>
		</c:forEach>
	</ul>
</body>
</html>