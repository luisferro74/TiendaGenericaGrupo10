package com.grupo10.tiendagenerica.DTO;

import java.io.Serializable;

//todas las clases entidad deben ser serializables
//los datos del usuario se puedne convertir en binario, se serializa
//serializacion, capacidad de un dato en java 
public class UsuarioVO implements Serializable{

	//Identificador de llave para codificar la serializacion
	private static final long serialVersionUID = 1L;
	
	//atributos en privado para la encapsulacion
	private Integer cedula_usuario;
	private String email_usuario;
	private String nombre_usuario;
	private String password;
	private String usuario;
	
	//Creacion de setters y getters
	public Integer getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(Integer cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	public String getEmail_usuario() {
		return email_usuario;
	}
	public void setEmail_usuario(String email_usuario) {
		this.email_usuario = email_usuario;
	}
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
