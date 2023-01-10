package com.nttdata.spring.services;

import java.util.List;

import com.nttdata.spring.repository.Producto;

/**
 * Interfaz de servicio que calcula el precio PVP de los productos.
 * @author jcoro
 * 
 */
public interface PrecioManagementServiceI {
	/**
	 * Calcula el precioPVP de varios productos
	 * @param productos Una lista de productos a las que se le calcula el precio PVP.
	 * @return productos La misma lista de productos con el precio PVP calculado.
	 */
	public List<Producto> calcularPrecioPVP(List<Producto> productos);
}
