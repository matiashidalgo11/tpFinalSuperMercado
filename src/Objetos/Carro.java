package Objetos;

import java.io.Serializable;

import Colecciones.ArregloProductos;
import Colecciones.arregloGenerico;
import Interfaces.idInterface;
import productos.Producto;

/**
 * 
 * @author Matias
 * Contiene un ArregloProductos, y el Id al cual pertence a un Usuario que lo este Utilizando
 */
public class Carro implements Serializable, idInterface<Long>{
	
	private double total;
	private ArregloProductos arreglo;
	private long idCarro;
	
	public Carro(ArregloProductos arreglo, long id) {
		
		this.arreglo = arreglo;
		this.total = arreglo.sumaTotal();
		this.idCarro = id;
	}

	public Carro(long id) {
		arreglo = new ArregloProductos();
		this.total = 0;
		this.idCarro = id;
	}
	

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
		if(arreglo.existencia(id))
		{
			Producto aux = arreglo.buscar(id);
			arreglo.eliminar(aux);
			this.total = arreglo.sumaTotal();
			rta = true;
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

	@Override
	public Long getIdPrincipal() {
		
		return null;
	}
	
}
