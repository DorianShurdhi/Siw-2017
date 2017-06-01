<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" href="prova.css">
</head>
<body>
	<section>
		<header>
			<h1>Benvenuti Nel Museo Delle Belle Arti:</h1>
		</header>
		
		<article >
		<div align = "left">
			<h2 align="left"> Inserisci Quadro: </h2>
			<form action="quadro" method="post" style="width: 400px">
				<div>
					Titolo*: <input type="text" name="titolo" value="${quadro.titolo}" />${errTitolo}</div>
				<div>
					Descrizione*: <input type="text" name="descrizione"
						value="${quadro.descrizione}" />${errDescrizione}</div>
				<div>
					Prezzo*: <input type="text" name="prezzo"
						value="${quadro.prezzo}" />${errPrezzo}</div>
				<div>
					Anno Realizzazione*: <input type="text" name="annoRealizzazione"
						value="${quadro.annoRealizzazione}" />${errAnnoRealizzazione}</div>
				<div>* Campo Obbligatorio</div>
				<input type="submit" name="command" value="invia" />

			</form>

			<div>
				<h2 align="left">Vedi Galleria Quadri: </h2>
				<a href="quadro">Lista Quadri</a>
			</div>
			</div>
		</article>
		

	</section>
</body>
</html>