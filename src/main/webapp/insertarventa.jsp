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
<title>Crear Venta</title>
<!-- bootstrap-->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<!-- font awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">

<!-- Cargando mi hoja de estilo -->
<link href="style.css" rel="stylesheet" type="text/css" />

<script>
	window.onload = function() {
		var req = new XMLHttpRequest();
		req.open('GET', 'http://localhost:8080/contarventa', false);
		req.send(null);
		var contador = null;
		if (req.status == 200)
			contador = JSON.parse(req.responseText);
		console.log(contador.toString());
		document.getElementById("cons_venta").value = contador + 1;
	}
</script>


</head>


<body>
	<!-- Navbar-->
	<nav class="navbar navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand links" href="index.html"><i
				class="fas fa-fish"></i>Tienda Generica</a>
		</div>
	</nav>

	<!-- Navbar modulos-->
	<nav class="navbar navbar-dark bg-primary">
		<div class="container">
			<a class="navbar-brand links" href="listausuarios.jsp"> <i
				class="fas fa-users"></i> Usuarios
			</a> <a class="navbar-brand links" href="listaclientes.jsp"> <i
				class="fas fa-address-book"></i> Clientes
			</a> <a class="navbar-brand links" href="listaproveedores.jsp"> <i
				class="fas fa-truck"></i> Proveedores
			</a> <a class="navbar-brand links" href="listaproductos.jsp"> <i
				class="fas fa-apple-alt"></i> Productos
			</a> <a class="navbar-brand links" href="insertarventa.jsp"> <i
				class="fas fa-money-check-alt"></i> Ventas
			</a> <a class="navbar-brand links" href="listareportes.jsp"> <i
				class="fas fa-clipboard-list"></i> Reportes
			</a>
		</div>
	</nav>

	<div style="padding-left: 5px">
		<h1>
			<i class="fas fa-plus-circle"></i> Datos de la venta
		</h1>
		<div class="container">



			<form id="form1">
				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">Cedula
						Cliente</span> <input type="text" class="form-control"
						placeholder="Inserte cedula cliente aqui..."
						aria-describedby="basic-addon1" required id="cedula_cliente">
					<button type="button" class="btn btn-success"
						onclick="buscar_cliente_venta()">
						<i class="fas fa-check"></i> Consultar
					</button>
					<span class="input-group-text" id="basic-addon1">Cliente </span> <input
						type="text" class="form-control" placeholder="Nombre cliente..."
						aria-describedby="basic-addon1" required id="nombre_cliente"
						disabled="disabled">
				</div>

				<div class="input-group mb-3">
					<span class="input-group-text" id="basic-addon1">Cedula
						Usuario</span> <input type="text" class="form-control"
						placeholder="Inserte cedula usuario aqui..."
						aria-describedby="basic-addon1" required id="cedula_usuario">
					<button type="button" class="btn btn-success"
						onclick="buscar_usuario_venta()">
						<i class="fas fa-check"></i> Consultar
					</button>
					<span class="input-group-text" id="basic-addon1">Usuario </span> <input
						type="text" class="form-control" placeholder="Nombre usuario..."
						aria-describedby="basic-addon1" required id="nombre_usuario"
						disabled="disabled"> <span class="input-group-text"
						id="basic-addon1">Consecutivo Venta </span> <input type="text"
						class="form-control" aria-describedby="basic-addon1" required
						id="cons_venta" disabled="disabled">

				</div>

				<div class="container">
					<div class="row">
						<div class="col">Codigo producto</div>
						<div class="col"></div>
						<div class="col">Nombre producto</div>
						<div class="col">Cantidad</div>
						<div class="col">Valor total</div>
					</div>

					<div class="row">
						<div class="col">
							<input type="text" class="form-control" placeholder="Producto  1"
								aria-describedby="basic-addon1" required id="cod_prod1">
						</div>

						<div class="col">
							<button type="button" class="btn btn-success"
								onclick="buscar_producto1_venta()">
								<i class="fas fa-check"></i> Consultar
							</button>
						</div>

						<div class="col">
							<input type="text" class="form-control"
								placeholder="Nombre producto 1" aria-describedby="basic-addon1"
								required id="nom_prod1">
						</div>

						<div class="col">
							<input type="text" class="form-control" placeholder="Cantidad p1"
								aria-describedby="basic-addon1" required id="cant_1">
						</div>

						<div class="col">
							<input type="text" class="form-control"
								placeholder="Valor Total 1" aria-describedby="basic-addon1"
								required id="valort_1" value="0">
						</div>
					</div>

					<div class="row">
						<div class="col">
							<input type="text" class="form-control" placeholder="Producto  2"
								aria-describedby="basic-addon1" required id="cod_prod2">
						</div>

						<div class="col">
							<button type="button" class="btn btn-success"
								onclick="buscar_producto2_venta()">
								<i class="fas fa-check"></i> Consultar
							</button>
						</div>

						<div class="col">
							<input type="text" class="form-control"
								placeholder="Nombre producto 2 " aria-describedby="basic-addon1"
								required id="nom_prod2">
						</div>

						<div class="col">
							<input type="text" class="form-control" placeholder="Cantidad p2"
								aria-describedby="basic-addon1" required id="cant_2">
						</div>

						<div class="col">
							<input type="text" class="form-control"
								placeholder="Valor Total 2" aria-describedby="basic-addon1"
								required id="valort_2" value="0">
						</div>
					</div>

					<div class="row">
						<div class="col">
							<input type="text" class="form-control" placeholder="Producto  3"
								aria-describedby="basic-addon1" required id="cod_prod3">
						</div>

						<div class="col">
							<button type="button" class="btn btn-success"
								onclick="buscar_producto3_venta()">
								<i class="fas fa-check"></i> Consultar
							</button>
						</div>

						<div class="col">
							<input type="text" class="form-control"
								placeholder="Nombre producto 3" aria-describedby="basic-addon1"
								required id="nom_prod3">
						</div>

						<div class="col">
							<input type="text" class="form-control" placeholder="Cantidad p3"
								aria-describedby="basic-addon1" required id="cant_3">
						</div>

						<div class="col">
							<input type="text" class="form-control"
								placeholder="Valor Total t3" aria-describedby="basic-addon1"
								required id="valort_3" value="0">
						</div>
					</div>

					<div class="row">

						<div class="col">x</div>
						<div class="col">x</div>
						<div class="col">x</div>
						<div class="col">Total Venta</div>
						<div class="col">
							<input type="text" class="form-control" placeholder="Total venta"
								aria-describedby="basic-addon1" required id="total_venta" disabled="disabled">
						</div>

						<div class="row">
							<div class="col">x</div>
							<div class="col">x</div>
							<div class="col">x</div>
							<div class="col">Total Iva</div>
							<div class="col">
								<input type="text" class="form-control"
									placeholder="Total Iva" aria-describedby="basic-addon1"
									required id="total_iva" disabled="disabled">
							</div>

							<div class="row">
								<div class="col">x</div>
								<div class="col">x</div>
								<div class="col">
									<button type="button" class="btn btn-success"
										onclick="enviar_venta()">
										<i class="fas fa-check"></i>Calcular
									</button>
									<button id="boton1" type="button" class="btn btn-success"
										onclick="registrar_venta()">
										<i class="fas fa-check"></i>Registrar
									</button>
								</div>
								<div class="col">Total Con IVA</div>
								<div class="col">
									<input type="text" class="form-control"
										placeholder="Total Con IVA" aria-describedby="basic-addon1"
										required id="total_coniva" disabled="disabled">
								</div>
							</div>

						</div>


					</div>
				</div>




			</form>



		</div>

	</div>
	<nav class="navbar fixed-bottom navbar-dark bg-dark">
		<div class="row justify-content-between">
			<div class="col-4">
				<a class="navbar-brand links" href="#"><i class="fas fa-code"></i>
					Diseñado por Grupo 10 <i class="fas fa-code-branch"></i></a>
			</div>
		</div>
	</nav>
	<script>
		function buscar_cliente_venta() {

			var req = new XMLHttpRequest();
			var user = document.getElementById("cedula_cliente").value;
			req.open('GET',	'http://localhost:8080/consultarclientes?cedula_cliente='+ user, false);
			req.send(null);
			var cliente = null;
			if (req.status == 200)
				cliente = JSON.parse(req.responseText);

			if (cliente.toString() != "") {
				window.alert("Encontre el cliente con cedula " + user);
				document.getElementById("nombre_cliente").value = cliente[0].nombre_cliente;
			} else {
				window.alert("No Encontre el cliente con cedula " + user);
				document.getElementById("cedula_cliente").value = "";
			}
		}//fin funcion

		function buscar_usuario_venta() {

			var req = new XMLHttpRequest();
			var user = document.getElementById("cedula_usuario").value;
			req.open('GET',
					'http://localhost:8080/consultarusuariocedula?cedula='
							+ user, false);
			req.send(null);
			var usuario = null;
			if (req.status == 200)
				usuario = JSON.parse(req.responseText);

			if (usuario.toString() != "") {
				window.alert("Encontre el usuario con cedula " + user);
				document.getElementById("nombre_usuario").value = usuario[0].nombre_usuario;
			} else {
				window.alert("No Encontre el usuario con cedula " + user);
				document.getElementById("cedula_usuario").value = "";
			}
		}//fin funcion

		function buscar_producto1_venta() {

			var req = new XMLHttpRequest();
			var user = document.getElementById("cod_prod1").value;
			req
					.open('GET',
							'http://localhost:8080/consultarproductos?producto='
									+ user, false);
			req.send(null);
			var usuario = null;
			if (req.status == 200)
				usuario = JSON.parse(req.responseText);

			if (usuario.toString() != "") {
				window.alert("Encontre el producto con codigo " + user);
				document.getElementById("nom_prod1").value = usuario[0].nombre_producto;
			} else {
				window.alert("No Encontre el producto con codigo " + user);
				document.getElementById("cod_prod1").value = "";
			}
		}//fin funcion

		function buscar_producto2_venta() {

			var req = new XMLHttpRequest();
			var user = document.getElementById("cod_prod2").value;
			req
					.open('GET',
							'http://localhost:8080/consultarproductos?producto='
									+ user, false);
			req.send(null);
			var usuario = null;
			if (req.status == 200)
				usuario = JSON.parse(req.responseText);

			if (usuario.toString() != "") {
				window.alert("Encontre el producto con codigo " + user);
				document.getElementById("nom_prod2").value = usuario[0].nombre_producto;
			} else {
				window.alert("No Encontre el producto con codigo " + user);
				document.getElementById("cod_prod2").value = "";
			}
		}//fin funcion

		function buscar_producto3_venta() {

			var req = new XMLHttpRequest();
			var user = document.getElementById("cod_prod3").value;
			req
					.open('GET',
							'http://localhost:8080/consultarproductos?producto='
									+ user, false);
			req.send(null);
			var usuario = null;
			if (req.status == 200)
				usuario = JSON.parse(req.responseText);

			if (usuario.toString() != "") {
				window.alert("Encontre el producto con codigo " + user);
				document.getElementById("nom_prod3").value = usuario[0].nombre_producto;
			} else {
				window.alert("No Encontre el producto con codigo " + user);
				document.getElementById("cod_prod3").value = "";
			}
		}//fin funcion

		var canti1 = document.getElementById("cant_1");
		canti1.addEventListener("keyup", function(event) {
			if (event.keyCode == 13) {
				calculo_precio1();
			}
		});

		function calculo_precio1() {
			window.alert("Calculando precio producto 1");
			var req = new XMLHttpRequest();
			var coincidencia = false;
			var dato = document.getElementById("cod_prod1").value;
			var vcanti1 = document.getElementById("cant_1").value;
			req
					.open('GET',
							'http://localhost:8080/consultarproductos?producto='
									+ dato, false);
			req.send(null);
			var producto1 = null;
			if (req.status == 200)
				producto1 = JSON.parse(req.responseText);

			if (producto1.toString() != "") {
				window.alert("Calculando precio de " + vcanti1 + " "
						+ producto1[0].nombre_producto);
				document.getElementById("valort_1").value = producto1[0].precio_venta
						* vcanti1;

			} else {
				window.alert("No Encontre el precio de "
						+ producto1[0].nombre_producto);
			}
		}//fin funcion

		var canti2 = document.getElementById("cant_2");
		canti2.addEventListener("keyup", function(event) {
			if (event.keyCode == 13) {
				calculo_precio2();
			}
		});

		function calculo_precio2() {
			window.alert("Calculando precio producto 2");
			var req = new XMLHttpRequest();
			var coincidencia = false;
			var dato = document.getElementById("cod_prod2").value;
			var vcanti2 = document.getElementById("cant_2").value;
			req
					.open('GET',
							'http://localhost:8080/consultarproductos?producto='
									+ dato, false);
			req.send(null);
			var producto2 = null;
			if (req.status == 200)
				producto2 = JSON.parse(req.responseText);

			if (producto2.toString() != "") {
				window.alert("Calculando el precio de " + vcanti2 + " "
						+ producto2[0].nombre_producto);
				document.getElementById("valort_2").value = producto2[0].precio_venta
						* vcanti2;

			} else {
				window.alert("No Encontre el precio de "
						+ producto2[0].nombre_producto);
			}
		}//fin funcion

		var canti3 = document.getElementById("cant_3");
		canti3.addEventListener("keyup", function(event) {
			if (event.keyCode == 13) {
				calculo_precio3();
			}
		});

		function calculo_precio3() {
			window.alert("Calculando precio producto 3");
			var req = new XMLHttpRequest();
			var coincidencia = false;
			var dato = document.getElementById("cod_prod3").value;
			var vcanti3 = document.getElementById("cant_3").value;
			req
					.open('GET',
							'http://localhost:8080/consultarproductos?producto='
									+ dato, false);
			req.send(null);
			var producto3 = null;
			if (req.status == 200)
				producto3 = JSON.parse(req.responseText);

			if (producto3.toString() != "") {
				window.alert("Calculando el precio de " + vcanti3 + " "
						+ producto3[0].nombre_producto);
				document.getElementById("valort_3").value = producto3[0].precio_venta
						* vcanti3;
			} else {
				window.alert("No Encontre el precio de "
						+ producto3[0].nombre_producto);
			}
		}//fin funcion

		function enviar_venta() {

			window.alert("calculando venta, iva, y total con iva ");

			var venta1 = parseInt(document.getElementById("valort_1").value);
			var venta2 = parseInt(document.getElementById("valort_2").value);
			var venta3 = parseInt(document.getElementById("valort_3").value);
			var totalventa = venta1 + venta2 + venta3;
			var totaliva = totalventa * 0.19
			var totalconiva = totalventa + totaliva;

			document.getElementById("total_venta").value = totalventa;
			document.getElementById("total_iva").value = totaliva;
			document.getElementById("total_coniva").value = totalconiva;

			
		}
		
		function registrar_venta(){
			var formDataVenta = new FormData();
			formDataVenta.append("codigo_venta", document.getElementById("cons_venta").value);
			formDataVenta.append("cedula_cliente", document.getElementById("cedula_cliente").value);
			formDataVenta.append("cedula_usuario", document.getElementById("cedula_usuario").value);
			formDataVenta.append("iva_venta", document.getElementById("total_iva").value);
			formDataVenta.append("total_venta", document.getElementById("total_venta").value);
			formDataVenta.append("valor_venta", document.getElementById("total_coniva").value);
			var xhr = new XMLHttpRequest();

			xhr.open("POST", 'http://localhost:8080/registrarventa');
			xhr.send(formDataVenta);
			window.alert("Venta registrada");
			location.reload();
			
		}
	   
	</script>

</body>
</html>