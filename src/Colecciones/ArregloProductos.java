package Colecciones;

import productos.Producto;

public class ArregloProductos extends arregloGenerico<Producto> {

	
	arregloGenerico<Producto> arreglo;
	
	public ArregloProductos() {
		
		arreglo = new arregloGenerico<Producto>();
		
	}
	
	public boolean eliminar(long id)
	{
		boolean resp = false;
		
		if(this.existencia(id))
		{
			Producto  aux = this.buscar(id);
			arreglo.eliminar(aux);
			resp = true;
		}
		
		
		return resp;
	}
	
	public boolean existencia(long id)
	{
		boolean resp = false;
	
		for(Producto aux : arreglo.getArreglo())
		{
			if(aux.getIdProducto() == id)
			{
				resp = true;
			}
		}
		
		return resp;
	}
	
	public Producto buscar(long id) throws NullPointerException
	{
		Producto resp = null;
		
		for(Producto aux : arreglo.getArreglo())
		{
			if(aux.getIdCategoria() == id)
			{
				resp = aux;
			}
		}
		
		if(resp == null)
		{
			throw new NullPointerException();
		}
		
		return resp;
	}
	
	public double sumaTotal()
	{
		double resp = 0;
		
		for(Producto aux : arreglo.getArreglo())
		{
			resp =+ aux.getPrecio();
		}
		
		return resp;
	}
	
	
	
 }
