<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.superenalotto.model.Utente" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

	function validaForm(form) {
		if(form.addSaldo.value==""){
			alert("inserire un importo da accreditare");
			return false;
		}
		else{
			return true;
		}
	}

</script>

</head>
<body>
	pagina di aggiornamento del saldo
	
	<form action="NuovaServlet" method="post" onSubmit="return validaForm(this);">
	<input type="hidden" name="controllo" value="6">
	<% Utente ut = (Utente) request.getAttribute("utente");
	out.println("<input type='hidden' name='id_utente' value='"+ut.getId()+"'>"); %>	
	<table width="100%" height="100%" border="1">
		<label>inserire di quanto si vuole aumentare il saldo</label>
		<input type="number" name="addSaldo">
		<input type="submit" value="aggiorna">
	</table>
	</form>
</body>
</html>