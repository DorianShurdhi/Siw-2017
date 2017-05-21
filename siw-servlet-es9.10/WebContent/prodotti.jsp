<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="prova1.css" />
<title>Lista Prodotti</title>
</head>
<body>
	<ul>
		<c:forEach var="prodotto" items="${prodotti}">
			<li><a href="prodotto?id=${prodotto.id}">
					${prodotto.nome},${prodotto.prezzo} </a> 
						<form action = "prodotto" method = "post" >
						<input type = "hidden" vale = "${prodotto.id}" name = "id" />
						<input type = "button" value = "cancella" />
					</li>
		</c:forEach>
	</ul>
</body>
</html>