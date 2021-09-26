package com.grupo10.tiendagenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.grupo10.tiendagenerica.DTO.ProductoVO;
import com.grupo10.tiendagenerica.DTO.ProductoVO;
import com.grupo10.tiendagenerica.DTO.ProductoVO;
import com.grupo10.tiendagenerica.DTO.ProductoVO;


public class ProductoDAO {

	//Registrar un nuevo usuario
	
	public void registrarProducto(ProductoVO user) {
		//llama y crea una instancia de la clase encargada de hacer la conexión
		Conexion conex = new Conexion();

		try {
			//sentencia que se ejecutara en la base de datos
			Statement estatuto = conex.getConnection().createStatement();
			
			//String que contiene la sentencia insert a ejecutar
			String sentencia = "INSERT INTO productos VALUES(" 
					+ user.getCodigo_producto() + "," 
					+ user.getIva_compra() + ","  
					+ user.getNit_proveedor() + ",'"  
					+ user.getNombre_producto()+ "',"  
					+ user.getPrecio_compra() + "," 
					+ user.getPrecio_venta() 
					+ ");";
			
			//se ejecuta la sentencia en la base de datos
			estatuto.executeUpdate(sentencia);

			//impresión en consola para verificación 
			System.out.println("Registrado " + sentencia);
			
			//cerrando la sentencia y la conexión
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar el producto");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo insertar el producto");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}//fin registrar producto
	
	/**
	 * permite consultar el Proveedor asociado al user enviado como parametro
	 * 
	 * @param documento
	 * @return
	 */
	public ArrayList<ProductoVO> consultarProducto(String producto) {
		
		//lista que contendra el o los proveedor obtenidos
		ArrayList<ProductoVO> listaproductos = new ArrayList<ProductoVO>();
		
		//instancia de la conexión
		Conexion conex = new Conexion();

		try {
			//prepare la sentencia en la base de datos
			PreparedStatement consulta = conex.getConnection()
					.prepareStatement("SELECT * FROM productos where codigo_producto = ? ");
			
			// se cambia el comodin ? por el dato que ha llegado en el parametro de la funcion
			consulta.setString(1, producto);
			
			//ejecute la sentencia
			ResultSet res = consulta.executeQuery();
			
			//cree un objeto basado en la clase entidad con los datos encontrados
			if (res.next()) {
				ProductoVO Producto = new ProductoVO();
				Producto.setCodigo_producto(Integer.parseInt(res.getString("codigo_producto")));
				Producto.setIva_compra(Double.parseDouble(res.getString("iva_compra")));
				Producto.setNit_proveedor(Integer.parseInt(res.getString("nit_proveedor")));
				Producto.setNombre_producto(res.getString("nombre_producto"));
				Producto.setPrecio_compra(Double.parseDouble(res.getString("precio_compra")));
				Producto.setPrecio_venta(Double.parseDouble(res.getString("precio_venta")));
				
				listaproductos.add(Producto);
			}
			
			//cerrar resultado, sentencia y conexión
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar el producto");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar el producto");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}
		return listaproductos;
	}//fin consultar productos
	
	/**
	 * permite consultar la lista de todos los productos
	 * 
	 * @return
	 */
	public ArrayList<ProductoVO> listaDeProductos() {
		//lista que contendra el o los proveedores obtenidos
		ArrayList<ProductoVO> listaproductos = new ArrayList<ProductoVO>();
		
		//instancia de la conexión
		Conexion conex = new Conexion();

		try {
			//prepare la sentencia en la base de datos
			PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM productos");
			
			//ejecute la sentencia
			ResultSet res = consulta.executeQuery();
			
			//cree un objeto para cada encontrado en la base de datos basado en la clase entidad con los datos encontrados
			while (res.next()) {
				ProductoVO Producto = new ProductoVO();
				
				Producto.setCodigo_producto(Integer.parseInt(res.getString("codigo_producto")));
				Producto.setIva_compra(Double.parseDouble(res.getString("iva_compra")));
				Producto.setNit_proveedor(Integer.parseInt(res.getString("nit_proveedor")));
				Producto.setNombre_producto(res.getString("nombre_producto"));
				Producto.setPrecio_compra(Double.parseDouble(res.getString("precio_compra")));
				Producto.setPrecio_venta(Double.parseDouble(res.getString("precio_venta")));

				listaproductos.add(Producto);
			}
			
			//cerrar resultado, sentencia y conexión
			res.close();
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los productos");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo consultar todos los pproductos");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

		return listaproductos;
	}//mostrar productos
	
	public void eliminarProveedor(Integer codigo_producto) {
		
		//instancia de la conexion
		Conexion conex = new Conexion();

		try {
			//sentencia inicializada
			Statement consulta = conex.getConnection().createStatement();
			
			//preparando sentencia a realizar
			String sentencia = "delete from productos where codigo_producto=" + codigo_producto + ";";
			
			//impresion de verificación
			System.out.println("Registrado " + sentencia);
			
			//ejecutando la sentencia en la base de datos
			consulta.execute(sentencia);
			
			//cerrando sentencia y conexión
			consulta.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el producto");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el producto");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}//eliminar producto

	
	/*
	public void actualizarProveedor(ProductoVO user) {
		
		//instancia de conexion
		Conexion conex = new Conexion();

		try {
			//inicializando sentencia
			Statement estatuto = conex.getConnection().createStatement();
			
			//String con la sentencia a ejecutar
			String sentencia = "UPDATE proveedores "
					+ "SET ciudad_proveedor = '"+user.getCiudad_proveedor()+"',"
					+ "direccion_proveedor = '"+user.getDireccion_proveedor()+"',"
					+ "nombre_proveedor = '"+user.getNombre_proveedor()+"',"
					+ "telefono_proveedor = '"+user.getTelefono_proveedor()+"' "
					+ "WHERE nit_proveedor = "+user.getNit_proveedor()+";";
			
			//ejecuta la sentencia 
			estatuto.executeUpdate(sentencia);
			
			//verificación por consola de la sentencia
			System.out.println("Registrado " + sentencia);
			
			//cerrando sentencia y conexión
			estatuto.close();
			conex.desconectar();

		} catch (SQLException e) {
			//si hay un error en el sql mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo actualizar  el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
		} catch (Exception e) {
			//si hay cualquier otro error mostrarlo
			System.out.println("------------------- ERROR --------------");
			System.out.println("No se pudo eliminar el proveedor");
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
		}

	}//actualizar proveedor
	
	*/
}
