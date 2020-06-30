package Objetos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import org.json.JSONObject;

import Colecciones.ArregloProductos;
import Interfaces.JsonFunciones;

/**
 *	La Clase guarda en si misma Los productos que se compraron, el monto total y la fecha y hora en la que se creo. Es un registro de lo que se Compro 
 * @author Matias
 *
 */
public class DetalleCompra implements Serializable, JsonFunciones{
	
	private ArregloProductos productos;
	private double montoTotal;
	private String fechaYhora;
	
	/**
	 * Identificador unico para saber que es una Clase Usuario
	 */
	public static String CLAVE_PRODUCTOS = "productos";
	public static String CLAVE_MONTOTOTAL = "montoTotal";
	public static String CLAVE_FECHAHORA = "fechaYhora";
	
	
	public DetalleCompra(ArregloProductos productos) {
		
		this.productos = productos;
		this.montoTotal = productos.sumaTotal();
		LocalTime tiempo = LocalTime.now();
		LocalDate fecha = LocalDate.now();
		fechaYhora = fecha.toString() + " " + tiempo.toString();
		
	}
	

	public ArregloProductos getProductos() {
		return productos;
	}

	public double getMontoTotal() {
		return montoTotal;
	}

	public String getFechaYhora() {
		return fechaYhora;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean resp = false;
		DetalleCompra detalle = null;
		if(obj instanceof DetalleCompra)
		{
			detalle = (DetalleCompra) obj;
			if(this.fechaYhora.equals(detalle.getFechaYhora()))
			{
				resp = true;
				System.out.println("IGUALES");
			}
			
		}
		
		return resp;
	}
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("\nDetalle Compra: \n");
		builder.append(productos.listar());
		builder.append("\nMonto Total: " + montoTotal + "\n");
		builder.append("\nFecha y Hora: " + fechaYhora + "\n");
		
		return builder.toString();
	}


	@Override
	public JSONObject toJson() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
