package com.grupo10.tiendagenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.grupo10.tiendagenerica.DTO.Detalle_VentasVO;

public class Detalle_VentasDAO {

	// Registrar un nuevo usuario

	public void registrarDetalleVenta(Detalle_VentasVO user) {
		// llama y crea una instancia de la clase encargada de hacer la conexión
		Conexion conex = new Conexion();

		try {
			// sentencia que se ejecutara en la base de datos
			Statement estatuto = conex.getConnection().createStatement();

			// String que contiene la sentencia insert a ejecutar
			String sentencia = "INSERT INTO detalle_ventas VALUES(" + user.getCodigo_detalle_venta() + ","
					+ user.getCantidad_producto() + "," + user.getCodigo_producto() + "," + user.getCodigo_venta() + ","
					+ user.getValor_total() + "," + user.getValor_venta() + "," + user.getValor_iva() + ");";

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
			System.out.println("No se pudo insertar el detalle venta");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			// si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar el detalle venta");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}// fin registrar detalle_venta

	/**
	 * permite consultar el Proveedor asociado al user enviado como parametro
	 * 
	 * @param documento
	 * @return
	 */
	public ArrayList<Detalle_VentasVO> consultarDetalleVenta(Integer codigo_detalle_venta) {

		// lista que contendra el o los proveedor obtenidos
		ArrayList<Detalle_VentasVO> listadetalleventas = new ArrayList<Detalle_VentasVO>();

		// instancia de la conexión
		Conexion conex = new Conexion();

		try {
			// prepare la sentencia en la base de datos
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM detalle_ventas where codigo_detalle_venta = ? ");

			// se cambia el comodin ? por el dato que ha llegado en el parametro de la
			// funcion
			consulta.setInt(1, codigo_detalle_venta);

			// ejecute la sentencia
			ResultSet res = consulta.executeQuery();

			// cree un objeto basado en la clase entidad con los datos encontrados
			if (res.next()) {
				Detalle_VentasVO DetalleVenta = new Detalle_VentasVO();
				DetalleVenta.setCodigo_detalle_venta(Integer.parseInt(res.getString("codigo_detalle_venta")));
				DetalleVenta.setCantidad_producto(Integer.parseInt(res.getString("cantidad_producto")));
				DetalleVenta.setCodigo_producto(Integer.parseInt(res.getString("codigo_producto")));
				DetalleVenta.setCodigo_venta(Integer.parseInt(res.getString("codigo_venta")));
				DetalleVenta.setValor_total(Double.parseDouble(res.getString("valor_total")));
				DetalleVenta.setValor_venta(Double.parseDouble(res.getString("valor_venta")));
				DetalleVenta.setValor_iva(Double.parseDouble(res.getString("valor_iva")));
				listadetalleventas.add(DetalleVenta);
			}

			// cerrar resultado, sentencia y conexión
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			// si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar el detalle venta");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			// si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar el detalle venta");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return listadetalleventas;
	}// fin consultar venta

	/**
	 * permite consultar la lista de todos las ventas
	 * 
	 * @return
	 */
	public ArrayList<Detalle_VentasVO> listaDetalleVentas() {
		// lista que contendra el o los proveedores obtenidos
		ArrayList<Detalle_VentasVO> listadetalleventas = new ArrayList<Detalle_VentasVO>();

		// instancia de la conexión
		Conexion conex = new Conexion();

		try {
			// prepare la sentencia en la base de datos
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM detalle_ventas");

			// ejecute la sentencia
			ResultSet res = consulta.executeQuery();

			// cree un objeto para cada encontrado en la base de datos basado en la clase
			// entidad con los datos encontrados
			while (res.next()) {
				Detalle_VentasVO DetalleVenta = new Detalle_VentasVO();
				DetalleVenta.setCodigo_detalle_venta(Integer.parseInt(res.getString("codigo_detalle_venta")));
				DetalleVenta.setCantidad_producto(Integer.parseInt(res.getString("cantidad_producto")));
				DetalleVenta.setCodigo_producto(Integer.parseInt(res.getString("codigo_producto")));
				DetalleVenta.setCodigo_venta(Integer.parseInt(res.getString("codigo_venta")));
				DetalleVenta.setValor_total(Double.parseDouble(res.getString("valor_total")));
				DetalleVenta.setValor_venta(Double.parseDouble(res.getString("valor_venta")));
				DetalleVenta.setValor_iva(Double.parseDouble(res.getString("valor_iva")));
				listadetalleventas.add(DetalleVenta);

			}

			// cerrar resultado, sentencia y conexión
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			// si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los detalles de ventas");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			// si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los detalle de ventas");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

		return listadetalleventas;
	}// mostrar detalle ventas

	public void eliminarDetalleVenta(Integer codigo_detalle_venta) {

		// instancia de la conexion
		Conexion conex = new Conexion();

		try {
			// sentencia inicializada
			Statement consulta = conex.getConnection().createStatement();

			// preparando sentencia a realizar
			String sentencia = "delete from detalle_ventas where codigo_detalle_venta=" + codigo_detalle_venta + ";";

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
			System.out.println("No se pudo eliminar el detalle de la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			// si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el detalle de la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}// eliminar venta

	public void actualizarDetalleVenta(Detalle_VentasVO user) {

		// instancia de conexion
		Conexion conex = new Conexion();

		try {
			// inicializando sentencia
			Statement estatuto = conex.getConnection().createStatement();

			// String con la sentencia a ejecutar
			String sentencia = "UPDATE detalle_ventas " + "SET cantidad_producto = " + user.getCantidad_producto() + ","
					+ "codigo_producto= " + user.getCodigo_producto() + ", " + "codigo_venta = "
					+ user.getCodigo_venta() + ", " + "valor_total = " + user.getValor_total() + ", " + "valor_venta = "
					+ user.getValor_venta() + ", " + "valor_iva = " + user.getValor_iva() + " "
					+ "WHERE codigo_detalle_venta = " + user.getCodigo_detalle_venta() + ";";

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
			System.out.println("No se pudo actualizar  el detalle de la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			// si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo actualizar el detalle de la venta");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}// actualizar detalle venta
	
	
	public int contardetalleVenta() {
		// instancia de conexion
		Conexion conex = new Conexion();
		int numero=0;
		
		try {
			// inicializando sentencia
			Statement estatuto = conex.getConnection().createStatement();

			// String con la sentencia a ejecutar
			String sentencia = "select count(codigo_detalle_venta) from detalle_ventas;";

			// ejecuta la sentencia y la guarda en un resultset
			ResultSet res= estatuto.executeQuery(sentencia);
			
			
			// cree un objeto basado en la clase entidad con los datos encontrados
			if (res.next()) {
				//si encontro algo lo guarda
				numero = res.getInt(1);
			}

			// verificación por consola de la sentencia
			System.out.println("Hay " + numero + " detalle ventas ");

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
