<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mostra Dati</title>
</head>
<link rel="stylesheet" href="prova1.css" />
<body>
<p>Hai inserito: Nome:    <%out.print(request.getParameter("nome")); %>
				 Cognome: <%out.print(request.getParameter("cognome")); %>
</body>
</html>