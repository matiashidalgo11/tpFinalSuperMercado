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
	
	public boolean agregar(Producto p)
	{
		return arreglo.agregar(p);
	}
	
	public boolean quitar(long id)
	{
		return arreglo.eliminar(id);
	}
	
	public double sumaTotalCarro()
	{
		return arreglo.sumaTotal();
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
	
	
	
	
}
