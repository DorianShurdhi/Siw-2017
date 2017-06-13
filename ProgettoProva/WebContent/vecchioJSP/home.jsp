<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="opera.css">
</head>
<body>
	<section>
		<header>
			<h1>Benvenuti Nel Museo Delle Belle Arti:</h1>
		</header>
		
		<article >
		<div align = "left">
			<h2 align="left"> Inserisci Opera: </h2>
			<form action="opera" method="post" style="width: 400px">
				<div>
					Titolo*: <input type="text" name="titolo" value="${opera.titolo}" />${errTitolo}</div>
				<div>
					Descrizione*: <input type="text" name="descrizione"
						value="${opera.descrizione}" />${errDescrizione}</div>
				<div>
					Prezzo*: <input type="text" name="prezzo"
						value="${opera.prezzo}" />${errPrezzo}</div>
				<div>
					Anno Realizzazione*: <input type="text" name="annoRealizzazione"
						value="${opera.annoRealizzazione}" />${errAnnoRealizzazione}</div>
				<div>* Campo Obbligatorio</div>
				<input type="submit" name="command" value="invia" />

			</form>

			<div>
				<h2 align="left">Vedi Galleria Opere: </h2>
				<a href="opere">Lista Opere</a>
			</div>
			</div>
		</article>
		

	</section>
</body>
</html>