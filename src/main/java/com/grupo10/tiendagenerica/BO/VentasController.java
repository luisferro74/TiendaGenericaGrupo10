package com.grupo10.tiendagenerica.BO;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo10.tiendagenerica.DAO.VentasDAO;
import com.grupo10.tiendagenerica.DTO.VentasVO;


@RestController
public class VentasController {

	/*
	 * @GetMapping obtener o buscar
	 * @PostMapping insertar o agregar
	 * @PutMapping modificar o actualizar
	 * @DeleteMapping eliminar o borrar
	 * */
	
	@PostMapping("/registrarventa")
	public void registrarventa(VentasVO venta) {
		VentasDAO Dao = new VentasDAO();
		Dao.registrarVenta(venta);	
		}
	
	@GetMapping("/consultarventas")
	public ArrayList<VentasVO> consultarventa(Integer codigo_venta) {
		VentasDAO Dao = new VentasDAO();
		return Dao.consultarVenta(codigo_venta);
	}
	
	@GetMapping("/listarventas")
	public ArrayList<VentasVO> listaDeVentas() {
		VentasDAO Dao = new VentasDAO();
		return Dao.listaDeVentas();
	}
	
	
	@DeleteMapping("/eliminarventa")
	public void eliminarVenta(Integer codigo_venta) {
		VentasDAO Dao = new VentasDAO();
		Dao.eliminarVenta(codigo_venta);
	}
	
	@PutMapping("/actualizarventa")
	public void actualizarVenta(VentasVO venta) {
		VentasDAO Dao = new VentasDAO();
		Dao.actualizarVenta(venta);
	}
	
}
