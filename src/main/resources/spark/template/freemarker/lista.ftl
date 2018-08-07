<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spotify</title>
</head>

<body>
	<#list disco as discos>
		<div> 
			<h4>
				<a href="/ver-discos/${discos.nombre}">
					${discos.artista}
				</a>
			</h4>
		</div>
	</#list>
	<a href="/agregar-discos"> Agregar nuevo disco </a>
</body>

</html>