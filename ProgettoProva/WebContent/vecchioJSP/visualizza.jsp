<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="it.uniroma3.siw.progetto.model.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Visualizzazione Opere</title>
</head>
<body>
<h1>Opere</h1>
	<% FacadeOpera f = new FacadeOpera();
	ArrayList<Opera> lista = f.tutteOpere(); 
	Iterator<Opera> i = lista.iterator();
	while(i.hasNext()){
		Opera o = i.next();
		o.toHTML();
	}
%>
<p>In questo caso non ci saranno mai delle opere in quanto non c'è una connessione con un database
e la facade viene creata al momento</p>
</body>
</html>