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
<title>Modulo reportes</title>
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
	
	
	<!-- contenido  -->
	
	<div style="padding-left: 5px;">
	
		<h1><i class="fas fa-list-ol"></i> Modulo de Reportes</h1>
			<div class="container">
			
			<br>			
					<button type="button" class="btn btn-primary" onclick="reporte_lista_usuarios()">
						<i class="fas fa-search"></i> Lista de usuarios
					</button>
			<br>
			<br>		
					<div class="row">
						<!--  Aqui es donde se autogenera la tabla basado en el script -->
						<div class="col align-self-center" id="usuarios_info">					
						</div>
					</div>			
			<br>			
					<button type="button" class="btn btn-primary" onclick="reporte_lista_clientes()">
						<i class="fas fa-search"></i> Lista de Clientes
					</button>
			<br>
			<br>						
					<div class="row">
						<!--  Aqui es donde se autogenera la tabla basado en el script -->
						<div class="col align-self-center" id="clientes_info">					
						</div>
					</div>					
			<br>
			
					<button type="button" class="btn btn-primary" onclick="reporte_ventas_cliente()">
						<i class="fas fa-search"></i> Ventas Por Cliente
					</button>
			<br>
			<br>
					<div class="row">
						<!--  Aqui es donde se autogenera la tabla basado en el script -->
						<div class="col align-self-center" id="venta_clientes_info">					
						</div>
					</div>
					
					<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">Nombre Cliente</span> 
					<input type="text" class="form-control"	placeholder="Nombre Cliente..."
						aria-describedby="basic-addon1" required id="nombre_cliente">
					<input type="text" class="form-control"	placeholder="Total Compra Cliente..."
					aria-describedby="basic-addon1" required id="total_cliente">					
				
					
	
				</div>
			</div>
	


	<nav class="navbar fixed-bottom navbar-dark bg-dark">
		<div class="row justify-content-between">
			<div class="col-4">
				<a class="navbar-brand links" href="#"><i class="fas fa-code"></i>
					Diseñado por Grupo 10 <i
					class="fas fa-code-branch"></i></a>
			</div>
		</div>
	</nav>


<script>



function reporte_lista_usuarios() {
	var baseurl = "http://localhost:8080/listarusuarios";
	var xmlhttp = new XMLHttpRequest();
	xmlhttp.open("GET", baseurl, true);
	xmlhttp.onreadystatechange = function() {
		if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
			var usuarios = JSON.parse(xmlhttp.responseText);
			var tbltop = "<table class='table table-dark table-striped'><tr><th>Cedula</th><th>Email</th><th>Nombre</th><th>Password</th><th>Usuario</th></tr>";
			var main = "";
			for (i = 0; i < usuarios.length; i++) {
				main += "<tr><td>" + usuarios[i].cedula_usuario
						+ "</td><td>" + usuarios[i].email_usuario
						+ "</td><td>" + usuarios[i].nombre_usuario
						+ "</td><td>" + usuarios[i].password + "</td><td>"
						+ usuarios[i].usuario + "</td></tr>";
			}//fin for
			var tblbottom = "</table>";
			var tbl = tbltop + main + tblbottom;
			document.getElementById("usuarios_info").innerHTML = tbl;
		}//fin if
	}; //fin xml onreadystatechange
	xmlhttp.send();
	}//fin funcion cargar usuarios

	
	function reporte_lista_clientes() {
		var baseurlc = "http://localhost:8080/listarclientes";
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.open("GET", baseurlc, true);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
				var clientes = JSON.parse(xmlhttp.responseText);
				var tbltop = "<table class='table table-dark table-striped'><tr><th>Cedula Cliente</th><th>Direccion Cliente</th><th>Email Cliente</th><th>Nombre Cliente</th><th>Telefono Cliente</th></tr>";
				var main = "";
				for (i = 0; i < clientes.length; i++) {
					main += "<tr><td>" + clientes[i].cedula_cliente
							+ "</td><td>" + clientes[i].direccion_cliente
							+ "</td><td>" + clientes[i].email_cliente
							+ "</td><td>" + clientes[i].nombre_cliente + "</td><td>"
							+ clientes[i].telefono_cliente + "</td></tr>";
				}
				var tblbottom = "</table>";
				var tbl = tbltop + main + tblbottom;
				document.getElementById("clientes_info").innerHTML = tbl;
			}//fin if
		};//fin xml onreadystatechange
		xmlhttp.send();
	}//fin funcion cargar clientes
	
	
	function reporte_ventas_cliente() {
		
		window.alert("inserte la cedula del cliente a mostrar");
		
		var baseurl = "http://localhost:8080/listarventas";
		var xmlhttp = new XMLHttpRequest();
		xmlhttp.open("GET", baseurl, true);
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.status === 200) {
				var ventas = JSON.parse(xmlhttp.responseText);
				var tbltop = "<table class='table table-dark table-striped'><tr><th>Cedula Cliente</th><th>Nombre Cliente</th><th>Codigo Venta</th><th>Valor Total Venta</th></tr>";
				var main = "";
				for (i = 0; i < ventas.length; i++) {
					var cliente = null;
					var xmlhttp2 = new XMLHttpRequest();
					xmlhttp2.open("GET", "http://localhost:8080/consultarclientes?cedula_cliente=" + ventas[i].cedula_cliente, false);
					xmlhttp2.send(null);
					if (xmlhttp2.status == 200){
						cliente = JSON.parse(xmlhttp2.responseText);
					}
					main += "<tr><td>" + ventas[i].cedula_cliente
							+ "</td><td>" + cliente[0].nombre_cliente
							+ "</td><td>" + ventas[i].codigo_venta
							+ "</td><td>" + ventas[i].valor_venta + "</td></tr>";
				}
				var tblbottom = "</table>";
				var tbl = tbltop + main + tblbottom;
				document.getElementById("venta_clientes_info").innerHTML = tbl;
			}//fin if
		};//fin xml onreadystatechange
		xmlhttp.send();
	}//fin funcion cargar clientes
	
</script>
</body>
</html>