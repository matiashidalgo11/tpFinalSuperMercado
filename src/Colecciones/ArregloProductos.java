package Colecciones;

import productos.Producto;

public class ArregloProductos extends arregloGenerico<Producto> {


	public ArregloProductos() {
		super();
	}
	
	public boolean eliminar(long id)
	{
		boolean resp = false;
		
		if(this.existencia(id))
		{
			Producto  aux = this.buscar(id);
			super.getArreglo().remove(aux);
			resp = true;
		}
		
		
		return resp;
	}
	
	public boolean existencia(long id)
	{
		boolean resp = false;
	
		for(Producto aux : super.getArreglo())
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
		
		for(Producto aux : super.getArreglo())
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
		
		for(Producto aux : super.getArreglo())
		{
			resp =+ aux.getPrecio();
		}
		
		return resp;
	}
	
	
	
 }
