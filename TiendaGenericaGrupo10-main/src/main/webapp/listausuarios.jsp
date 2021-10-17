<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<!-- paquete de caracteres -->
<meta charset="utf-8">
<!-- Tamaño de la pantalla -->
<meta name="viewport" content="width=device-width">
<!-- titulo de la pestaña -->
<title>Lista de usuarios</title>
<!-- bootstrap-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<!-- font awesome -->
<link rel="stylesheet" type="text/css" href="css/style.css">
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@600&display=swap"
	rel="stylesheet">
<script src="https://kit.fontawesome.com/a81368914c.js"></script>

<!-- Cargando mi hoja de estilo -->
<link href="style.css" rel="stylesheet" type="text/css" />


<script>
	var baseurl = "http://localhost:8080/listarusuarios";
	function loadusuarios() {
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.open("GET", baseurl, true);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
				var usuarios = JSON.parse(xmlhttp.responseText);
				var tbltop = "<table class='table table-hover'><tr><th>Cedula</th><th>Email</th><th>Nombre</th><th>Password</th><th>Usuario</th></tr>";
				var main = "";
				for (i = 0; i < usuarios.length; i++) {
					main += "<tr><td>" + usuarios[i].cedula_usuario
							+ "</td><td>" + usuarios[i].email_usuario
							+ "</td><td>" + usuarios[i].nombre_usuario
							+ "</td><td>" + usuarios[i].password + "</td><td>"
							+ usuarios[i].usuario + "</td></tr>";
				}
				var tblbottom = "</table>";
				var tbl = tbltop + main + tblbottom;
				document.getElementById("usuariosinfo").innerHTML = tbl;
			}
		};
		xmlhttp.send();
	}
	window.onload = function() {
		loadusuarios();
	}
</script>

</head>


<body>
	<!-- Navbar-->
	<nav class="navbar navbar-light" style="background-color: #F4FDB1">
		<div class="container-fluid">
			<ul class="nav nav-tabs">
			<li class="nav-item">
			<a class="navbar-brand links" href="index.html"><i class="fas fa-shopping-basket"></i>Tienda Generica</a>
			</li>
			<li class="nav-item">
			<a class="nav-link active" aria-current="page" href="listausuarios.jsp"> <i
				class="fas fa-users"></i> Usuarios
			</a>
			</li>
			<li class="nav-item">
			<a class="nav-link active" aria-current="page" href="listaclientes.jsp"> <i
				class="fas fa-address-book"></i> Clientes
			</a>
			</li>
			<li class="nav-item">
			<a class="nav-link active" aria-current="page" href="listaproveedores.jsp"> <i
				class="fas fa-truck"></i> Proveedores
			</a>
			</li>
			<li class="nav-item">
			<a class="nav-link active" aria-current="page" href="listaproductos.jsp"> <i
				class="fas fa-apple-alt"></i> Productos
			</a>
			</li>
			<li class="nav-item">
			<a class="nav-link active" aria-current="page" href="insertarventa.jsp"> <i
				class="fas fa-money-check-alt"></i> Ventas
			</a>
			</li>
			<li class="nav-item">
			<a class="nav-link active" aria-current="page" href="listareportes.jsp"> <i
				class="fas fa-clipboard-list"></i> Reportes
			</a>
			</li>
			</ul>
		</div>
		

	<!-- Navbar modulos-->
	
	</nav>

	<!-- contenido  -->

	<div id="ponerimagen" style="display: flex;">

		
		<div class="container-fluid">
				<h3>
				Lista de usuarios
				</h3>
				<!--  Aqui es donde se autogenera la tabla basado en el script -->
				<div class="col align-self-center" id="usuariosinfo"></div>
		</div>

		

		<div id="botonesUsuarios" class="container-fluid">
				<div id="imagen"class="container-fluid">
     			<img src="https://cdn-icons-png.flaticon.com/512/306/306232.png" width="80" >
				<button id="btn1" type="button" class="btn btn-success"
					onclick="window.location.href='/insertarusuario.jsp'">
					<i class="fas fa-plus-circle"></i> Agregar usuario
				</button>
				</div>
				
				<button id="btn2" type="button" class="btn btn-danger"
					onclick="window.location.href='/eliminarusuario.jsp'">
					<i class="fas fa-trash"></i> Eliminar usuario
				</button>
				<button id="btn3" type="button" class="btn btn-warning"
					onclick="window.location.href='/actualizarusuario.jsp'">
					<i class="fas fa-pen-alt"></i> Actualizar usuario
				</button>
				<button id="btn4" class="btn btn-primary"
					onclick="window.location.href='/buscarusuario.jsp'">
					<i class="fas fa-search"></i> Buscar un usuario
				</button>
				<button id="btn5" type="button" class="btn btn-primary"
					onclick="window.location.href='/listausuarios.jsp'">
					<i class="fas fa-search"></i> Listar todos los usuarios
				</button>
			
		</div>
	</div>


	
	<nav class="navbar navbar-light" style="background-color: #F4FDB1;">
		<div class="row justify-content-between">
			<div class="col-4">
				<div>			
				<a class="navbar-brand links" href="#"><i class="fas fa-users"></i>Diseñado por Grupo 10</a>
				</div>
			</div>
		</div>
	</nav>


</body>
</html>