package com.grupo10.tiendagenerica.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.grupo10.tiendagenerica.DTO.ProveedorVO;

public class ProveedorDAO {
	
	//Registrar un nuevo usuario
	
			public void registrarProveedor(ProveedorVO user) {
				//llama y crea una instancia de la clase encargada de hacer la conexión
				Conexion conex = new Conexion();

				try {
					//sentencia que se ejecutara en la base de datos
					Statement estatuto = conex.getConnection().createStatement();
					
					//String que contiene la sentencia insert a ejecutar
					String sentencia = "INSERT INTO proveedores VALUES(" 
							+ user.getNit_proveedor() + "," + "'"
							+ user.getCiudad_proveedor() + "'," + "'" 
							+ user.getDireccion_proveedor() + "'," + "'" 
							+ user.getNombre_proveedor()+ "'," + "'" 
							+ user.getTelefono_proveedor() + "'" 
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
					System.out.println("No se pudo insertar el proveedor");
					System.out.println(e.getMessage());
					System.out.println(e.getErrorCode());
				} catch (Exception e) {
					//si hay cualquier otro error mostrarlo
					System.out.println("------------------- ERROR --------------");
					System.out.println("No se pudo insertar el proveedor");
					System.out.println(e.getMessage());
					System.out.println(e.getLocalizedMessage());
				}

			}//fin registrar proveedor
			
			
			/**
			 * permite consultar el Proveedor asociado al user enviado como parametro
			 * 
			 * @param documento
			 * @return
			 */
			public ArrayList<ProveedorVO> consultarProveedor(String proveedor) {
				
				//lista que contendra el o los proveedor obtenidos
				ArrayList<ProveedorVO> listaproveedores = new ArrayList<ProveedorVO>();
				
				//instancia de la conexión
				Conexion conex = new Conexion();

				try {
					//prepare la sentencia en la base de datos
					PreparedStatement consulta = conex.getConnection()
							.prepareStatement("SELECT * FROM proveedores where nit_proveedor = ? ");
					
					// se cambia el comodin ? por el dato que ha llegado en el parametro de la funcion
					consulta.setString(1, proveedor);
					
					//ejecute la sentencia
					ResultSet res = consulta.executeQuery();
					
					//cree un objeto basado en la clase entidad con los datos encontrados
					if (res.next()) {
						ProveedorVO Proveedor = new ProveedorVO();
						Proveedor.setNit_proveedor(Integer.parseInt(res.getString("nit_proveedor")));
						Proveedor.setCiudad_proveedor(res.getString("ciudad_proveedor"));
						Proveedor.setDireccion_proveedor(res.getString("direccion_proveedor"));
						Proveedor.setNombre_proveedor(res.getString("nombre_proveedor"));
						Proveedor.setTelefono_proveedor(res.getString("telefono_proveedor"));

						listaproveedores.add(Proveedor);
					}
					
					//cerrar resultado, sentencia y conexión
					res.close();
					consulta.close();
					conex.desconectar();

				} catch (SQLException e) {
					//si hay un error en el sql mostrarlo
					System.out.println("------------------- ERROR --------------");
					System.out.println("No se pudo consultar el proveedor");
					System.out.println(e.getMessage());
					System.out.println(e.getErrorCode());
				} catch (Exception e) {
					//si hay cualquier otro error mostrarlo
					System.out.println("------------------- ERROR --------------");
					System.out.println("No se pudo consultar el proveedor");
					System.out.println(e.getMessage());
					System.out.println(e.getLocalizedMessage());
				}
				return listaproveedores;
			}//fin consultar proveedores
			
			/**
			 * permite consultar la lista de todos los proveedores
			 * 
			 * @return
			 */
			public ArrayList<ProveedorVO> listaDeProveedores() {
				//lista que contendra el o los proveedores obtenidos
				ArrayList<ProveedorVO> listaproveedores = new ArrayList<ProveedorVO>();
				
				//instancia de la conexión
				Conexion conex = new Conexion();

				try {
					//prepare la sentencia en la base de datos
					PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM proveedores");
					
					//ejecute la sentencia
					ResultSet res = consulta.executeQuery();
					
					//cree un objeto para cada encontrado en la base de datos basado en la clase entidad con los datos encontrados
					while (res.next()) {
						ProveedorVO Proveedor = new ProveedorVO();
						Proveedor.setNit_proveedor(Integer.parseInt(res.getString("nit_proveedor")));
						Proveedor.setCiudad_proveedor(res.getString("ciudad_proveedor"));
						Proveedor.setDireccion_proveedor(res.getString("direccion_proveedor"));
						Proveedor.setNombre_proveedor(res.getString("nombre_proveedor"));
						Proveedor.setTelefono_proveedor(res.getString("telefono_proveedor"));

						listaproveedores.add(Proveedor);
					}
					
					//cerrar resultado, sentencia y conexión
					res.close();
					consulta.close();
					conex.desconectar();

				} catch (SQLException e) {
					//si hay un error en el sql mostrarlo
					System.out.println("------------------- ERROR --------------");
					System.out.println("No se pudo consultar todos los proveedores");
					System.out.println(e.getMessage());
					System.out.println(e.getErrorCode());
				} catch (Exception e) {
					//si hay cualquier otro error mostrarlo
					System.out.println("------------------- ERROR --------------");
					System.out.println("No se pudo consultar todos los proveedores");
					System.out.println(e.getMessage());
					System.out.println(e.getLocalizedMessage());
				}

				return listaproveedores;
			}//mostrar proveedores

			public void eliminarProveedor(Integer nit_proveedor) {
				
				//instancia de la conexion
				Conexion conex = new Conexion();

				try {
					//sentencia inicializada
					Statement consulta = conex.getConnection().createStatement();
					
					//preparando sentencia a realizar
					String sentencia = "delete from proveedores where nit_proveedor=" + nit_proveedor + ";";
					
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
					System.out.println("No se pudo eliminar el proveedor");
					System.out.println(e.getMessage());
					System.out.println(e.getErrorCode());
				} catch (Exception e) {
					//si hay cualquier otro error mostrarlo
					System.out.println("------------------- ERROR --------------");
					System.out.println("No se pudo eliminar el proveedor");
					System.out.println(e.getMessage());
					System.out.println(e.getLocalizedMessage());
				}

			}//eliminar proveedor

			public void actualizarProveedor(ProveedorVO user) {
				
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

}
