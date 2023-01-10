package com.nttdata.spring.repository;

/**
 * Esta clase simula ser una entidad de una base de datos.
 * @author jcoro
 *
 */
public class Producto{
	
	/** El id del producto. */
	private Long productoIdentificador;
	
	/** El nombre del producto. */
	private String nombre;
	
	/** El precio del producto con el PVP añadido. */
	private double precioPVP;
	
	/** El precio del producto. */
	private double precio;
	
	/**
	 * 
	 * @return el id del producto.
	 */
	public Long getProductoIdentificador() {
		return productoIdentificador;
	}
	
	/**
	 * 
	 * @param productoIdentificador
	 */
	public void setProductoIdentificador(Long productoIdentificador) {
		this.productoIdentificador = productoIdentificador;
	}
	
	/**
	 * 
	 * @return el nombre del producto.
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * 
	 * @return el precio con PVP del producto.
	 */
	public double getPrecioPVP() {
		return precioPVP;
	}
	
	/**
	 * 
	 * @param precioPVP
	 */
	public void setPrecioPVP(double precioPVP) {
		this.precioPVP = precioPVP;
	}
	
	/**
	 * 
	 * @return el precio del producto.
	 */
	public double getPrecio() {
		return precio;
	}
	
	/**
	 * 
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Identificador del producto " + productoIdentificador + ", nombre " + nombre + ", precioPVP "
				+ precioPVP + ", precio " + precio + ".";
	}
	
}
