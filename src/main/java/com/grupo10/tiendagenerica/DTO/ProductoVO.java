package com.grupo10.tiendagenerica.DTO;

import java.io.Serializable;

//todas las clases entidad deben ser serializables
//los datos del CLIENTE se puedne convertir en binario, se serializa
//serializacion, capacidad de un dato en java 

public class ProductoVO implements Serializable{
	
	//Identificador de llave para codificar la serializacion
			private static final long serialVersionUID = 1L;
			
			//atributos en privado para la encapsulacion
			private Integer codigo_producto;
			private Double iva_compra;
			private Integer nit_proveedor;
			private String nombre_producto;
			private Double precio_compra;
			private Double precio_venta;
			
			//Creacion de setters y getters
			
			public Integer getCodigo_producto() {
				return codigo_producto;
			}
			public void setCodigo_producto(Integer codigo_producto) {
				this.codigo_producto = codigo_producto;
			}
			public Double getIva_compra() {
				return iva_compra;
			}
			public void setIva_compra(Double iva_compra) {
				this.iva_compra = iva_compra;
			}
			public Integer getNit_proveedor() {
				return nit_proveedor;
			}
			public void setNit_proveedor(Integer nit_proveedor) {
				this.nit_proveedor = nit_proveedor;
			}
			public String getNombre_producto() {
				return nombre_producto;
			}
			public void setNombre_producto(String nombre_producto) {
				this.nombre_producto = nombre_producto;
			}
			public Double getPrecio_compra() {
				return precio_compra;
			}
			public void setPrecio_compra(Double precio_compra) {
				this.precio_compra = precio_compra;
			}
			public Double getPrecio_venta() {
				return precio_venta;
			}
			public void setPrecio_venta(Double precio_venta) {
				this.precio_venta = precio_venta;
			}
			
			

}
