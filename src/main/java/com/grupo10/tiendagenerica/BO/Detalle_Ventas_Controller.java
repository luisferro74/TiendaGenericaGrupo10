package com.grupo10.tiendagenerica.BO;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo10.tiendagenerica.DAO.Detalle_VentasDAO;
import com.grupo10.tiendagenerica.DTO.Detalle_VentasVO;

@RestController
public class Detalle_Ventas_Controller {

	/*
	 * @GetMapping obtener o buscar
	 * 
	 * @PostMapping insertar o agregar
	 * 
	 * @PutMapping modificar o actualizar
	 * 
	 * @DeleteMapping eliminar o borrar
	 */

	@PostMapping("/registrardetalleventa")
	public void registrardetalleventa(Detalle_VentasVO venta) {
		Detalle_VentasDAO Dao = new Detalle_VentasDAO();
		Dao.registrarDetalleVenta(venta);
	}

	@GetMapping("/consultardetalleventas")
	public ArrayList<Detalle_VentasVO> consultardetalleventa(Integer codigo_detalle_venta) {
		Detalle_VentasDAO Dao = new Detalle_VentasDAO();
		return Dao.consultarDetalleVenta(codigo_detalle_venta);
	}

	@GetMapping("/listardetalleventas")
	public ArrayList<Detalle_VentasVO> listaDetalleVentas() {
		Detalle_VentasDAO Dao = new Detalle_VentasDAO();
		return Dao.listaDetalleVentas();
	}

	@DeleteMapping("/eliminardetalleventa")
	public void eliminarDetalleVenta(Integer codigo_detalle_venta) {
		Detalle_VentasDAO Dao = new Detalle_VentasDAO();
		Dao.eliminarDetalleVenta(codigo_detalle_venta);
	}

	@PutMapping("/actualizardetalleventa")
	public void actualizarDetalleVenta(Detalle_VentasVO detalle_venta) {
		Detalle_VentasDAO Dao = new Detalle_VentasDAO();
		Dao.actualizarDetalleVenta(detalle_venta);
	}
	
	@GetMapping("/contardetallerventa")
	public int contardetalleVenta() {
		int numero;
		Detalle_VentasDAO Dao = new Detalle_VentasDAO();
		numero= Dao.contardetalleVenta();
		return numero;
	}
	
	

}
