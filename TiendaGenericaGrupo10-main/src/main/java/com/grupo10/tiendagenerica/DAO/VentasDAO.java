package com.grupo10.tiendagenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.grupo10.tiendagenerica.DTO.VentasVO;

public class VentasDAO {

	// Registrar un nuevo usuario

	public void registrarVenta(VentasVO user) {
		// llama y crea una instancia de la clase encargada de hacer la conexión
		Conexion conex = new Conexion();

		try {
			// sentencia que se ejecutara en la base de datos
			Statement estatuto = conex.getConnection().createStatement();

			// String que contiene la sentencia insert a ejecutar
			String sentencia = "INSERT INTO ventas VALUES(" + user.getCodigo_venta() + "," + user.getCedula_cliente()
					+ "," + user.getCedula_usuario() + "," + user.getIva_venta() + "," + user.getTotal_venta() + ","
					+ user.getValor_venta() + ");";

			// se ejecuta la sentencia en la base de datos
			estatuto.executeUpdate(sentencia);

			// impresión en consola para verificación
			System.out.println("Registrado " + sentencia);

			// cerrando la sentencia y la conexión
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			// si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			// si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}// fin registrar producto

	/**
	 * permite consultar el Proveedor asociado al user enviado como parametro
	 * 
	 * @param documento
	 * @return
	 */
	public ArrayList<VentasVO> consultarVenta(Integer codigo_venta) {

		// lista que contendra el o los proveedor obtenidos
		ArrayList<VentasVO> listaventas = new ArrayList<VentasVO>();

		// instancia de la conexión
		Conexion conex = new Conexion();

		try {
			// prepare la sentencia en la base de datos
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM ventas where codigo_venta = ? ");

			// se cambia el comodin ? por el dato que ha llegado en el parametro de la
			// funcion
			consulta.setInt(1, codigo_venta);

			// ejecute la sentencia
			ResultSet res = consulta.executeQuery();

			// cree un objeto basado en la clase entidad con los datos encontrados
			if (res.next()) {
				VentasVO Venta = new VentasVO();
				Venta.setCodigo_venta(Integer.parseInt(res.getString("codigo_venta")));
				Venta.setCedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
				Venta.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
				Venta.setIva_venta(Double.parseDouble(res.getString("iva_venta")));
				Venta.setTotal_venta(Double.parseDouble(res.getString("total_venta")));
				Venta.setValor_venta(Double.parseDouble(res.getString("valor_venta")));

				listaventas.add(Venta);
			}

			// cerrar resultado, sentencia y conexión
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			// si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			// si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return listaventas;
	}// fin consultar venta

	/**
	 * permite consultar la lista de todos las ventas
	 * 
	 * @return
	 */
	public ArrayList<VentasVO> listaDeVentas() {
		// lista que contendra el o los proveedores obtenidos
		ArrayList<VentasVO> listaventas = new ArrayList<VentasVO>();

		// instancia de la conexión
		Conexion conex = new Conexion();

		try {
			// prepare la sentencia en la base de datos
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM ventas");

			// ejecute la sentencia
			ResultSet res = consulta.executeQuery();

			// cree un objeto para cada encontrado en la base de datos basado en la clase
			// entidad con los datos encontrados
			while (res.next()) {
				VentasVO Venta = new VentasVO();
				Venta.setCodigo_venta(Integer.parseInt(res.getString("codigo_venta")));
				Venta.setCedula_cliente(Integer.parseInt(res.getString("cedula_cliente")));
				Venta.setCedula_usuario(Integer.parseInt(res.getString("cedula_usuario")));
				Venta.setIva_venta(Double.parseDouble(res.getString("iva_venta")));
				Venta.setTotal_venta(Double.parseDouble(res.getString("total_venta")));
				Venta.setValor_venta(Double.parseDouble(res.getString("valor_venta")));

				listaventas.add(Venta);
			}

			// cerrar resultado, sentencia y conexión
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			// si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los productos");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			// si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los pproductos");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

		return listaventas;
	}// mostrar ventas

	public void eliminarVenta(Integer codigo_venta) {

		// instancia de la conexion
		Conexion conex = new Conexion();

		try {
			// sentencia inicializada
			Statement consulta = conex.getConnection().createStatement();

			// preparando sentencia a realizar
			String sentencia = "delete from ventas where codigo_venta=" + codigo_venta + ";";

			// impresion de verificación
			System.out.println("Registrado " + sentencia);

			// ejecutando la sentencia en la base de datos
			consulta.execute(sentencia);

			// cerrando sentencia y conexión
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			// si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			// si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}// eliminar venta

	public void actualizarVenta(VentasVO user) {

		// instancia de conexion
		Conexion conex = new Conexion();

		try {
			// inicializando sentencia
			Statement estatuto = conex.getConnection().createStatement();

			// String con la sentencia a ejecutar
			String sentencia = "UPDATE ventas " + "SET cedula_cliente = " + user.getCedula_cliente() + ", "
					+ "cedula_usuario = " + user.getCedula_usuario() + ", " + "iva_venta = " + user.getIva_venta()
					+ ", " + "total_venta = " + user.getTotal_venta() + ", " + "valor_venta = " + user.getValor_venta()
					+ " " + "WHERE codigo_venta = " + user.getCodigo_venta() + ";";

			// ejecuta la sentencia
			estatuto.executeUpdate(sentencia);

			// verificación por consola de la sentencia
			System.out.println("Registrado " + sentencia);

			// cerrando sentencia y conexión
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			// si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo actualizar  la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			// si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo actualizar la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}// actualizar venta

	public int contarVenta() {
		// instancia de conexion
		Conexion conex = new Conexion();
		int numero=0;
		
		try {
			// inicializando sentencia
			Statement estatuto = conex.getConnection().createStatement();

			// String con la sentencia a ejecutar
			String sentencia = "Select count(codigo_venta)from ventas;";

			// ejecuta la sentencia y la guarda en un resultset
			ResultSet res= estatuto.executeQuery(sentencia);
			
			
			// cree un objeto basado en la clase entidad con los datos encontrados
			if (res.next()) {
				//si encontro algo lo guarda
				numero = res.getInt(1);
			}

			// verificación por consola de la sentencia
			System.out.println("Hay " + numero + " ventas ");

			// cerrando sentencia y conexión
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			// si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se buscar las ventas");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			// si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo buscar las ventas");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

		return numero;
	}// contar ventas

}
