package com.nttdata.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nttdata.spring.repository.Producto;

/**
 * Servicio que calcula el precio PVP para las zonas que no son de la peninsula.
 * @author jcoro
 *
 */
@Service("comunidadesService")
public class OtrasComunidadesServiceImpl implements PrecioManagementServiceI {

	@Override
	public List<Producto> calcularPrecioPVP(List<Producto> productos) {
		for(Producto producto : productos) {
			producto.setPrecioPVP(Math.round(producto.getPrecio()*1.04D*100)/100D);
		}
		return productos;
	}

}
