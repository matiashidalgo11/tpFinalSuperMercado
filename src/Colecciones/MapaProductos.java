package Colecciones;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map.Entry;

import ColeccionesGenericas.ArregloGenerico;
import ColeccionesGenericas.MapaGenerico;
import Interfaces.IdMaximo;
import Productos.Producto;

public class MapaProductos extends MapaGenerico<Long, Producto> implements IdMaximo{

	public MapaProductos()
	{
		super();
	}
	
	public String getNombreProducto(int i)
	{
		Producto nuevo = buscar((long)i);
		return nuevo.getNombre();
	}
	
	public String getNombreCategoria()
	{
		Iterator<Entry<Long, Producto>> it = getIterator();
		String nombre = null;
		
		if(it.hasNext())
		{
			Entry<Long, Producto> entrada = it.next();
			nombre = entrada.getValue().getNombreCategoria();
		}
		
		return nombre;
	}
	
	public Long getIdMasAlto()
	{
		Iterator<Entry<Long, Producto>> it = getIterator();
		long id = 1;
		
		while(it.hasNext())
		{
			Entry<Long, Producto> entrada = it.next();
			if(entrada.getValue().getId() > id)
			{
				id = entrada.getValue().getId();
			}
		}
		
		return id;
	}
	
	public Long getPrimerId()
	{
		Iterator<Entry<Long, Producto>> it = getIterator();
		long id = 0;
		
		if(it.hasNext())
		{
			Entry<Long, Producto> entrada = it.next();
			if(entrada.getValue().getId() > id)
			{
				id = entrada.getValue().getId();
			}
		}
		
		return id;
	}
	
	public Producto getProductoPorNombre(String nombre)
	{
		Producto buscado = null;
		Iterator<Entry<String, Producto>> it = super.getIterator();
		
		while(it.hasNext())
		{
			Entry<String, Producto> entrada = it.next();
			
			if(entrada.getValue().getNombre().equals(nombre))
			{
				buscado = entrada.getValue();
			}
		}
		
		return buscado;
	}
	
	public boolean compararProductos(Producto p)
	{
		boolean esIgual = false;
		Iterator<Entry<String, Producto>> it = super.getIterator();
		while(it.hasNext() && esIgual == false)
		{
			Entry<String, Producto> entrada = it.next();
			if(entrada.getValue().equals(p))
			{
				esIgual = true;
			}
		}
		
		return esIgual;
	}
	
	/**
	 * Recorrer y buscar los Productos en Oferta
	 * @return la cantidad de Productos en Oferta
	 */
	public int cantidadDeProductosEnOferta()
	{
		int resp = 0;
		
		Iterator<Entry<Long, Producto>> it = this.getIterator();
		
		while(it.hasNext())
		{
			Entry<Long, Producto> entrada = it.next();
			Producto aux = entrada.getValue();
			if(aux.isOferta())
			{
				resp++;
			}
			
		}
		

		
		return resp;
	}
	
	public ArregloGenerico<Producto> mapaToArreglo()
	{
		ArregloGenerico<Producto> arreglo = null;
		Iterator<Entry<String, Producto>> it = this.getIterator();
		
		while(it.hasNext())
		{
			Entry<String, Producto> entrada = it.next();
			arreglo.agregar(entrada.getValue());
		}
		
		return arreglo;
	}
}
