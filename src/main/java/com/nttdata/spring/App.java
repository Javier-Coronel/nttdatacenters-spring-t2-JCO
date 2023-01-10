package com.nttdata.spring;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nttdata.spring.repository.Pedido;
import com.nttdata.spring.repository.Producto;
import com.nttdata.spring.services.*;

/**
 * La clase principal del proyecto.
 * @author jcoro
 *
 */
@SpringBootApplication()
public class App implements CommandLineRunner
{
	
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	/** El servicio de la peninsula. */
	@Autowired
	@Qualifier("peninsulaService")
	private PrecioManagementServiceI peninsulaServiceImpl;

	/** El servicio de las zonas que no son la peninsula. */
	@Autowired
	@Qualifier("comunidadesService")
	private PrecioManagementServiceI comunidadesServiceImpl;
	
	// Declaracion de varios Pedidos y productos.
	final Pedido pedidoA = new Pedido();
	final Pedido pedidoB = new Pedido();
	final Pedido pedidoC = new Pedido();
	final Producto producto1 = new Producto();
	final Producto producto2 = new Producto();
	final Producto producto3 = new Producto();
	final Producto producto4 = new Producto();
	final Producto producto5 = new Producto();
	final Producto producto6 = new Producto();
	final Producto producto7 = new Producto();
	final Producto producto8 = new Producto();
	
	/**
	 * 
	 * @param args
	 */
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception{
    	addAtributes();
    	calculaterecioPVP(pedidoA);
    	calculaterecioPVP(pedidoB);
    	calculaterecioPVP(pedidoC);
    	showProductosConPVPYPrecioTotalDelPedido(pedidoA);
    	showProductosConPVPYPrecioTotalDelPedido(pedidoB);
    	showProductosConPVPYPrecioTotalDelPedido(pedidoC);
    }
    
    /**
     * Este metodo añade los atributos a los diferentes productos y pedidos. 
     */
	public void addAtributes() {
    	pedidoA.setPedidoIdentificador(1L);
    	pedidoA.setDestinatario("");
    	pedidoA.setDireccionDeEntrega("");
    	pedidoA.setEnvioParaCeutaMelillaOCanarias(false);
    	pedidoB.setPedidoIdentificador(2L);
    	pedidoB.setDestinatario("");
    	pedidoB.setDireccionDeEntrega("");
    	pedidoB.setEnvioParaCeutaMelillaOCanarias(true);
    	pedidoC.setPedidoIdentificador(3L);
    	pedidoC.setDestinatario("");
    	pedidoC.setDireccionDeEntrega("");
    	pedidoC.setEnvioParaCeutaMelillaOCanarias(false);
    	producto1.setProductoIdentificador(1L);
    	producto1.setNombre("");
    	producto1.setPrecio(2.4);
    	producto2.setProductoIdentificador(2L);
    	producto2.setNombre("");
    	producto2.setPrecio(0.99);
    	producto3.setProductoIdentificador(3L);
    	producto3.setNombre("");
    	producto3.setPrecio(10);
    	producto4.setProductoIdentificador(4L);
    	producto4.setNombre("");
    	producto4.setPrecio(5);
    	producto5.setProductoIdentificador(5L);
    	producto5.setNombre("");
    	producto5.setPrecio(4.99);
    	producto6.setProductoIdentificador(6L);
    	producto6.setNombre("");
    	producto6.setPrecio(9.99);
    	producto7.setProductoIdentificador(7L);
    	producto7.setNombre("");
    	producto7.setPrecio(8);
    	producto8.setProductoIdentificador(8L);
    	producto8.setNombre("");
    	producto8.setPrecio(20);
    	final List<Producto> productosPedidoA = new ArrayList<>();
    	productosPedidoA.add(producto1);
    	productosPedidoA.add(producto2);
    	productosPedidoA.add(producto3);
    	final List<Producto> productosPedidoB = new ArrayList<>();
    	productosPedidoB.add(producto4);
    	productosPedidoB.add(producto5);
    	productosPedidoB.add(producto6);
    	final List<Producto> productosPedidoC = new ArrayList<>();
    	productosPedidoC.add(producto7);
    	productosPedidoC.add(producto8);
    	pedidoA.setProductos(productosPedidoA);
    	pedidoB.setProductos(productosPedidoB);
    	pedidoC.setProductos(productosPedidoC);
    }
	
	/**
	 * Este metodo consume los servicios, comprobando mediante el valor necesario si se utiliza uno u otro.
	 * @param pedido
	 */
    private void calculaterecioPVP(Pedido pedido) {
		if(pedido.isEnvioParaCeutaMelillaOCanarias())pedido.setProductos(comunidadesServiceImpl.calcularPrecioPVP(pedido.getProductos()));
		else pedido.setProductos(peninsulaServiceImpl.calcularPrecioPVP(pedido.getProductos()));
	}
    
    /**
     * Este metodo muestra los productos y muestra el valor total de un pedido.
     * @param pedido
     */
	private void showProductosConPVPYPrecioTotalDelPedido(Pedido pedido) {
		double precioTotal = 0;
		for(Producto producto : pedido.getProductos()) {
    		precioTotal += producto.getPrecioPVP();
			if(LOG.isDebugEnabled())LOG.debug(producto.toString());
    	}
		if(LOG.isDebugEnabled())LOG.debug("Precio total: {}", Math.round(precioTotal*100)/100D);
	}
}
