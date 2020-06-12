package Objetos;

import Colecciones.ArregloProductos;
import Colecciones.arregloGenerico;
import productos.Producto;

public class Carro {
	
	private double total;
	private ArregloProductos arreglo;
	
	public Carro(ArregloProductos arreglo) {
		
		this.arreglo = arreglo;
		this.total = arreglo.sumaTotal();
	}

	public Carro() {
		arreglo = new ArregloProductos();
		this.total = 0;
	}
	
	/** falta poner condiciones para que si ya esta el mismo producto suma el stock*/
	public boolean agregar(Producto p)
	{
		boolean rta = false;
		if(p.getStock() > 0 )
		{	
			arreglo.agregar(p);
			this.total += p.getPrecio();
			rta = true;
		}
		
		return rta;
	}
	
	public boolean quitar(long id)
	{
		boolean rta = false;
		if(arreglo.eliminar(id))
		{
			this.total = arreglo.sumaTotal();
		}
		return rta;
	}
	
	

	public double sumaTotalCarro()
	{
		return arreglo.sumaTotal();
	}
	
	public int cantidadProductos()
	{
		return arreglo.cantidad();
	}
	
	public DetalleCompra generarDetllaCompra() throws NullPointerException
	{
		DetalleCompra resp = null;
		
		if(arreglo.cantidad() > 0)
		{
			resp = new DetalleCompra(arreglo);
		}else
		{
			throw new NullPointerException();
		}
		
		
		return resp;
	}
	
	public void limpiarCarrito()
	{
		this.total = 0;
		this.arreglo.vaciar();
	}
	
	public String listar()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Informacion Carrito");
		if(arreglo.cantidad() > 0)
		{
			builder.append(arreglo.listar());
			builder.append(total);
		}else
		{
			builder.append("\nVACIO\n");
		}
		
		
		return builder.toString();
	}
	
	public ArregloProductos getArreglo() {
		return arreglo;
	}

	public void setArreglo(ArregloProductos arreglo) {
		this.arreglo = arreglo;
	}
	
	public boolean isEmpty()
	{
		boolean resp = false;
		if(arreglo.cantidad() == 0)
		{
			resp = true;
		}
		
		return resp;
	}
	
}
