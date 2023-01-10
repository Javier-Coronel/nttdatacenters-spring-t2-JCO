package com.nttdata.spring.repository;

import java.util.List;

/**
 * Esta clase simula ser una entidad de una base de datos.
 * @author jcoro
 *
 */
public class Pedido {
	
	/** El id del pedido. */
	private Long pedidoIdentificador;
	
	/** El destinatario del pedido. */
	private String destinatario;
	
	/** La direccion de entrega del pedido. */
	private String direccionDeEntrega;
	
	/** La verificacion de si el envio es para un conjunto de zonas especificas. */
	private boolean envioParaCeutaMelillaOCanarias;
	
	/** La lista de productos del pedido. */
	private List<Producto> productos;

	/**
	 * 
	 * @return el id del pedido.
	 */
	public Long getPedidoIdentificador() {
		return pedidoIdentificador;
	}

	/**
	 * 
	 * @param pedidoIdentificador
	 */
	public void setPedidoIdentificador(Long pedidoIdentificador) {
		this.pedidoIdentificador = pedidoIdentificador;
	}

	/**
	 * 
	 * @return el destinatario del pedido.
	 */
	public String getDestinatario() {
		return destinatario;
	}

	/**
	 * 
	 * @param destinatario
	 */
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	/**
	 * 
	 * @return la direccion de entrega del pedido.
	 */
	public String getDireccionDeEntrega() {
		return direccionDeEntrega;
	}

	/**
	 * 
	 * @param direccionDeEntrega
	 */
	public void setDireccionDeEntrega(String direccionDeEntrega) {
		this.direccionDeEntrega = direccionDeEntrega;
	}

	/**
	 * 
	 * @return si el envio es para un conjunto de zonas especificas.
	 */
	public boolean isEnvioParaCeutaMelillaOCanarias() {
		return envioParaCeutaMelillaOCanarias;
	}

	/**
	 * 
	 * @param envioParaCeutaMelillaOCanarias
	 */
	public void setEnvioParaCeutaMelillaOCanarias(boolean envioParaCeutaMelillaOCanarias) {
		this.envioParaCeutaMelillaOCanarias = envioParaCeutaMelillaOCanarias;
	}

	/**
	 * 
	 * @return el conjunto de productos relaccionados con el pedido.
	 */
	public List<Producto> getProductos() {
		return productos;
	}

	/**
	 * 
	 * @param productos
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Identificador del pedido " + pedidoIdentificador + ", destinatario " + destinatario
				+ ", direccion de entrega " + direccionDeEntrega + ", envio para Ceuta Melilla o Canarias "
				+ envioParaCeutaMelillaOCanarias + ", productos " + productos + ".";
	}
}
