<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="prova.css" />
<title>Nuovo prodotto</title>
</head>
<body>
	<hr>
	<h1>/NegozioProdotti(siw-servlet-es9)</h1>
	<hr>
	<form action="controllerDati" method="get">
		<div align="center">
			<table>
				<tr>
					<td align="right">Nome:</td>
					<td><input type="text" name="nome" size="20"
						autofocus="autofocus" value="${nome}" /></td>
					<td>${errNome}</td>
				</tr>
				<tr>
					<td align="right">Descrizione:</td>
					<td><input type="text" name="descrizione" size="20"
						value="${descrizione}" /></td>
					<td>${errDescrizione}</td>
				</tr>
				<tr>
					<td align="right">Prezzo:</td>
					<td><input type="text" name="prezzo" size="6" maxlength="6"
						pattern=".{6,}" placeholder="*****" value="${prezzo}" /></td>
					<td>${errPrezzo}</td>
				</tr>
				<tr>
					<td align="right">Data:</td>
					<td><input type="date" name="dataScadenza" size="20"
						value="${dataScadenza}" /></td>
					<td>${errData}</td>
				</tr>
			</table>
			<input type="submit" value="INVIA" />
		</div>
	</form>
</body>
</html>