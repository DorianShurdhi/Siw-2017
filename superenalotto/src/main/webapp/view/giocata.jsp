<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css">

<title>Insert title here</title>
</head>
<body>
	numeri giocati:
	<%  String n_gioc = (String) request.getAttribute("n_giocati");
		out.println(n_gioc+"<br><br>"); %>
		
	numeri estratti:
	<%  String n_estr = (String) request.getAttribute("n_estratti");
		out.println(n_estr);
	%>
	
	 <form action="NuovaServlet" method="post">
             <input type="hidden" name="id" value="<%  String id = (String) request.getAttribute("id");
             out.print(id);%>" />
			 <input type="hidden" name="user" value="<%  String user = (String) request.getAttribute("user");
				 out.print(user); %>" />
			 <input type="hidden" name="pass" value="<%  String pass = (String) request.getAttribute("pass");
				 out.print(pass); %>" />
             <input type="hidden" name="controllo" value="5">
             <input type="submit" value="gioca ancora" />
 			</form>
           </fieldset>
    </form>
</body>
</html>