package com.grupo10.tiendagenerica.DTO;

import java.io.Serializable;
//todas las clases entidad deben ser serializables
//los datos del CLIENTE se puedne convertir en binario, se serializa
//serializacion, capacidad de un dato en java 

public class Detalle_VentasVO implements Serializable {

	// Identificador de llave para codificar la serializacion
	private static final long serialVersionUID = 1L;

	// atributos en privado para la encapsulacion
	private Integer codigo_detalle_venta;
	private Integer cantidad_producto;
	private Integer codigo_producto;
	private Integer codigo_venta;
	private Double valor_total;
	private Double valor_venta;
	private Double valor_iva;

	// Creacion de setters y getters

	public Integer getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}

	public void setCodigo_detalle_venta(Integer codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}

	public Integer getCantidad_producto() {
		return cantidad_producto;
	}

	public void setCantidad_producto(Integer cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}

	public Integer getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(Integer codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public Integer getCodigo_venta() {
		return codigo_venta;
	}

	public void setCodigo_venta(Integer codigo_venta) {
		this.codigo_venta = codigo_venta;
	}

	public Double getValor_total() {
		return valor_total;
	}

	public void setValor_total(Double valor_total) {
		this.valor_total = valor_total;
	}

	public Double getValor_venta() {
		return valor_venta;
	}

	public void setValor_venta(Double valor_venta) {
		this.valor_venta = valor_venta;
	}

	public Double getValor_iva() {
		return valor_iva;
	}

	public void setValor_iva(Double valor_iva) {
		this.valor_iva = valor_iva;
	}

}
